package com.td.web.action.doctor;

import com.td.domain.doctor.Doctor;
import com.td.pact.service.auth.DoctorService;
import com.td.pact.service.user.UserService;
import com.td.web.action.BaseAction;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/22/14
 * Time: 11:31 AM
 */
@Component
public class DoctorProfileAction extends BaseAction {


  private Doctor doctor;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private UserService userService;


  @DefaultHandler
  public Resolution pre() {
    Long doctorId = getUserService().getLoggedInUserId();
    doctor = getDoctorService().getDoctorById(doctorId);

    return new ForwardResolution("/pages/auth/doctorProfile.jsp");

  }


  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public DoctorService getDoctorService() {
    return doctorService;
  }

  public UserService getUserService() {
    return userService;
  }
}
