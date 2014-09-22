package com.td.impl.dao;

import com.td.domain.user.User;
import com.td.pact.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:27 AM
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

  @Override
  public User findByLogin(String login) {
    return (User) findUniqueByNamedQueryAndNamedParam("findUserByEmail", new String[]{"email"}, new Object[]{login});
  }


  @Override
  public User getUserById(Long userId) {
    return (User) findUniqueByNamedQueryAndNamedParam("findUserById", new String[]{"userId"}, new Object[]{userId});
  }
}

