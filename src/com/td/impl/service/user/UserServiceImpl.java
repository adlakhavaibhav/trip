package com.td.impl.service.user;

import com.td.domain.doctor.Doctor;
import com.td.domain.user.User;
import com.td.exception.InvalidParameterException;
import com.td.pact.dao.BaseDao;
import com.td.pact.service.user.UserService;
import com.td.shiro.PrincipalImpl;
import com.td.util.BaseUtils;
import com.td.util.token.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:44 PM
 */
@Service
public class UserServiceImpl implements UserService {


  @Autowired
  private BaseDao baseDao;


  @Override
  public Long getLoggedInUserId() {
    try {
      if (getPrincipal() != null) {
        return getPrincipal().getId();
      }
    } catch (Throwable t) {
      t.printStackTrace(); //TODO:logger
    }
    return null;
  }

  private PrincipalImpl getPrincipal() {
    return (PrincipalImpl) SecurityUtils.getSubject().getPrincipal();
  }

  @Override
  public User getUserByEmail(String email) {
    if (StringUtils.isBlank(email)) {
      throw new InvalidParameterException("USER_LOGIN_CANNOT_BE_BLANK");
    }

    return (User) getBaseDao().findUniqueByNamedQueryAndNamedParam("findUserByEmail", new String[]{"email"}, new Object[]{email});
  }

  @Override
  public User getUserById(Long userId) {
    if (userId == null) {
      throw new InvalidParameterException("USER_ID_CANNOT_BE_NULL");
    }

    return (User) getBaseDao().findUniqueByNamedQueryAndNamedParam("findUserById", new String[]{"userId"}, new Object[]{userId});
  }


  @Transactional
  @Override
  public User saveUser(User user) {
    if (user != null) {
      if (user.getCreateDt() == null) {
        user.setCreateDt(BaseUtils.getCurrentTimestamp());
      }
      if (user.getLastLoginDate() == null) {
        user.setLastLoginDate(BaseUtils.getCurrentTimestamp());
      }
      if (StringUtils.isBlank(user.getUserHash())) {
        user.setUserHash(TokenUtils.generateUserHash());
      }

      /*if (user.getStore() == null) {
        user.setStore(getStoreService().getDefaultStore());
      }
      if (user.getSubscribedMask() == null) {
        user.setSubscribedMask(EnumEmailSubscription.SUBSCRIBE_ALL);//Subscribe for all
      }
      if (user.getUnsubscribeToken() == null) {
        user.setUnsubscribeToken(TokenUtils.getTokenToUnsubscribeWommEmail(user.getLogin()));//Subscribe for all
      }*/
    }

    return (User) getBaseDao().save(user);
  }

  @Transactional
  @Override
  public Doctor saveDoctor(Doctor doctor) {
    if (doctor != null) {
      if (doctor.getCreateDt() == null) {
        doctor.setCreateDt(BaseUtils.getCurrentTimestamp());
      }
      if (doctor.getLastLoginDate() == null) {
        doctor.setLastLoginDate(BaseUtils.getCurrentTimestamp());
      }
      if (StringUtils.isBlank(doctor.getUserHash())) {
        doctor.setUserHash(TokenUtils.generateUserHash());
      }

    }

    return (Doctor) getBaseDao().save(doctor);
  }


 /* @Override
  public boolean isTempUser(Long userId, Long storeId) {
    User user = getUserById(userId);
    Set<String> userRoles = user.getRoleStrings();
    return userRoles.contains(RoleConstants.TEMP_USER);
  }*/

  @Override
  public boolean isValidUserId(Long userId) {

    if (null == userId) {
      throw new InvalidParameterException("USER_ID_CANNOT_BE_BLANK");
    }

    int countByUserId = getBaseDao().countByNativeSql(
        "select count(id) from user "
            + " where id = ? ",
        userId);
    return countByUserId == 1;
  }

 /* @Override
  @SuppressWarnings("unchecked")
  public List<User> getUsersByBirthDays(Date birthDay) {
    if (null == birthDay) {
      throw new InvalidParameterException("DATE_CANNOT_BE_BLANK");
    }
    return (List<User>) getBaseDao().findByNamedQueryAndNamedParam("findUserByBirth", new String[]{"birthDay"}, new Object[]{birthDay});
  }*/

  @Override
  public boolean userHasRole(Long userId, String roleName) {
    if (null == userId) {
      throw new InvalidParameterException("USER_ID_CANNOT_BE_BLANK");
    }

    if (null == roleName) {
      throw new InvalidParameterException("ROLE_NAME_CANNOT_BE_BLANK");
    }

    User user = getUserById(userId);
    Set<String> userRoles = user.getRoleStrings();
    return userRoles != null && userRoles.contains(roleName);
  }

  public BaseDao getBaseDao() {
    return baseDao;
  }


}
