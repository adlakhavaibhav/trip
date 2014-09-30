package com.td.domain.appointment;

import com.td.domain.doctor.Doctor;
import com.td.domain.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/30/14
 * Time: 10:28 AM
 */
@NamedQueries({
    @NamedQuery(name = "getAppointmentsForDoctor", query = "from Appointment a where a.doctor.id = :doctorId "),
    @NamedQuery(name = "getAppointmentsForUser", query = "from Appointment a where a.user.id = :userId ")
})

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "ap_date", nullable = false)
  private Date appointmentDate;

  @Column(name = "ap_time", nullable = false)
  private String appointmentTime;

  @Column(name = "status", nullable = false)
  private int status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "doctor_id", nullable = false)
  private Doctor doctor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "medical_center_id", nullable = false)
  private Long medicalCenterId = -1L;

  @Column(name = "user_payment_id", nullable = false)
  private Long paymentId = -1L;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getMedicalCenterId() {
    return medicalCenterId;
  }

  public void setMedicalCenterId(Long medicalCenterId) {
    this.medicalCenterId = medicalCenterId;
  }

  public Long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }
}