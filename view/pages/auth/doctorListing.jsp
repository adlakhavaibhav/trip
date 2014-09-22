<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">
        <div id="wrapper" class="container">

            <div class="row">
                <h3 style="margin-left: 30px;">Doctors Listed With Us</h3>

            </div>
            <s:useActionBean beanclass="com.td.web.action.doctor.DoctorListingAction" var="doctorListing"/>

            <div class="well well-small">

                <c:forEach items="${doctorListing.doctors}" var="doctor">
                    <div class="row" style="padding: 15px;border-bottom: 1px solid #d6d6d6;margin-left: 40px;">
                        <div class="span2">
                            <img src="/pages/auth/bootstrap/img/default_profile_pic.jpg"
                                 style="max-height: 120px;max-width: 100px;">
                        </div>
                        <div class="span6">
                            <h5> Dr. ${doctor.name} </h5>

                            Specialities:
                            <c:forEach items="${doctor.specialities}" var="speciality">

                                        ${speciality.speciality.name},

                            </c:forEach>

                        </div>
                        <div class="span4 pull-right" style="margin-right: 40px;text-align: center">
                            Rs. 400
                            <br/>
                            <button class="btn btn-inverse">Book an appointment</button>
                        </div>


                    </div>

                </c:forEach>
            </div>


        </div>

    </s:layout-component>

</s:layout-render>