package com.td.rest.request.user;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/22/14
 * Time: 9:47 AM
 */
public class CreateDoctorRequest extends CreateUserRequest {

  private String contactNo;

  private Set<Long> specialityIds;

  public Set<Long> getSpecialityIds() {
    return specialityIds;
  }

  public void setSpecialityIds(Set<Long> specialityIds) {
    this.specialityIds = specialityIds;
  }

  public String getContactNo() {
    return contactNo;
  }

  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }
}
