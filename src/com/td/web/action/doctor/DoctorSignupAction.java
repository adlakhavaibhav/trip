package com.td.web.action.doctor;

import com.td.constants.HKWebMessageConstants;
import com.td.domain.doctor.Speciality;
import com.td.pact.service.auth.DoctorService;
import com.td.pact.service.auth.LoginService;
import com.td.rest.request.user.CreateDoctorRequest;
import com.td.rest.response.doctor.CreateDoctorResponse;
import com.td.web.action.BaseAction;
import com.td.web.action.HomeAction;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.SimpleError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/22/14
 * Time: 11:01 AM
 */
@Component
public class DoctorSignupAction extends BaseAction {

  private String email;
  private String fname;
  private String lname;
  private String password;

  private Set<Long> specialityIds;

  private List<Speciality> allSpecialityList;

  @Autowired
  private DoctorService doctorService;
  @Autowired
  private LoginService loginService;


  @DefaultHandler
  @DontValidate
  public Resolution pre() {
    allSpecialityList = getDoctorService().getAllSpecialities();
    return new ForwardResolution("/pages/auth/doctorSignUp.jsp");
  }

  public Resolution signup() {
    if (fname == null || email == null || password == null) {
      addRedirectAlertMessage(new SimpleError(HKWebMessageConstants.EMPTY_CHECK));
      return new RedirectResolution(DoctorSignupAction.class);
    }
    CreateDoctorRequest createDoctorRequest = new CreateDoctorRequest();
    createDoctorRequest.setEmail(email);
    createDoctorRequest.setFname(fname);
    createDoctorRequest.setLname(lname);

    createDoctorRequest.setPassword(password);
    createDoctorRequest.setSpecialityIds(specialityIds);

    CreateDoctorResponse createDoctorResponse = getDoctorService().signupDoctor(createDoctorRequest);


    if (createDoctorResponse != null) {
      if (createDoctorResponse.isException()) {
        addRedirectAlertMessage(new SimpleError(createDoctorResponse.getMessages().get(0)));
        //return new ForwardResolution("/pages/auth/userSignUp.jsp");
        return new RedirectResolution(DoctorSignupAction.class);
      }

           /*getLoginService().login(createUserResponse.getUserResponse().getLogin(), createUserRequest.getPassword(), true);

           if (!createUserResponse.isActivated()) {
             String activateLink = getUserActivationService().getActivationLink(createUserResponse.getActivationTokenResponse().getToken(), createUserResponse.getUserResponse().getId());
             getEmailService().sendWelcomeEmail(createUserResponse.getUserResponse(), activateLink);
           }*/

      /*if (!StringUtils.isBlank(redirectUrl)) {
        return new RedirectResolution(redirectUrl, false);
      }*/
    }
    getLoginService().login(createDoctorRequest.getEmail(), createDoctorRequest.getPassword(), true);
    return new RedirectResolution(HomeAction.class);
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public Set<Long> getSpecialityIds() {
    return specialityIds;
  }

  public void setSpecialityIds(Set<Long> specialityIds) {
    this.specialityIds = specialityIds;
  }

  public List<Speciality> getAllSpecialityList() {
    return allSpecialityList;
  }

  public void setAllSpecialityList(List<Speciality> allSpecialityList) {
    this.allSpecialityList = allSpecialityList;
  }

  public DoctorService getDoctorService() {
    return doctorService;
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

  public LoginService getLoginService() {
    return loginService;
  }
}
