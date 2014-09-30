package com.td.dto;

import com.td.constants.appointment.EnumAppointmentStatus;
import com.td.domain.appointment.Appointment;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/30/14
 * Time: 9:21 AM
 */
public class AppointmentDTO {

  private Long id;
  private Long userId;
  private Long doctorId;

  private String userName;
  private String doctorName;

  private String status;
  private int statusId;

  private Date appointmentDate;
  private String appointmentTime;

  private boolean userCancel;
  private boolean docCancel;


  public AppointmentDTO() {

  }

  public AppointmentDTO(Appointment appointment) {
    this.id = appointment.getId();

    this.userId = appointment.getUser().getId();
    this.doctorId = appointment.getDoctor().getId();
    this.userName = appointment.getUser().getName();
    this.doctorName = appointment.getDoctor().getName();
    this.appointmentDate = appointment.getAppointmentDate();
    this.appointmentTime = appointment.getAppointmentTime();
    this.status = EnumAppointmentStatus.getEnumAppointmentStatusById(appointment.getStatus()).getName();
    this.statusId = appointment.getStatus();
    this.userCancel = (statusId == EnumAppointmentStatus.PENDING_CONFRIMATION.getId() || statusId == EnumAppointmentStatus.CONFIRMED.getId());
    this.docCancel = (statusId == EnumAppointmentStatus.PENDING_CONFRIMATION.getId() || statusId == EnumAppointmentStatus.CONFIRMED.getId());

  }


  public boolean isUserCancel() {
    return userCancel;
  }

  public boolean getDocCancel() {
    return docCancel;
  }

  public void setDocCancel(boolean docCancel) {
    this.docCancel = docCancel;
  }

  public boolean getUserCancel() {

    return userCancel;
  }

  public void setUserCancel(boolean userCancel) {
    this.userCancel = userCancel;
  }


  public int getStatusId() {
    return statusId;
  }

  public void setStatusId(int statusId) {
    this.statusId = statusId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public Date getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(Date appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
