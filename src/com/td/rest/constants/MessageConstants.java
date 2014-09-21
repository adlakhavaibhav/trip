package com.td.rest.constants;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:28 PM
 */
public interface MessageConstants {

  public static final String UNAUTHORIZED_API_ACCESS = "The api access key passed is invalid";

  public static final String BLANK_CAT_PREFIXES = "cat prefixes cannot be blank, need to specify at least one";
  public static final String INVALID_BRAND_IDS = "brands should specified as ids";
  public static final String INVALID_REQ = "invalid request";
  public static final String INVALID_NODE_FOR_CATALOG = "invalid node for catalog req";
  public static final String INVALID_PARAMS_FOR_PAGE = "page param params cannot be blanl";
  public static final String NO_USER_FOUND = " user does not exist in system";
  public static final String CATEGORY_NOT_FOUND = "Category details could not be retreived";

  //user signup/login messages
  public static final String CANNOT_CREATE_GUEST_USER = " cannot create guest user";
  public static final String SIGNUP_REQ_INVALID = "Either email or password is blank";
  public static final String USER_ID_ALREADY_TAKEN = "Login Email is already registered in the system, Please choose another";
  public static final String RESET_PASSWORD_REQ_INVALID = "Either the new password passed is blank or the link passed is invalid";
  public static final String USER_EXIST = "User Exist";
  public static final String USER_NOT_EXIST = "User Doesn't Exist";

  //revies/rating messages
  public static final String USER_ALREADY_CAST_VOTE = "You have already cast vote for this review";
  public static final String USER_ALREADY_MARKED_SPAM = "You have already marked this review as spam";
  public static final String USER_VOTE_RECORDED = "Your vote has been recorded successfully";
  public static final String USER_REVIEW_RECORDED = "Your review has been recorded successfully";
  public static final String USER_RATING_RECORDED = "Your rating has been recorded successfully";
  public static final String REVIEWS_NOT_FOUND = "Variant reviews could not be retreived";

  //user activation messages
  public static final String ACTIVATION_LINK_INVALID = "The link passed is invalid";
  public static final String ACTIVATION_LINK_EXPIRED = "The link passed has expired.";
  public static final String ACTIVATION_SUCCESSFUL = "Your account has been activated";
  public static final String ALREADY_ACTIVATED = "Your has already been activated";

  //address messages
  public static final String INVALID_CREATE_ADDRESS_REQ = "Address cannot be created with name, line1, city or pincode blank";
  public static final String INVALID_PINCODE = "Currently, service is not provided to the specified pincode";
  public static final String NO_ADDRESS_FOUND = "Address could not be found in the system";

  //user account update messages
  public static final String INVALID_UPDATE_BASIC_INFO_REQ = "Name cannot be blank";
  public static final String INVALID_UPDATE_EMAIL_REQ = "Email cannot be blank";
  public static final String INVALID_UPDATE_PASSWORD_REQ = "Either old password or new password is blank";
  public static final String INVALID_NAME = "Kindly enter a valid name";
  public static final String INVALID_EMAIL = "Kindly enter a valid email";
  public static final String INVALID_OLD_PASSWORD = "Invalid old password";
  public static final String PASSWORD_RESET_SUCCESSFULLY = "Your password has been reset successfully";

  //menu
  public static final String NO_MENU_EXISTS = "No menu has been designed for the store";

  //cart
  public static final String PRODUCT_OOS = "Product is out of stock";
  public static final String REQ_QTY_NA = "Requested quantity not available";
  public static final String INVALID_CART_QTY = "Variant qty cannot be zero or negative for adding in cart";
  public static final String PRODUCT_ADDED_TO_CART = "Product added to cart";
  public static final String CART_UPDATED = "Cart updated with requested qty";
  public static final String UNABLE_TO_ADD_TO_CART = "Cannot add product to cart right now";
  public static final String EMPTY_CART = "No Variant added to your cart";
  public static final String INSUFFICIENT_LOYALTY_POINTS = "You do not have sufficient loyalty points to add this product";
  public static final String INSUFFICIENT_INVENTORY = "Your order cannot be placed due to insufficient inventory";

