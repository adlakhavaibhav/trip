package com.td.domain.user;

import com.td.domain.core.JSONObject;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/19/14
 * Time: 11:48 PM
 */

 @Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"login", "store_id"}))
@NamedQueries({
    @NamedQuery(name = "findUserByEmail", query = "from User u where u.email = :email"),
    @NamedQuery(name = "findUserByLogin", query = "from User u where u.login = :login"),
    @NamedQuery(name = "findUserByLoginAndStore", query = "from User u where u.login = :login and u.storeId = :storeId"),
    @NamedQuery(name = "findByUserEmailAndPassword", query = "from User u where u.email = :email and u.passwordChecksum = :passwordEncrypted"),
    @NamedQuery(name = "findUserById", query = "from User u where u.id = :userId ")})
public class User extends JSONObject implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "login", nullable = false, length = 80)
  private String login;

  @Column(name = "email", nullable = true, length = 80)
  private String email;

  @Column(name = "name", nullable = true, length = 80)
  private String name;

  @Column(name = "password_checksum", nullable = false)
  private String passwordChecksum;

  @Temporal(TemporalType.DATE)
  @Column(name = "birth_date", nullable = true, length = 19)
  private Date birthDate;

  @Column(name = "gender", nullable = true, length = 6)
  private String gender;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_login_date", nullable = false, length = 19)
  private Date lastLoginDate;

  @Column(name = "badge_id")
  private Long badgeId;

  @ManyToMany(fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SELECT)
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_name", referencedColumnName = "name"))
  private Set<Role> roles = new HashSet<Role>(0);

  @Column(name = "user_hash", nullable = false, length = 32, unique = true)
  private String userHash;

  @Column(name = "store_id", nullable = false)
  private Long storeId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return this.login;
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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Set<String> getRoleStrings() {
    Set<String> roleStrings = new HashSet<String>();
    for (Role role : roles) {
      roleStrings.add(role.getName());
    }
    return roleStrings;
  }

  public String getPasswordChecksum() {
    return passwordChecksum;
  }

  public void setPasswordChecksum(String passwordChecksum) {
    this.passwordChecksum = passwordChecksum;
  }

  public Long getBadgeId() {
    return badgeId;
  }

  public void setBadgeId(Long badgeId) {
    this.badgeId = badgeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return id == null ? "" : id.toString();
  }

  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public String getUserHash() {
    return userHash;
  }

  public void setUserHash(String userHash) {
    this.userHash = userHash;
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

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o instanceof User) {
      User user = (User) o;
      return new EqualsBuilder()
          .append(this.login, user.getLogin())
          .append(this.storeId, user.getStoreId())
          .isEquals();
    }

    return false;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(this.login)
        .append(this.storeId)
        .toHashCode();
  }

  @Override
  protected String[] getKeys() {
    return new String[]{"id", "login", "email", "name"};
  }

  @Override
  protected Object[] getValues() {
    return new Object[]{this.id, this.login, this.email != null ? this.email : "", this.name != null ? this.name : ""};
  }
}

