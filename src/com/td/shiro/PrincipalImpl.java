package com.td.shiro;

import com.td.domain.doctor.Doctor;
import com.td.domain.user.User;
import com.td.impl.service.ServiceLocatorFactory;
import com.td.pact.service.auth.DoctorService;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 8:11 AM
 */
public class PrincipalImpl implements Principal {

  public static final long serialVersionUID = 999L;
  private Long id;
  private String fname;
  private String lname;
  private String email;
  private String userHash;
  private String gender;

  private Long assumedId;
  private String assumedFname;
  private String assumedLname;
  private String assumedEmail;
  private String assumedUserHash;

  private String assumedGender;


  private boolean isAssumed = false;

  public PrincipalImpl(User user) {
    id = user.getId();
    fname = user.getFname();
    lname = user.getLname();
    email = user.getEmail();
    gender = user.getGender();
    userHash = user.getUserHash();
  }

  /**
   * Call this method to assume the identity of the passed assumedUser
   *
   * @param assumedUser user whose account has to be assumed
   */
  public void setAssumedIdentity(User assumedUser) {
    this.assumedId = assumedUser.getId();
    this.assumedFname = assumedUser.getFname();
    this.assumedLname = assumedUser.getLname();
    this.assumedEmail = assumedUser.getEmail();
    this.assumedUserHash = assumedUser.getUserHash();
    this.assumedGender = assumedUser.getGender();
    this.isAssumed = true;
  }

  public void clearAssumedIdentity() {
    this.assumedId = null;
    this.assumedFname = null;
    this.assumedLname = null;
    this.assumedEmail = null;
    this.assumedUserHash = null;

    isAssumed = false;
  }

  public boolean isDoctor() {
    DoctorService doctorService = ServiceLocatorFactory.getService(DoctorService.class);
    Doctor doctor = doctorService.getDoctorById(id);

    return doctor != null;
  }

  public Long getId() {
    return assumedId == null ? id : assumedId;
  }

  public String getName() {
    return assumedFname == null ? fname : assumedFname;
  }

  public String getFirstName() {
    return getName();
  }

  /*
  This method is explicitly added for handling the case
  of changing user name. so that the change can be reflected
  whithout any delay.
   */

  public void setFname(String fname) {
    this.fname = fname;
  }


  public String getEmail() {
    return assumedEmail == null ? email : assumedEmail;
  }

  public String getUserHash() {
    return assumedUserHash == null ? userHash : assumedUserHash;
  }

  public boolean isAssumed() {
    return isAssumed;
  }


  public String getGender() {
    return assumedGender == null ? gender : assumedGender;
  }
}

