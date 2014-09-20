package com.td.rest.response;

import com.td.domain.core.JSONObject;
import com.td.rest.constants.DtoJsonConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:01 PM
 */
public abstract class AbstractBaseResponse extends JSONObject {

  protected boolean exception = false;
  protected List<String> messages = new ArrayList<String>();


  public boolean isException() {
    return exception;
  }

  public AbstractBaseResponse setException(boolean exception) {
    this.exception = exception;
    return this;
  }

  public AbstractBaseResponse addMessage(String message) {
    this.messages.add(message);
    return this;
  }

  public AbstractBaseResponse addMessages(List<String> messages) {
    this.messages.addAll(messages);
    return this;
  }

  public List<String> getMessages() {
    return messages;
  }


  @Override
  protected List<String> getKeys() {
    List<String> keys = new ArrayList<String>(0);
    keys.add(DtoJsonConstants.MESSAGES);
    keys.add(DtoJsonConstants.EXCEPTION);

    return keys;
  }

  @Override
  protected List<Object> getValues() {
    List<Object> values = new ArrayList<Object>(0);
    values.add(this.messages);
    values.add(this.exception);
    return values;
  }
}
