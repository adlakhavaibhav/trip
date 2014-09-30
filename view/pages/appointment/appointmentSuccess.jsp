<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">

        <s:useActionBean beanclass="com.td.web.action.appointment.BookAppointmentAction"
                         var="bookAppointmentAction"/>
        <div class="content-outer wrap">
            <div class="col_12" style="font-size: 14px;">

                Thank you Mr. <span style="font-weight: bold">${bookAppointmentAction.confirmedAppointmentDTO.userName} </span>
                for booking an appointment with <span style="font-weight: bold"> Dr. ${bookAppointmentAction.confirmedAppointmentDTO.doctorName}</span>
                at  <span style="font-weight: bold"> ${bookAppointmentAction.confirmedAppointmentDTO.appointmentDate}, ${bookAppointmentAction.confirmedAppointmentDTO.appointmentTime}.</span>

                <br>
                We will inform you once the doctor confirms the appointment.

            </div>
        </div>


    </s:layout-component>

    <s:layout-component name="scriptComponent">


    </s:layout-component>
</s:layout-render>