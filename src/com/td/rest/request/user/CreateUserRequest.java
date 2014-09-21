package com.td.rest.request.user;

import com.td.rest.request.AbstractBaseRequest;
import org.apache.commons.lang.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:15 PM
 */
public class CreateUserRequest extends AbstractBaseRequest {

  private String email;
  private String fname;
  private String lname;
  private String password;
  private String roleName;

  /*private Long referredByUserId;
  private Long guestUserId;*/


  @Override
  public boolean validate() {
    boolean valid = super.validate();

    if (valid && StringUtils.isBlank(email)) {
      valid = false;
    }
    if (valid && StringUtils.isBlank(password)) {
      valid = false;
    }

    return valid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  /*public Long getReferredByUserId() {
    return referredByUserId;
  }

  public void setReferredByUserId(Long referredByUserId) {
    this.referredByUserId = referredByUserId;
  }

  public Long getGuestUserId() {
    return guestUserId;
  }

  public void setGuestUserId(Long guestUserId) {
    this.guestUserId = guestUserId;
  }
*/
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
