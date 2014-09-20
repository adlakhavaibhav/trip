package com.td.impl.dao;

import com.td.domain.user.Role;
import com.td.pact.dao.RoleDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:27 AM
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {
  @Override
  public Role getRoleByName(String roleName) {
    return (Role) findUniqueByNamedQueryAndNamedParam("getRoleByName", new String[]{"roleName"}, new Object[]{roleName});
  }

  @Override
  public List<Role> getAllRoles() {
    return getAll(Role.class);
  }
}
