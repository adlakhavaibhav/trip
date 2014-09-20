package com.td.web.action.user;

import com.td.web.action.BaseAction;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.SimpleError;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/19/14
 * Time: 11:58 PM
 */
@Component
public class UserSignupAction extends BaseAction {

  private String email;
  private String name;
  private String password;

  private Long userId;
  private String token;

  private String redirectUrl;


  /*@Autowired
  private UserService userService;*/
  @Autowired
  private LoginService loginService;
   /*@Autowired
   private UserActivationService userActivationService;
   @Autowired
   private UserEmailService emailService;*/


  @DefaultHandler
  @DontValidate
  public Resolution pre() {
    return new ForwardResolution("/pages/auth/loginResponsive.jsp");
  }

  public Resolution signup() {
    if (name == null || email == null || password == null) {
      addRedirectAlertMessage(new SimpleError(HKWebMessageConstants.EMPTY_CHECK));
      return new RedirectResolution(SignUpAction.class);
    }
    CreateUserRequest createUserRequest = new CreateUserRequest();
    createUserRequest.setEmail(email);
    createUserRequest.setName(name);
    createUserRequest.setPassword(password);
    CreateUserApiResponse createUserResponse = getLoginService().signup(createUserRequest);
    //    CreateUserApiResponse createUserResponse = getUserService().signup(createUserRequest);

    if (createUserResponse != null) {
      if (createUserResponse.isException()) {
        addRedirectAlertMessage(new SimpleError(createUserResponse.getMessages().get(0)));
        return new ForwardResolution("/pages/auth/loginResponsive.jsp");
        //        return new RedirectResolution(SignUpAction.class);
      }

       /*getLoginService().login(createUserResponse.getUserResponse().getLogin(), createUserRequest.getPassword(), true);

       if (!createUserResponse.isActivated()) {
         String activateLink = getUserActivationService().getActivationLink(createUserResponse.getActivationTokenResponse().getToken(), createUserResponse.getUserResponse().getId());
         getEmailService().sendWelcomeEmail(createUserResponse.getUserResponse(), activateLink);
       }*/

      if (!StringUtils.isBlank(redirectUrl)) {
        return new RedirectResolution(redirectUrl, false);
      }
    }
    return new RedirectResolution(HomeAction.class);
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }


  public LoginService getLoginService() {
    return loginService;
  }

  public String getPageType() {
    return pageType;
  }

  public void setPageType(String pageType) {
    this.pageType = pageType;
  }

}
