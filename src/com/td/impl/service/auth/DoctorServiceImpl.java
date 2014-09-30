package com.td.impl.service.auth;

import com.td.domain.doctor.Doctor;
import com.td.domain.doctor.DoctorSpeciality;
import com.td.domain.doctor.Speciality;
import com.td.domain.user.User;
import com.td.exception.InvalidParameterException;
import com.td.pact.dao.BaseDao;
import com.td.pact.query.impl.DoctorBySpecialitySearchQuery;
import com.td.pact.query.impl.DoctorSearchQuery;
import com.td.pact.service.auth.DoctorService;
import com.td.pact.service.core.SearchService;
import com.td.pact.service.user.UserService;
import com.td.rest.constants.MessageConstants;
import com.td.rest.request.user.CreateDoctorRequest;
import com.td.rest.response.doctor.CreateDoctorResponse;
import com.td.rest.response.user.UserResponse;
import com.td.util.BaseUtils;
import com.td.web.action.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/22/14
 * Time: 9:48 AM
 */
@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private UserService userService;

  @Autowired
  private SearchService searchService;

  @Autowired
  private BaseDao baseDao;

  @Override
  @Transactional
  public CreateDoctorResponse signupDoctor(CreateDoctorRequest createDoctorRequest) {

    CreateDoctorResponse createDoctorResponse = new CreateDoctorResponse();
    if (!createDoctorRequest.validate()) {
      createDoctorResponse.setException(true);
      createDoctorResponse.addMessage(MessageConstants.SIGNUP_REQ_INVALID);
      return createDoctorResponse;
    }

    if (!BaseUtils.isValidEmail(createDoctorRequest.getEmail())) {
      createDoctorResponse.setException(true);
      createDoctorResponse.addMessage(MessageConstants.INVALID_EMAIL);
      return createDoctorResponse;
    }

    User user = getUserService().getUserByEmail(createDoctorRequest.getEmail());
    if (user != null) {
      createDoctorResponse.setException(true);
      createDoctorResponse.addMessage(MessageConstants.USER_ID_ALREADY_TAKEN);
      return createDoctorResponse;
    }


    Doctor doctor = new Doctor();
    doctor.setFname(createDoctorRequest.getFname());
    doctor.setLname(createDoctorRequest.getLname());


    doctor.setEmail(createDoctorRequest.getEmail());
    doctor.setPasswordChecksum(BaseUtils.passwordEncrypt(createDoctorRequest.getPassword()));

    doctor = getUserService().saveDoctor(doctor);

    createDoctorResponse.setUserResponse(new UserResponse(doctor));

    for (Long specialityId : createDoctorRequest.getSpecialityIds()) {
      DoctorSpeciality doctorSpeciality = new DoctorSpeciality();
      doctorSpeciality.setDoctor(doctor);
      Speciality speciality = getBaseDao().get(Speciality.class, specialityId);

      //doctorSpeciality.setSpecialityId(specialityId);
      doctorSpeciality.setSpeciality(speciality);
      getBaseDao().save(doctorSpeciality);
    }

    return createDoctorResponse;
  }

  @Override
  public Doctor getDoctorById(Long doctorId) {
    if (doctorId == null) {
      throw new InvalidParameterException("DOC_ID_CANNOT_BE_NULL");
    }

    return (Doctor) getBaseDao().findUniqueByNamedQueryAndNamedParam("findDoctorById", new String[]{"doctorId"}, new Object[]{doctorId});
  }

  @Override
  public List<Speciality> getAllSpecialities() {
    return getBaseDao().getAll(Speciality.class);
  }

  @Override
  public Page searchDoctors(String doctorName, int pageNo, int perPage) {

    DoctorSearchQuery doctorSearchQuery = new DoctorSearchQuery();
    doctorSearchQuery.setOrderByField("id");
    doctorSearchQuery.setDoctorName(doctorName);

    doctorSearchQuery.setOrderByField("id")
        .setPageNo(pageNo)
        .setRows(perPage);

    return getSearchService().list(doctorSearchQuery);
  }

  @Override
  public Page searchDoctors(String doctorName, Long specialityId, int pageNo, int perPage) {

    DoctorBySpecialitySearchQuery doctorBySpecialitySearchQuery = new DoctorBySpecialitySearchQuery();
    doctorBySpecialitySearchQuery.setOrderByField("id");
    doctorBySpecialitySearchQuery.setSpecialityId(specialityId);

    doctorBySpecialitySearchQuery.setOrderByField("id")
        .setPageNo(pageNo)
        .setRows(perPage);

    return getSearchService().list(doctorBySpecialitySearchQuery);
  }

  public UserService getUserService() {
    return userService;
  }

  public BaseDao getBaseDao() {
    return baseDao;
  }

  public SearchService getSearchService() {
    return searchService;
  }
}
