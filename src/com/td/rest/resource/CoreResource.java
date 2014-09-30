package com.td.rest.resource;

import com.td.domain.doctor.Speciality;
import com.td.pact.service.auth.DoctorService;
import com.td.util.json.JSONResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/29/14
 * Time: 10:35 PM
 */
@Component
@Path("/core/")
public class CoreResource {

  @Autowired
  private DoctorService doctorService;

  @GET
  @Path("/specialities/all")
  @Produces("application/json")
  public String getAllSpecialities() {
    List<Speciality> allSpecialities = getDoctorService().getAllSpecialities();

    return new JSONResponseBuilder().addField("exception", false).addField("results", allSpecialities).build();
  }

  public DoctorService getDoctorService() {
    return doctorService;
  }
}
