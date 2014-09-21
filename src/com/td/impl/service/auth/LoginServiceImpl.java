package com.td.impl.service.auth;

import com.td.domain.user.Role;
import com.td.domain.user.User;
import com.td.pact.service.auth.LoginService;
import com.td.pact.service.user.UserService;
import com.td.rest.constants.MessageConstants;
import com.td.rest.request.user.CreateUserRequest;
import com.td.rest.response.user.CreateUserResponse;
import com.td.rest.response.user.UserResponse;
import com.td.util.BaseUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:26 PM
 */
@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private UserService userService;


  @Override
  public CreateUserResponse signupUser(CreateUserRequest createUserRequest) {

    CreateUserResponse createUserResponse = new CreateUserResponse();
    if (!createUserRequest.validate()) {
      createUserResponse.setException(true);
      createUserResponse.addMessage(MessageConstants.SIGNUP_REQ_INVALID);
      return createUserResponse;
    }

   /* if (createUserRequest.getName().length() > UserConstants.MAX_USER_NAME_LIMIT) {
      createUserResponse.setException(true);
      createUserResponse.addMessage(MessageConstants.INVALID_NAME);
      return createUserResponse;
    }*/

    if (!BaseUtils.isValidEmail(createUserRequest.getEmail())) {
      createUserResponse.setException(true);
      createUserResponse.addMessage(MessageConstants.INVALID_EMAIL);
      return createUserResponse;
    }

    User user = getUserService().getUserByEmail(createUserRequest.getEmail());
    if (user != null) {
      createUserResponse.setException(true);
      createUserResponse.addMessage(MessageConstants.USER_ID_ALREADY_TAKEN);
      return createUserResponse;
    }

    /*Long tempUserId = null;
    if (createUserRequest.getGuestUserId() != null) {
      user = getUserService().getUserById(createUserRequest.getGuestUserId());
      Role tempUserRole = RoleCache.getInstance().getRoleByName(RoleConstants.TEMP_USER).getRole();
      if (user != null && user.getRoles().contains(tempUserRole)) {
        tempUserId = user.getId();
        user.getRoles().remove(tempUserRole);
      } else {
        user = new User();
      }
    } else {
      user = new User();
    }*/

    user = new User();
    user.setFname(createUserRequest.getFname());
    user.setLname(createUserRequest.getLname());

    /*if (!StoreConstants.DEFAULT_STORE_ID.equals(createUserRequest.getStoreId())) {
      String login = createUserRequest.getEmail().concat(StoreConstants.LOGIN_STORE_SEP).concat(createUserRequest.getStoreId().toString());
      user.setLogin(login);
    } else {
      user.setLogin(createUserRequest.getEmail());
    }*/

    user.setEmail(createUserRequest.getEmail());
    user.setPasswordChecksum(BaseUtils.passwordEncrypt(createUserRequest.getPassword()));
    /*user.setUnsubscribeToken(TokenUtils.getTokenToUnsubscribeWommEmail(createUserRequest.getEmail()));*/

    /*// to prevent overwriting referredBy we are checking for null
    // if this user is already referred by any other user then we will not override
    if (user.getReferredByUserId() == null) {
      user.setReferredByUserId(createUserRequest.getReferredByUserId());
    }*/

   /* String roleToBeProvided = createUserRequest.getRoleName();
    if (StringUtils.isBlank(roleToBeProvided)) {
      roleToBeProvided = RoleConstants.HK_UNVERIFIED;
    }

    Role role = RoleCache.getInstance().getRoleByName(roleToBeProvided).getRole();
    user.getRoles().add(role);*/


    user = getUserService().saveUser(user);

    /**
     * Now to transfer any data created by a temp user.
     */
    /*if (tempUserId != null) {
      // Merge order/address of Guest user
      this.mergeUsers(tempUserId, user.getId(), createUserRequest.getStoreId(), false);
    }*/
    createUserResponse.setUserResponse(new UserResponse(user));

    /**
     * user activation
     */
   /* if (RoleConstants.HK_UNVERIFIED.equals(roleToBeProvided)) {
      createUserResponse.setActivated(false);
      UserActivationTokenResponse userActivationTokenResponse = getUserActivationService().generateUserActivationToken(user.getId(), createUserRequest.getStoreId());
      createUserResponse.setActivationTokenResponse(userActivationTokenResponse);
    } else {
      createUserResponse.setActivated(true);
    }*/


    return createUserResponse;
  }

  public UserService getUserService() {
    return userService;
  }
}
