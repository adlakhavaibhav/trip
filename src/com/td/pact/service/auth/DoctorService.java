package com.td.pact.service.auth;

import com.td.domain.doctor.Doctor;
import com.td.domain.doctor.Speciality;
import com.td.rest.request.user.CreateDoctorRequest;
import com.td.rest.response.doctor.CreateDoctorResponse;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/21/14
 * Time: 5:51 PM
 */
public interface DoctorService {

  public CreateDoctorResponse signupDoctor(CreateDoctorRequest createDoctorRequest);

  public Doctor getDoctorById(Long doctorId);

  public List<Speciality> getAllSpecialities();



}