  //variant
  public static final String VARIANT_NOT_FOUND = "Variant details cannot be retrieved";
  public static final String USER_LOGGED_IN = "user logged in";

  //location
  public static final String COUNTRY_NOT_FOUND = "Country details could not be retrieved";
  public static final String STATE_NOT_FOUND = "State details could not be retrieved";


  //order
  public static final String UNABLE_TO_PLACE_ORDER = "Order could not be placed";
  public static final String AMOUNT_MISMATCH = "Your Order Amount has been changed, please check and place order again";
  public static final String CHECKSUM_MISMATCH = "checksum mismatch";
  public static final String INVALID_CART = "Invalid Cart";

  //payment
  public static final String PAYMENT_SUCCESSFUL = "Payment Successful";
  public static final String PAYMENT_FAILED = "Payment Failed";
  public static final String AP = "Authorization Pending";
  public static final String COD_AP = "COD Verification Pending";

  //pack
  public static final String PACK_ADDED_MSG = "1 Pack Added to cart";

  //offer
  public static final String OFFER_NOT_FOUND = "Invalid offer";
  public static final String OFFER_NOT_APPLICABLE = "Offer is not applicable";
  public static final String COUPON_NOT_FOUND = "Invalid coupon code";
  public static final String COUPON_INVALID_FOR_CART = "We tried applying coupon to your cart, but either coupon is not valid or stock is not available for freebies ";
  public static final String COUPON_MAX_ALLOWED_TIMES_REACHED = "This coupon is no longer valid";

  //user points
  public static final String UPDATE_USER_POINT_STATUS_REQ_INVALID = "User points cannot be updated with user point id, userPointTypeId or to be updated status id as blank";
  public static final String REEDEMABLE_POINTS_LESS_THAN_REQUESTED = "Available points are less than that requested";
  public static final String CREATE_USER_POINT_REQ_INVALID = "User points cannot be created with user point mode id,reason id or value as blank";
  public static final String REWARD_POINT_ADDED = "Reward Point added successfully";
  public static final String ERROR = "Internal Server Error, please try again";


  //Loyalty
  public static final String LOYALTY_SIGN_UP_INVALID = "Name is blank";


  //order
  public static final String WMS_ORDER_STATUS_UPDATE_REQ_INVALID = "Wms order update request cannot be processed";
  public static final String ORDER_RTO_REQ_INVALID = "Order cancel request cannot be processed with gateway order id blank or opr details empty";
  public static final String ORDER_RTO_INITIATED_REQ_INVALID = "Order cancel request cannot be processed with gateway order id blank or opr details empty";
  public static final String ORDER_RETURNED_REQ_INVALID = "Order cancel request cannot be processed with gateway order id blank or opr details empty";
  public static final String ORDER_CANCEL_REQ_INVALID = "Order cancel request cannot be processed with gateway order id blank";
  public static final String ORDER_IN_PROCESS_REQ_INVALID = "Order in process request cannot be processed with gateway order id blank or opr details empty";
  public static final String ORDER_SHIPPED_REQ_INVALID = "Order shipped request cannot be processed with gateway order id blank or shipping details empty";
  public static final String ORDER_PACKED_REQ_INVALID = "Order packed request cannot be processed with gateway order id blank, opr or opr li details empty";
  public static final String ORDER_DELIVERED_REQ_INVALID = "Order delivered request cannot be processed with gateway order id blank or opr details empty";
  public static final String COD_ORDER_UPDATE_REQ_INVALID = "COD Order update request cannot be processed with base order id, action id or store id blank";
  public static final String NEFT_ORDER_UPDATE_REQ_INVALID = "NEFT Order update request cannot be processed with bank name, cheque number, base order id, action id or store id blank";
  public static final String BASE_ORDER_NOT_FOUND = "Order details could not be retreived";
  public static final String PAYMENT_NOT_AUTH_PENDING = "Payment related to order is not in Authorization Pending status";
  public static final String PAYMENT_ALREADY_ESCALABLE = "Payment related to order is already in escalable state";
  public static final String PAYMENT_NOT_OF_TYPE_COD = "Payment related to order is not of COD type";
  public static final String PAYMENT_NOT_OF_TYPE_NEFT = "Payment related to order is not of NEFT type";
  public static final String MOBILE_NOT_ASSOCIATED_WITH_ORDER = "Mobile number is not associated with the provided order id";


