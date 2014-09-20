package com.td.pact.dao;

import com.td.domain.user.User;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:28 AM
 */
public interface UserDao {


  public User findByLogin(String login);



  public User getUserById(Long userId);
}

