package com.td.web.action.auth;

import com.td.pact.service.auth.LoginService;
import com.td.web.action.BaseAction;
import com.td.web.action.HomeAction;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/21/14
 * Time: 8:28 PM
 */
@Component
public class LogoutAction extends BaseAction {

  private String redirectUrl;

  @Autowired
  private LoginService loginService;

  @DefaultHandler
  @DontValidate
  public Resolution logout() {
    getLoginService().logout();


    if (!StringUtils.isBlank(redirectUrl)) {
      return new RedirectResolution(redirectUrl, false);
    }

    return new RedirectResolution(HomeAction.class);
    //return new RedirectResolution(LoginAction.class);
  }

  public LoginService getLoginService() {
    return loginService;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }
}
