package com.td.domain.doctor;

import com.td.domain.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/21/14
 * Time: 7:38 PM
 */
@Entity
@Table(name = "doctor")
@NamedQueries({
    @NamedQuery(name = "findDoctorByEmail", query = "from Doctor u where u.email = :email"),
    @NamedQuery(name = "findDoctorById", query = "from Doctor u where u.id = :doctorId ")})

public class Doctor extends User {

  @Column(name = "fname", nullable = false, length = 80)
  private String contactNo;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "baseOrder")
  private Set<DoctorSpeciality> specialities = new HashSet<DoctorSpeciality>();


  public String getContactNo() {
    return contactNo;
  }

  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }
}
