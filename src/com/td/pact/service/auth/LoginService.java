package com.td.pact.service.auth;

import com.td.exception.LoginException;
import com.td.rest.request.user.CreateUserRequest;
import com.td.rest.response.user.CreateUserResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:14 PM
 */
public interface LoginService {


  public CreateUserResponse signupUser(CreateUserRequest createUserRequest);

  public boolean login(String email, String password, boolean rememberMe) throws LoginException;


  public void logout();

}