  //social login
  public static final String SOCIAL_LOGIN_REQ_INVALID = "Cannot social login with email, provider or provider access token blank";


  //payment resolution
  public static final String NO_PAYMENT_FOUND_FOR_CART = "No payment found for cart";
  public static final String PAYMENT_NOT_SUPPORTED_FOR_ORDER_OR_REFUND = "Payment not supported for order or refund";
  public static final String ORDER_PUSHED_FOR_PROCESSING = "Order related to payment pushed for processing";
  public static final String ORDER_CANCELLED = "Order related to payment cancelled";
  public static final String INVALID_PAY_RES_REQUEST = "Payment cannot be resolved with cart id, resolution mode, store id or api access key blank";

  //feedback
  public static final String FEEDBACK_REQUEST_INVALID = "Invalid feedback request";

  public static final String MULTIPLE_RTOS = "You have multiple order returned, so COD payment option is not available";
  public static final String OFFER_DOES_NOT_SUPPORT_COD = "You have applied a coupon or offer that does not support COD payment option";
  public static final String PAYABLE_LESS_THAN_COD_MIN = "Total payable amount is less than minimum amount for COD payment";
  public static final String PAYABLE_MORE_THAN_COD_MAX = "Total payable amount is more than maximum amount for COD payment";
  public static final String VARIANTS_DONT_ALLOW_COD = "There are items in your cart which do not allow COD";
  public static final String VARIANTS_DONT_ALLOW_COD_ON_PINCODE = "There are item(s) in your cart which do not allow COD on your pincode";
  public static final String VARIANTS_CANNOT_BE_SHIPPED_TO_PINCODE = "There are item(s) in your cart which cannot be shipped on your pincode";
  public static final String CANNOT_DETERMINE_AVAILABILITY = "There is a problem checking availabilty of items in your cart, please contact customer support";
  public static final String ITEMS_IN_CART_CHANGED = "Items in your cart have been updated";
  public static final String COD_NOT_ALLOWED_ON_PINCODE = "COD Payment option is not available on your pincode ";
  public static final String COD_NOT_ALLOWED_ON_PINCODE_FOR_VARIANT = "You have item(s):  {0} in your cart for which COD Payment option is not available on your pincode ";

  //wms order integration
  public static final String INVALID_ORDER_STATUS_UPDATE_REQUEST = "Order status cannot be updated with gateway order id, event, event date, action or opr li list blank ";
  public static final String INVALID_OPR_IN_PROCESS_REQUEST = "Opr cannot be marked in process with gateway order id or opr id blank ";
  public static final String INVALID_OPR_LI_SHIP_REQUEST = "Invalid Request - gateway order id, opr id or opr li list is blank or incorrect ";
  public static final String INVALID_OPR_LI_STATUS_UPDATE_REQUEST = "Invalid Request - gateway order id, opr id or opr li list is blank or incorrect ";
  public static final String INVALID_OPR_STATUS_REQUEST = "Invalid Request - gateway order id or opr id is blank ";
  public static final String INVALID_ORDER_OR_CATALOG_PULL_REQUEST = "Invalid Request - vendor code, store id cannot be blank or pageNo and perPage cannot be negative ";
  public static final String OPR_LI_INVALID_TO_BE_SHIPPED = "One or more Opr Li is not in valid state to be shipped";

  public static final String VENDOR_NOT_FOUND = "Vendor details could not be retrieved";
  public static final String CREATE_AFTER_DATE_MISSING = "Created After Date parameter should be specified with Created Before Date";

  //shipping label
  public static final String INVALID_SHIPPING_LABEL_REQUEST = "Invalid Request - oprLiId's, gateway order id, oprId is blank or incorrect ";
  public static final String EXCEPTION_WHILE_GETTING_SHIPPING_LABEL = "Some exception occurred while generating shipping label ";
}
