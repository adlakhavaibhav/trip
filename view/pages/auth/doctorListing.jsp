<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">
        <div class="content-outer wrap">

        <div class="col_12">
            <div id="page-heading">
                <h4>All Doctors Listing</h4>
            </div>
            <s:useActionBean beanclass="com.td.web.action.doctor.DoctorListingAction" var="doctorListing"/>

            <div class="col_12" style="background: #f5f5f5; border-radius: 8px;">

                <c:forEach items="${doctorListing.doctors}" var="doctor">
                    <div class="col_12" style="border-bottom: 1px solid">
                        <div class="col_4">
                            <img src="/pages/auth/bootstrap/img/default_profile_pic.jpg"
                                 style="max-height: 120px;max-width: 100px;">
                        </div>
                        <div class="col_4">
                            <h5> Dr. ${doctor.name} </h5>
                            14 years experience
                            <br/>
                            Specialities:
                            <c:forEach items="${doctor.specialities}" var="speciality">

                                ${speciality.speciality.name},

                            </c:forEach>

                        </div>
                        <div class="col_4 gallery">
                            <span style="font-weight: bold;font-size: 13px;margin-bottom: 15px;">Rs. 400</span>
                            <br/>
                            <s:link beanclass="com.td.web.action.appointment.BookAppointmentAction"
                                    event="pre" class="button orange fancy" style="padding:8px;">
                                <s:param name="doctorId" value="${doctor.id}"/>
                                Book an appointment
                            </s:link>
                                <%--<button class="button orange">Book an appointment</button>--%>
                        </div>


                    </div>

                </c:forEach>
            </div>


        </div>

    </s:layout-component>

</s:layout-render>