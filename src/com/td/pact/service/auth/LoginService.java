package com.td.pact.service.auth;

import com.td.rest.response.user.CreateUserResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:14 PM
 */
public interface LoginService {


  public CreateUserResponse signup(CreateUserRequest createUserRequest);
}
