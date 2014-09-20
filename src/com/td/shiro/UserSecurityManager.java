package com.td.shiro;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:26 AM
 */
public interface UserSecurityManager {

  public String getPasswordForUser(String userName);

  public Set<String> getRoleNamesForUser(Principal principal);

  public Set<String> getPermissions(Principal principal, Set<String> roles);

  Principal getPrincipal(String loginName);
}
