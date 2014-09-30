package com.td.web.action.doctor;

import com.td.domain.doctor.Doctor;
import com.td.domain.doctor.Speciality;
import com.td.pact.service.auth.DoctorService;
import com.td.web.action.BasePaginatedAction;
import com.td.web.action.Page;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/29/14
 * Time: 6:20 PM
 */
@Component
public class DoctorSearchAction extends BasePaginatedAction {

  private Page doctorsPage;
  private List<Doctor> doctors;
  private Long pageNum;

  private List<Speciality> allSpecialityList;
  private String doctorName;
  private Long specialityId;


  @Autowired
  private DoctorService doctorService;


  @Override
  public int getPageCount() {
    return doctorsPage != null ? doctorsPage.getTotalPages() : 0;
  }

  @Override
  public int getResultCount() {
    return doctorsPage != null ? doctorsPage.getTotalResults() : 0;
  }

  @Override
  public Set<String> getParamSet() {
    HashSet<String> params = new HashSet<String>();
    params.add("doctorName");
    params.add("specialityId");

    return params;
  }

  @DefaultHandler
  public Resolution pre() {
    allSpecialityList = getDoctorService().getAllSpecialities();
    return new ForwardResolution("/pages/auth/doctorSearch.jsp");
  }

  @SuppressWarnings("unchecked")
  public Resolution searchStoreVariants() {
    if (pageNum != null) {
      setPageNo(pageNum.intValue());
    }

    if (specialityId == null) {
      doctorsPage = getDoctorService().searchDoctors(doctorName, getPageNo(), getPerPage());
    } else {
      doctorsPage = getDoctorService().searchDoctors(doctorName, specialityId, getPageNo(), getPerPage());
    }
    doctors = doctorsPage.getList();

    return new ForwardResolution("/pages/auth/doctorSearch.jsp");
  }

  public Page getDoctorsPage() {
    return doctorsPage;
  }

  public void setDoctorsPage(Page doctorsPage) {
    this.doctorsPage = doctorsPage;
  }

  public Long getPageNum() {
    return pageNum;
  }

  public void setPageNum(Long pageNum) {
    this.pageNum = pageNum;
  }

  public DoctorService getDoctorService() {
    return doctorService;
  }

  public void setDoctorService(DoctorService doctorService) {
    this.doctorService = doctorService;
  }

  public List<Speciality> getAllSpecialityList() {
    return allSpecialityList;
  }

  public void setAllSpecialityList(List<Speciality> allSpecialityList) {
    this.allSpecialityList = allSpecialityList;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public Long getSpecialityId() {
    return specialityId;
  }

  public void setSpecialityId(Long specialityId) {
    this.specialityId = specialityId;
  }

  public List<Doctor> getDoctors() {
    return doctors;
  }

  public void setDoctors(List<Doctor> doctors) {
    this.doctors = doctors;
  }
}
