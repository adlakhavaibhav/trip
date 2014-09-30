package com.td.pact.query.impl;

import com.td.pact.query.SortField;
import com.td.pact.service.core.AbstractSearchQuery;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/29/14
 * Time: 6:06 PM
 */
public class DoctorSearchQuery extends AbstractSearchQuery {

  private String doctorName;

  public DoctorSearchQuery setDoctorName(String doctorName) {
    this.doctorName = doctorName;
    return this;
  }


  @Override
  protected String getBaseQuery(boolean isCountQuery) {
    StringBuilder queryStr;

    if (isCountQuery) {
      queryStr = new StringBuilder("select count(*) from Doctor d   where 1=1 ");
    } else {
      queryStr = new StringBuilder("select d from Doctor d    where 1=1 ");
    }

    if (StringUtils.isNotEmpty(doctorName)) {
      queryStr.append(" and (d.fname like  :doctorName or d.lname like :doctorName) ");
      getQueryParams().put("doctorName", "%" + doctorName + "%");
    }


    return queryStr.toString();
  }

  @Override
  protected List<SortField> getSortFields() {
    List<SortField> sortFields = new ArrayList<SortField>();
    sortFields.add(new SortField("fn", "fName"));
    sortFields.add(new SortField("id", "id"));

    return sortFields;

  }

  @Override
  protected String getAliasToApply() {
    return "d";
  }
}
