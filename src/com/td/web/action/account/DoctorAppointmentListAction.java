package com.td.web.action.account;

import com.td.dto.AppointmentDTO;
import com.td.pact.service.appointment.AppointmentService;
import com.td.pact.service.user.UserService;
import com.td.web.action.BasePaginatedAction;
import com.td.web.action.Page;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/30/14
 * Time: 3:42 PM
 */
@Component
public class DoctorAppointmentListAction extends BasePaginatedAction {

  private Page userAppointmentsPage;
  private List<AppointmentDTO> userAppointmentList;

  private Long appointmentId;
  private Long appStatus;

  @Autowired
  private AppointmentService appointmentService;
  @Autowired
  private UserService userService;


  @Override
  public int getPageCount() {
    return userAppointmentsPage != null ? userAppointmentsPage.getTotalPages() : 0;
  }

  @Override
  public int getResultCount() {
    return userAppointmentsPage != null ? userAppointmentsPage.getTotalResults() : 0;
  }

  @DefaultHandler
  @SuppressWarnings("unchecked")
  public Resolution pre() {
    List<AppointmentDTO> userAppointmens = getAppointmentService().getAppointmentsForDoctor(getUserService().getLoggedInUserId());
    if (userAppointmens != null && userAppointmens.size() > 0) {
      userAppointmentsPage = new Page(userAppointmens, getPerPage(), getPageNo(), userAppointmens.size());
    }

    if (userAppointmentsPage != null) {
      userAppointmentList = userAppointmentsPage.getList();
    }
    return new ForwardResolution("/pages/account/doctor/doctorAppointments.jsp");
  }

  public Resolution updateAppointmentStatus() {
    getAppointmentService().updateAppointmentStatus(appointmentId, appStatus);

    return new RedirectResolution(DoctorAppointmentListAction.class);
  }

  @Override
  public Set<String> getParamSet() {
    HashSet<String> params = new HashSet<String>();


    return params;
  }

  public Page getUserAppointmentsPage() {
    return userAppointmentsPage;
  }

  public void setUserAppointmentsPage(Page userAppointmentsPage) {
    this.userAppointmentsPage = userAppointmentsPage;
  }

  public List<AppointmentDTO> getUserAppointmentList() {
    return userAppointmentList;
  }

  public AppointmentService getAppointmentService() {
    return appointmentService;
  }

  public void setUserAppointmentList(List<AppointmentDTO> userAppointmentList) {
    this.userAppointmentList = userAppointmentList;
  }

  public void setAppointmentService(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  public UserService getUserService() {
    return userService;
  }

  public Long getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(Long appointmentId) {
    this.appointmentId = appointmentId;
  }

  public Long getAppStatus() {
    return appStatus;
  }

  public void setAppStatus(Long appStatus) {
    this.appStatus = appStatus;
  }
}
