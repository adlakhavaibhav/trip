package com.td.web.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:19 PM
 */
@Component
public class HomeAction extends BaseAction {


  @DefaultHandler
  public Resolution pre() {

    return new ForwardResolution("/pages/auth/home.jsp");
  }


}
