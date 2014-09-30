package com.td.web.action.appointment;

import com.td.domain.doctor.Doctor;
import com.td.dto.AppointmentDTO;
import com.td.pact.service.appointment.AppointmentService;
import com.td.pact.service.auth.DoctorService;
import com.td.pact.service.user.UserService;
import com.td.web.action.BaseAction;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/30/14
 * Time: 11:18 AM
 */
@Component
public class BookAppointmentAction extends BaseAction {

  private AppointmentDTO appointmentDTO;
  private AppointmentDTO confirmedAppointmentDTO;

  private Doctor doctor;
  private String dateTimeOfVisit;
  private Long doctorId;

  @Autowired
  private AppointmentService appointmentService;
  @Autowired
  private DoctorService doctorService;
  @Autowired
  private UserService userService;

  @DefaultHandler
  public Resolution pre() {


    this.doctor = getDoctorService().getDoctorById(doctorId);
    return new ForwardResolution("/pages/appointment/bookAppointment.jsp").addParameter("doctorId", doctorId);
  }

  public Resolution bookAppointment() {

    String arr[] = dateTimeOfVisit.split(" ");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    if (this.appointmentDTO == null) {
      appointmentDTO = new AppointmentDTO();
      appointmentDTO.setUserId(getUserService().getLoggedInUserId());
      appointmentDTO.setDoctorId(this.doctorId);
    }

    try {
      appointmentDTO.setAppointmentDate(formatter.parse(arr[0]));
      appointmentDTO.setAppointmentTime(arr[1]);

    } catch (ParseException e) {
      e.printStackTrace();
    }
    confirmedAppointmentDTO = getAppointmentService().createAppointment(appointmentDTO);

    return new ForwardResolution("/pages/appointment/appointmentSuccess.jsp");
  }

  public AppointmentDTO getAppointmentDTO() {
    return appointmentDTO;
  }

  public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
    this.appointmentDTO = appointmentDTO;
  }

  public AppointmentService getAppointmentService() {
    return appointmentService;
  }

  public void setAppointmentService(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  public AppointmentDTO getConfirmedAppointmentDTO() {
    return confirmedAppointmentDTO;
  }

  public void setConfirmedAppointmentDTO(AppointmentDTO confirmedAppointmentDTO) {
    this.confirmedAppointmentDTO = confirmedAppointmentDTO;
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

  public void setDoctorService(DoctorService doctorService) {
    this.doctorService = doctorService;
  }

  public String getDateTimeOfVisit() {
    return dateTimeOfVisit;
  }

  public void setDateTimeOfVisit(String dateTimeOfVisit) {
    this.dateTimeOfVisit = dateTimeOfVisit;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public UserService getUserService() {
    return userService;
  }
}
