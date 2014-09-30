<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">

        <s:useActionBean beanclass="com.td.web.action.appointment.BookAppointmentAction"
                         var="bookAppointmentAction"/>
        <div class="content-outer wrap">
            <div class="col_12">

                Thank you Mr. ${bookAppointmentAction.confirmedAppointmentDTO.userName}
                for booking an appointment with Dr. ${bookAppointmentAction.confirmedAppointmentDTO.doctorName}
                at ${bookAppointmentAction.confirmedAppointmentDTO.appointmentDate}, ${bookAppointmentAction.confirmedAppointmentDTO.appointmentTime}.

                <br>
                We will inform you once the doctor confirms the appointment.

            </div>
        </div>


    </s:layout-component>

    <s:layout-component name="scriptComponent">


    </s:layout-component>
</s:layout-render>