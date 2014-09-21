package com.td.util.token;

import com.td.util.BaseUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 8:56 PM
 */
public class TokenUtils {

  public static String generateGuestLogin() {
    return BaseUtils.getRandomString(6) + BaseUtils.getCurrentTimestamp().getTime();
  }

  public static String getTokenToUnsubscribeWommEmail(String email) {
    return BaseUtils.getMD5Checksum("2348kwbfdbskdjf" + email);
  }

  public static String generateUserHash() {
    return BaseUtils.getMD5Checksum(BaseUtils.getCurrentTimestamp() + BaseUtils.getRandomString(10));
  }

  public static String generateTempToken() {
    return BaseUtils.getMD5Checksum(BaseUtils.getRandomString(6) + BaseUtils.getCurrentTimestamp().getTime());
  }

}
