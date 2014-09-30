package com.td.pact.service.appointment;

import com.td.dto.AppointmentDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/30/14
 * Time: 9:21 AM
 */
public interface AppointmentService {


  public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

  public void updateAppointmentStatus(Long appointmentId, Long statusId);

  public List<AppointmentDTO> getAppointmentsForDoctor(Long doctorId);

  public List<AppointmentDTO> getAppointmentsForUser(Long userId);
}
