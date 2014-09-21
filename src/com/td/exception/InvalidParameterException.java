package com.td.exception;

import org.apache.commons.lang.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 8:53 PM
 */
public class InvalidParameterException extends TDRuntimeException {
  public InvalidParameterException(String messageKey, Object... params) {
    super(messageKey, params);
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();

    if (StringUtils.isBlank(message)) {
      message = "Parameter passed to method does not match data type or is invalid";
    }
    return message;
  }
}
