package com.td.shiro;

import org.apache.shiro.web.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 10:56 AM
 */
public class ShiroSecurityManager extends DefaultWebSecurityManager {

  private HibernateSecurityRealm hibernateSecurityRealm;

  @Autowired
  public ShiroSecurityManager(HibernateSecurityRealm hibernateSecurityRealm) {
    this.hibernateSecurityRealm = hibernateSecurityRealm;

    setRealm(hibernateSecurityRealm);
    setSessionMode(DefaultWebSecurityManager.HTTP_SESSION_MODE);
    setRememberMeCookieMaxAge(3600 * 24 * 30); // 30 days
    setCacheManager(null);
  }

  public HibernateSecurityRealm getHibernateSecurityRealm() {
    return hibernateSecurityRealm;
  }

}
