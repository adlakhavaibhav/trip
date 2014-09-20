package com.td.rest.response.user;

import com.td.rest.constants.DtoJsonConstants;
import com.td.rest.response.AbstractBaseResponse;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:06 PM
 */
public class CreateUserResponse extends AbstractBaseResponse {

  /*private UserActivationTokenResponse activationTokenResponse;*/
  private boolean isActivated;

  private UserResponse userResponse;





  public UserResponse getUserResponse() {
    return userResponse;
  }

  public void setUserResponse(UserResponse userResponse) {
    this.userResponse = userResponse;
  }

 /* public UserActivationTokenResponse getActivationTokenResponse() {
    return activationTokenResponse;
  }

  public void setActivationTokenResponse(UserActivationTokenResponse activationTokenResponse) {
    this.activationTokenResponse = activationTokenResponse;
  }
*/
  public boolean isActivated() {
    return isActivated;
  }

  public void setActivated(boolean activated) {
    isActivated = activated;
  }


  @Override
  protected List<String> getKeys() {
    List<String> keyList = super.getKeys();
    /*keyList.add(DtoJsonConstants.ACTIVATION_TOKEN);*/
    keyList.add(DtoJsonConstants.ACTIVE);
    keyList.add(DtoJsonConstants.USER);

    return keyList;
  }

  @Override
  protected List<Object> getValues() {
    List<Object> valueList = super.getValues();
    /*valueList.add(this.activationTokenResponse);*/
    valueList.add(this.isActivated);
    valueList.add(this.userResponse);

    return valueList;
  }
}
