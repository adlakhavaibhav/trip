package com.td.web.action.user;

import com.td.constants.HKWebMessageConstants;
import com.td.domain.doctor.Doctor;
import com.td.exception.LoginException;
import com.td.pact.service.auth.DoctorService;
import com.td.pact.service.auth.LoginService;
import com.td.pact.service.user.UserService;
import com.td.web.action.BaseAction;
import com.td.web.action.HomeAction;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.SimpleError;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/21/14
 * Time: 8:00 PM
 */
@Component
public class UserLoginAction extends BaseAction {

  private String email;
  private String password;

  private String redirectUrl;
  private boolean rememberMe;


  @Autowired
  private LoginService loginService;
  @Autowired
  private UserService userService;
  @Autowired
  private DoctorService doctorService;

  @DefaultHandler
  @DontValidate
  public Resolution pre() {
    return new ForwardResolution("/pages/auth/login.jsp");
  }


  public Resolution login() {

    if (validate()) {
      boolean loginSuccess;
      String errMsg = HKWebMessageConstants.INVALID_EMAIL_PASSWORD;

      try {
        loginSuccess = getLoginService().login(email, password, true);
      } catch (LoginException e) {
        loginSuccess = false;
        //errMsg = HKWebMessageConstants.ERROR;
      }
      if (loginSuccess) {
        if (!StringUtils.isBlank(redirectUrl)) {
          return new RedirectResolution(redirectUrl, false);
        }

        Long loggedInUserId = getUserService().getLoggedInUserId();
        Doctor doc = getDoctorService().getDoctorById(loggedInUserId);

        if (doc != null) {
          return new RedirectResolution(HomeAction.class);
        } else {
          return new RedirectResolution(HomeAction.class);
        }


      } else {
        addRedirectAlertMessage(new SimpleError(errMsg));
        return new ForwardResolution("/pages/auth/login.jsp");
      }
    } else {
      addRedirectAlertMessage(new SimpleError(HKWebMessageConstants.INVALID_EMAIL_PASSWORD));
      return new ForwardResolution("/pages/auth/login.jsp");
    }


  }


  private boolean validate() {
    boolean valid = true;
    if (StringUtils.isBlank(password)) {
      valid = false;
      addRedirectAlertMessage(new SimpleError(HKWebMessageConstants.ENTER_PASSWORD));
    }
    if (StringUtils.isBlank(email)) {
      valid = false;
      addRedirectAlertMessage(new SimpleError(HKWebMessageConstants.ENTER_EMAIL));
    }
    return valid;
  }


  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  public void setRememberMe(boolean rememberMe) {
    this.rememberMe = rememberMe;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public boolean isRememberMe() {
    return rememberMe;
  }

  public LoginService getLoginService() {
    return loginService;
  }

  public UserService getUserService() {
    return userService;
  }

  public DoctorService getDoctorService() {
    return doctorService;
  }
}
