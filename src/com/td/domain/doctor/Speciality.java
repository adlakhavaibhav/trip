package com.td.domain.doctor;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/21/14
 * Time: 8:36 PM
 */
@Entity
@Table(name = "speciality")
@NamedQueries({
    @NamedQuery(name = "findSpecialityById", query = "from Speciality sp where sp.id = :specialityId ")
})
public class Speciality {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String desc;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
