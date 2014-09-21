package com.td.rest.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:16 PM
 */
public class AbstractBaseRequest implements Serializable {
  private static Logger logger = LoggerFactory.getLogger(AbstractBaseRequest.class);


  protected boolean validate() {
    return true;
  }


}
