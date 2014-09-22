package com.td.web.action;

import com.td.domain.doctor.Doctor;
import com.td.pact.service.auth.DoctorService;
import com.td.pact.service.user.UserService;
import com.td.web.action.doctor.DoctorListingAction;
import com.td.web.action.doctor.DoctorProfileAction;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:19 PM
 */
@Component
public class HomeAction extends BaseAction {

  @Autowired
  private UserService userService;
  @Autowired
  private DoctorService doctorService;

  @DefaultHandler
  public Resolution pre() {

    Long loggedInUserId = getUserService().getLoggedInUserId();
    Doctor doc = getDoctorService().getDoctorById(loggedInUserId);
    if (loggedInUserId == null) {
      return new ForwardResolution("/pages/auth/home.jsp");
    }

    if (doc != null) {
      return new RedirectResolution(DoctorProfileAction.class);
    } else {
      return new RedirectResolution(DoctorListingAction.class);
    }

  }

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public DoctorService getDoctorService() {
    return doctorService;
  }

  public void setDoctorService(DoctorService doctorService) {
    this.doctorService = doctorService;
  }
}
