package com.td.constants.appointment;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/30/14
 * Time: 10:41 AM
 */
public enum EnumAppointmentStatus {

  PENDING_CONFRIMATION(10, "Pending Confirmation"),

  CONFIRMED(20, "Confirmed"),

  ATTENDED(30, "Attended"),

  CANCELLED(40, "Cancelled");

  private int id;
  private String name;

  EnumAppointmentStatus(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  public static EnumAppointmentStatus getEnumAppointmentStatusById(int id) {
    for (EnumAppointmentStatus enumAppointmentStatus : values()) {
      if (id == enumAppointmentStatus.getId()) {
        return enumAppointmentStatus;
      }
    }

    return null;
  }



  /*public static EnumOprLiStatus getEnumOprLiStatusByName(String name) {
    for (EnumOprLiStatus enumOprLiStatus : values()) {
      if (name.equals(enumOprLiStatus.getName())) {
        return enumOprLiStatus;
      }
    }
    return null;
  }*/


}
