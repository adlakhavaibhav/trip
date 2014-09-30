<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">

        <s:useActionBean beanclass="com.td.web.action.doctor.DoctorProfileAction" var="doctorProfile"/>
        <div class="content-outer wrap">

            <div class="col_12">
                <div id="page-heading">
                    <h4>Dr. ${doctorProfile.doctor.fname}'s profile</h4>
                </div>

                <div class="well">
                    <div class="col_3">
                        <span>Email address: ${doctorProfile.doctor.email}</span>
                    </div>
                    <div class="col_3">
                        <span>Name: ${doctorProfile.doctor.name}</span>
                    </div>

                    <div class="col_6">
                        <span>Specialities (select multiple):</span>
                        <c:forEach items="${doctorProfile.doctor.specialities}" var="speciality"
                                   varStatus="cacheDTOctr">
                            ${speciality.speciality.name}, ${speciality.speciality.desc}

                        </c:forEach>

                    </div>
                </div>

                <div class="clear"></div>
                Clinic Details Coming Soon !
            </div>
        </div>

    </s:layout-component>

</s:layout-render>