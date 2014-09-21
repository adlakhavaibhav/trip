package com.td.constants;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 9:18 PM
 */
public class HKWebMessageConstants {

  public static final String ERROR = "There came an Error, please try again";
  public static final String NO_LOGGED_IN_USER = "You need to login for this";

  //review
  public static final String INVALID_CREATE_REVIEW_REQ = "Cannot create review with title or review blank";
  public static final String INVALID_RATE_VARIANT_REQ = "Cannot rate variant as invalid rating passed";
  public static final String INVALID_VOTE_FOR_REVIEW_REQ = "Cannot vote for review with reviewId blank or invalid vote type";


  //login
  public static final String ENTER_PASSWORD = "Please enter password";
  public static final String ENTER_EMAIL = "Please email address";
  public static final String INVALID_EMAIL_PASSWORD = "Email address or password is invalid";
  public static final String SIGNUP_REQ_INVALID = "Either email or password is blank";
  public static final String RESET_PASSWORD_REQ_INVALID = "Either the new password passed is blank or the link passed is invalid";
  public static final String USER_EXIST = "User Exist";
  public static final String USER_NOT_EXIST = "User Doesn't Exist";

  //user account messages
  public static final String INVALID_UPDATE_BASIC_INFO_REQ = "Name cannot be blank";
  public static final String INVALID_UPDATE_EMAIL_REQ = "Email cannot be blank";
  public static final String INVALID_UPDATE_PASSWORD_REQ = "Either old password or new password is blank";
  public static final String INVALID_EMAIL = "Kindly enter a valid email";

  //cart
  public static final String UNABLE_TO_ADD_TO_CART = "Product cannot be added to cart";
  public static final String UNABLE_TO_APPLY_OFFER_ON_CART = "Offer cannot be applied on cart";
  public static final String UNABLE_TO_APPLY_COUPON_ON_CART = "Could not apply Coupon on cart";

  //catalog
  public static final String NO_CATALOG_RESULTS = "No products found";
  public static final String QUERY_CANNOT_BE_BLANK = "No products found";
  //comparison
  public static final String INVALID_COMPARE_REQ = "Variant id and category id cannot be null";
  //public static final String NO_VARIANTS_TO_REMOVE_FROM_COMP = "No variants to remove from comparison";
  //public static final String VARIANT_REMOVED_FROM_COMP = "Variant removed from comparison";
  //public static final String VARIANT_ADDED_TO_COMP = "Variant added to comparison list";
  //public static final String ONLY_SAME_CAT_VARIANT_COMP = "Only variants of same category can be compared";
  //public static final String VARIANT_COMPARE_LIMIT_REACHED = "Variant compare limit reached";

  //Email Activation
  public static final String INVALID_USER = "Invalid USer";
  public static final String EMAIL_SUCCESS = "Email Sent Successfully, please check your Inbox and if not found there, please check in your Spam";

  //Account
  public static final String PASSWORD_SAVE = "Your Password has been changed successfully";
  public static final String EMAIL_SAVE = "Your email saved successfully, please check your email Account and verify your account";
  public static final String PROFILE_SAVE = "Your profile settings has been saved successfully";

  //Forgot Password
  public static final String FORGOT_PASSWORD_EMAIL = "Email has been sent to your email Id";
  public static final String TOKEN_EXPIRED = "Your link has been expired or damaged, please click on forgot password link to send email again";
  public static final String INVALID_PASSWORD = "Invalid Password";

  public static final String EMPTY_CHECK = "Fields can't be left blank";

  //Address
  public static final String ADDRESS_SAVE = "Your address has been saved successfully";
  public static final String ADDRESS_DELETE = "Address has been  deleted successfully";
  public static final String ADDRESS_DELETE_FAIL = "Could not delete address. Please try again";
  public static final String ADDRESS_NOT_AVAILABLE = "There are no addresses saved by you";


  //Loyalty
  public static final String LOYALTY_SIGN_UP_INVALID = "Name is blank";

  public static final String REWARD_POINTS_NOT_AVAILABLE = "There are no reward points available in your account";
  public static final String LOYALTY_POINTS_NOT_AVAILABLE = "There are no loyalty points available in your account";
  //feedback
  public static final String FEEDBACK_REQUEST_INVALID = "Invalid request";
  //unsubscribe
  public static final String UNSUBSCRIBE_REQUEST_INVALID = "invalid unsubscribe request";

}
