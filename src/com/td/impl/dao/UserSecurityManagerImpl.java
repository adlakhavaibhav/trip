package com.td.impl.dao;

import com.td.domain.user.Permission;
import com.td.domain.user.Role;
import com.td.domain.user.User;
import com.td.pact.dao.RoleDao;
import com.td.pact.dao.UserDao;
import com.td.shiro.Principal;
import com.td.shiro.PrincipalImpl;
import com.td.shiro.UserSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:26 AM
 */
@Repository
public class UserSecurityManagerImpl implements UserSecurityManager {

  private UserDao userDao;
  private RoleDao roleDao;


  @Autowired
  public UserSecurityManagerImpl(UserDao userDao, RoleDao roleDao) {
    this.userDao = userDao;
    this.roleDao = roleDao;
  }

  /*
  * Implementation of UserSecurityManager for Shiro Realm
  */

  public String getPasswordForUser(String userName) {
    User user = getUserDao().findByLogin(userName);
    if (user == null)
      return null;
    return user.getPasswordChecksum();
  }

  public Principal getPrincipal(String loginName) {
    User user = getUserDao().findByLogin(loginName);
    if (user == null)
      return null;
    return new PrincipalImpl(user);
  }

  public Set<String> getRoleNamesForUser(Principal principal) {
    Set<String> roleNames = new LinkedHashSet<String>();
    User user = getUserDao().getUserById(principal.getId());
    if (user == null)
      return roleNames;

    Set<Role> roles = user.getRoles();
    if (roles == null || roles.isEmpty())
      return roleNames;

    for (Role role : roles) {
      roleNames.add(role.getName());
    }
    return roleNames;
  }

  /**
   * Implementing permission is not very necessary. usually most aplications can do with user and roles. Permissions
   * is the next level of granularity wherein each role can have one or more permissions
   *
   * @param principal
   * @param roles
   * @return
   */
  public Set<String> getPermissions(Principal principal, Set<String> roles) {
    Set<String> permissions = new HashSet<String>();
    for (String roleStr : roles) {
      Role role = getRoleDao().getRoleByName(roleStr);
      for (Permission permission : role.getPermissions()) {
        permissions.add(permission.getName());
      }
    }
    return permissions;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public RoleDao getRoleDao() {
    return roleDao;
  }
}

