package com.td.exception;

import org.apache.commons.lang.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/21/14
 * Time: 7:57 PM
 */
public class LoginException extends TDRuntimeException {

  public LoginException(String messageKey, Object... params) {
    super(messageKey, params);
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();

    if (StringUtils.isBlank(message)) {
      message = "Unable to login to admin!";
    }
    return message;
  }
}
