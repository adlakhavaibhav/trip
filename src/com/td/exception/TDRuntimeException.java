package com.td.exception;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 8:53 PM
 */
public class TDRuntimeException extends RuntimeException {


  protected String messageKey;
  protected Object[] params;


  public TDRuntimeException(String messageKey, Object... params) {
    super();
    this.params = params;
    this.messageKey = messageKey;
  }

  @Override
  public String getMessage() {
    StringBuilder s = new StringBuilder();
    for (Object param : this.params) {
      s.append(param);
    }
    return "Error: " + messageKey + " : " + s.toString();
  }

  @Override
  public String toString() {

    return super.toString();
  }


}


