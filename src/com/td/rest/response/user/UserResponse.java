package com.td.rest.response.user;

import com.td.domain.user.User;
import com.td.rest.constants.DtoJsonConstants;
import com.td.rest.response.AbstractBaseResponse;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:08 PM
 */
public class UserResponse extends AbstractBaseResponse {

  private Long id;
  private String login;
  private String email;
  private String name;
  private String passwordChecksum;
  private Date birthDate;
  private String gender;

  private Set<String> roles = new HashSet<String>();
  private Set<String> permissions = new HashSet<String>();



  public UserResponse(User user, Long storeId) {

    this.id = user.getId();

    this.email = user.getEmail();
    this.name = user.getName();
    this.passwordChecksum = user.getPasswordChecksum();
    /*this.birthDate = user.getBirthDate();*/
    this.gender = user.getGender();
    this.roles = user.getRoleStrings();

    /*for (String roleStr : roles) {
      RoleVO roleVO = RoleCache.getInstance().getRoleByName(roleStr);
      for (PermissionVO permissionVO : roleVO.getPermissions()) {
        permissions.add(permissionVO.getName());
      }
    }*/

  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPasswordChecksum() {
    return passwordChecksum;
  }

  public void setPasswordChecksum(String passwordChecksum) {
    this.passwordChecksum = passwordChecksum;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<String> getRoles() {
    return roles;
  }

  public void setRoles(Set<String> roles) {
    this.roles = roles;
  }


  @Override
  protected List<String> getKeys() {
    List<String> keyList = super.getKeys();
    keyList.add(DtoJsonConstants.ID);
    keyList.add(DtoJsonConstants.EMAIL);
    keyList.add(DtoJsonConstants.NAME);
    keyList.add(DtoJsonConstants.LOGIN);
    keyList.add(DtoJsonConstants.PASSWORD);
    keyList.add(DtoJsonConstants.BIRTH_DATE);
    keyList.add(DtoJsonConstants.GENDER);
    keyList.add(DtoJsonConstants.ROLES);
    keyList.add(DtoJsonConstants.PERMISSIONS);

    return keyList;
  }

  @Override
  protected List<Object> getValues() {
    List<Object> valueList = super.getValues();
    valueList.add(this.id);
    valueList.add(this.email);
    valueList.add(this.name);
    valueList.add(this.login);
    valueList.add(this.passwordChecksum);
    valueList.add(this.birthDate);
    valueList.add(this.gender);
    valueList.add(this.roles);
    valueList.add(this.permissions);

    return valueList;
  }
}
