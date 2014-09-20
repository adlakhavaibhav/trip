package com.td.pact.dao;

import com.td.domain.user.Role;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:27 AM
 */
public interface RoleDao extends BaseDao{

  public Role getRoleByName(String roleName);

  public List<Role> getAllRoles();
}
