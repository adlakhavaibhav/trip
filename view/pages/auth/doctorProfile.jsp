<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">

        <s:useActionBean beanclass="com.td.web.action.doctor.DoctorProfileAction" var="doctorProfile"/>
        <div class="content-outer wrap">
            <section class="header_text sub">
                <h4><span>Dr. ${doctorProfile.doctor.fname}'s profile</span></h4>
            </section>

            <section class="main-content">
                <div class="row">
                    <div class="span7">
                        <form id="test" class="form-horizontal">
                            <fieldset>
                                <div class="control-group">
                                    <label class="control-label">Email address:</label>

                                    <div class="controls">
                                            ${doctorProfile.doctor.email}
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Specialities (select multiple):</label>

                                    <div class="controls">
                                        <c:forEach items="${doctorProfile.doctor.specialities}" var="speciality"
                                                   varStatus="cacheDTOctr">
                                            ${speciality.speciality.name}, ${speciality.speciality.desc}
                                            <br/>
                                        </c:forEach>

                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">First Name:</label>

                                    <div class="controls">
                                            ${doctorProfile.doctor.fname}
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label">Last Name:</label>

                                    <div class="controls">
                                            ${doctorProfile.doctor.lname}
                                    </div>
                                </div>


                                <hr>

                            </fieldset>
                        </form>
                    </div>
                </div>
            </section>
        </div>


    </s:layout-component>

</s:layout-render>