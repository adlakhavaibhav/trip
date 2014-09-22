package com.td.domain.doctor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/21/14
 * Time: 8:36 PM
 */
@Entity
@Table(name = "doctor_speciality")
public class DoctorSpeciality implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "fname", nullable = false)
  private Long doctorId;

  @Column(name = "special", nullable = false)
  private Long specialityId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public Long getSpecialityId() {
    return specialityId;
  }

  public void setSpecialityId(Long specialityId) {
    this.specialityId = specialityId;
  }
}
