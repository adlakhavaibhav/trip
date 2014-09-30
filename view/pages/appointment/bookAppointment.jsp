<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/popup.jsp">

    <s:layout-component name="content">

        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/assets/css/jquery.simple-dtpicker.css"
              media="all"/>
        <s:useActionBean beanclass="com.td.web.action.appointment.BookAppointmentAction"
                         var="bookAppointmentAction"/>
        <div class="content-outer wrap">
            <div class="col_12">
                <div id="page-heading">
                    <h4>Book an Appointment with ${bookAppointmentAction.doctor.name}</h4>
                </div>
                <div class="col_12">
                    <fieldset>
                        <s:form beanclass="com.td.web.action.appointment.BookAppointmentAction" id="bookAppForm"
                                class="vertical">
                            <div class="col_4">
                                <s:label name="Date And Time For Your Visit"/>
                                <s:text name="dateTimeOfVisit" id="dateTimeOfVisit"/>
                                <s:text name="doctorId" id="doctorId" value="${bookAppointmentAction.doctorId}"/>
                            </div>

                            <div class="col_2">
                                <s:submit name="bookAppointment" style="margin: 5px; margin-top:10px;"
                                          class="button green small">Confirm Appointment</s:submit>
                            </div>
                        </s:form>
                    </fieldset>
                </div>
            </div>
        </div>


    </s:layout-component>

    <s:layout-component name="scriptComponent">
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/assets/js/jquery.simple-dtpicker.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {


                $("#dateTimeOfVisit").appendDtpicker({"inline": false, "autodateOnStart": false,
                    "minTime": "10:00", "maxTime": "18:00",
                    "allowWdays": [1, 2, 3, 4, 5, 6], "closeOnSelected": true,
                    "futureOnly": true});

            });
        </script>
    </s:layout-component>
</s:layout-render>