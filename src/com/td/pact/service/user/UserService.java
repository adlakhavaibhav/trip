package com.td.pact.service.user;

import com.td.domain.user.User;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:42 PM
 */
public interface UserService {

  public User getUserByEmail(String email);

  public User getUserById(Long userId);

  /*public boolean isTempUser(Long userId, Long storeId);*/

  public User saveUser(User user);

  public boolean isValidUserId(Long userId);

  /*public List<User> getUsersByBirthDays(Date birthDay);*/

  public boolean userHasRole(Long userId, String roleName);

}
