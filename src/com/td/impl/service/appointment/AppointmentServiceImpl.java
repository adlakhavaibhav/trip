package com.td.impl.service.appointment;

import com.td.constants.appointment.EnumAppointmentStatus;
import com.td.domain.appointment.Appointment;
import com.td.domain.doctor.Doctor;
import com.td.domain.user.User;
import com.td.dto.AppointmentDTO;
import com.td.pact.dao.BaseDao;
import com.td.pact.service.appointment.AppointmentService;
import com.td.pact.service.auth.DoctorService;
import com.td.pact.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/30/14
 * Time: 10:27 AM
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {


  @Autowired
  private DoctorService doctorService;

  @Autowired
  private UserService userService;

  @Autowired
  private BaseDao baseDao;


  @Override
  @Transactional
  public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
    Appointment appointment = new Appointment();
    Doctor doctor = getDoctorService().getDoctorById(appointmentDTO.getDoctorId());
    appointment.setDoctor(doctor);
    User user = getUserService().getUserById(appointmentDTO.getUserId());
    appointment.setUser(user);


    appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
    appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
    appointment.setStatus(EnumAppointmentStatus.PENDING_CONFRIMATION.getId());

    appointment = (Appointment) getBaseDao().save(appointment);

    return new AppointmentDTO(appointment);
  }

  @Override
  @Transactional
  public void updateAppointmentStatus(Long appointmentId, Long statusId) {
    getBaseDao().executeNativeSql("update appointment set status = ? where id = ?", statusId, appointmentId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<AppointmentDTO> getAppointmentsForDoctor(Long doctorId) {
    List<Appointment> doctorAppointments = (List<Appointment>) getBaseDao().findByNamedQueryAndNamedParam("getAppointmentsForDoctor", new String[]{"doctorId"}, new Object[]{doctorId});

    List<AppointmentDTO> results = new ArrayList<AppointmentDTO>();
    if (doctorAppointments != null) {
      for (Appointment appointment : doctorAppointments) {
        results.add(new AppointmentDTO(appointment));
      }
    }

    return results;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<AppointmentDTO> getAppointmentsForUser(Long userId) {
    List<Appointment> doctorAppointments = (List<Appointment>) getBaseDao().findByNamedQueryAndNamedParam("getAppointmentsForUser", new String[]{"userId"}, new Object[]{userId});

    List<AppointmentDTO> results = new ArrayList<AppointmentDTO>();
    if (doctorAppointments != null) {
      for (Appointment appointment : doctorAppointments) {
        results.add(new AppointmentDTO(appointment));
      }
    }

    return results;
  }


  public DoctorService getDoctorService() {
    return doctorService;
  }

  public void setDoctorService(DoctorService doctorService) {
    this.doctorService = doctorService;
  }

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public BaseDao getBaseDao() {
    return baseDao;
  }

  public void setBaseDao(BaseDao baseDao) {
    this.baseDao = baseDao;
  }
}
