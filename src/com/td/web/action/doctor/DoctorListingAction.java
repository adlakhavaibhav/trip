package com.td.web.action.doctor;

import com.td.domain.doctor.Doctor;
import com.td.pact.dao.BaseDao;
import com.td.web.action.BaseAction;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/22/14
 * Time: 11:31 AM
 */
@Component
public class DoctorListingAction extends BaseAction {

  private List<Doctor> doctors;
  @Autowired
  private BaseDao baseDao;


  @DefaultHandler
  public Resolution pre() {

    doctors = getBaseDao().getAll(Doctor.class);


    return new ForwardResolution("/pages/auth/doctorListing.jsp");

  }

  public List<Doctor> getDoctors() {
    return doctors;
  }

  public void setDoctors(List<Doctor> doctors) {
    this.doctors = doctors;
  }

  public void setBaseDao(BaseDao baseDao) {
    this.baseDao = baseDao;
  }

  public BaseDao getBaseDao() {
    return baseDao;
  }
}
