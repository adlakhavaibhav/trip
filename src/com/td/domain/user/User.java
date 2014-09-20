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
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "findUserByEmail", query = "from User u where u.email = :email"),
    @NamedQuery(name = "findByUserEmailAndPassword", query = "from User u where u.email = :email and u.passwordChecksum = :passwordEncrypted"),
    @NamedQuery(name = "findUserById", query = "from User u where u.id = :userId ")})
public class User extends JSONObject implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "fname", nullable = false, length = 80)
  private String fname;

  @Column(name = "lname", length = 80)
  private String lname;


  @Column(name = "user_hash", nullable = false, length = 32, unique = true)
  private String userHash;


  @Column(name = "email", nullable = true, length = 80)
  private String email;


  @Column(name = "password_checksum", nullable = false)
  private String passwordChecksum;
/*

  @Temporal(TemporalType.DATE)
  @Column(name = "birth_date", nullable = true, length = 19)
  private Date birthDate;
*/

  @Column(name = "gender", nullable = true, length = 6)
  private String gender;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_login_date", nullable = false, length = 19)
  private Date lastLoginDate;


  @ManyToMany(fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SELECT)
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_name", referencedColumnName = "name"))
  private Set<Role> roles = new HashSet<Role>(0);

  @Column(name = "create_dt", nullable = false)
  private Date createDt = new Date();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String toString() {
    return id == null ? "" : id.toString();
  }

  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o instanceof User) {
      User user = (User) o;
      return new EqualsBuilder()
          .append(this.email, user.getEmail())

          .isEquals();
    }

    return false;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getUserHash() {
    return userHash;
  }

  public void setUserHash(String userHash) {
    this.userHash = userHash;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(this.email)
        .toHashCode();
  }

  @Override
  protected String[] getKeys() {
    return new String[]{"id", "email", "fname"};
  }

  @Override
  protected Object[] getValues() {
    return new Object[]{this.id, this.email, this.fname};
  }
}

