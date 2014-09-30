<%@ page import="com.td.constants.appointment.EnumAppointmentStatus" %>
<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">
        <s:useActionBean beanclass="com.td.web.action.account.DoctorAppointmentListAction"
                         var="doctorAppointmentListAction"/>
        <div class="content-outer wrap">
            <div class="col_12">
                <div id="page-heading">
                    <h4>Your Appointments</h4>
                </div>

                <c:if test="${doctorAppointmentListAction.userAppointmentList !=null}">
                    <s:layout-render name="/layouts/paginationResultCount.jsp"
                                     paginatedBean="${doctorAppointmentListAction}"/>
                    <s:layout-render name="/layouts/pagination.jsp" paginatedBean="${doctorAppointmentListAction}"/>

                    <table id="userAppointments" class="striped tight" cellpadding="0" cellspacing="0">

                        <tr>
                            <th>Patient Name</th>
                            <th>Date and Time of Visit</th>
                            <th>Status</th>
                            <th></th>

                        </tr>
                        <c:forEach items="${doctorAppointmentListAction.userAppointmentList}" var="userAppointment"
                                   varStatus="userAppointmentCtr">
                            <tr>
                                <td>
                                        ${userAppointment.userName}
                                </td>
                                <td>
                                    <fmt:formatDate type="date" dateStyle="medium"
                                                    value="${userAppointment.appointmentDate}"/>
                                    , ${userAppointment.appointmentTime}
                                </td>
                                <td>
                                        ${userAppointment.status}
                                </td>
                                <td>
                                    <c:if test="${userAppointment.docCancel}">
                                        <s:link beanclass="com.td.web.action.account.DoctorAppointmentListAction"
                                                event="updateAppointmentStatus" class="button small blue"
                                                style="padding:8px;">
                                            <s:param name="appointmentId" value="${userAppointment.id}"/>
                                            <s:param name="appStatus"
                                                     value="<%=EnumAppointmentStatus.CANCELLED.getId()%>"/>
                                            Cancel Appointment
                                        </s:link>
                                        <s:link beanclass="com.td.web.action.account.DoctorAppointmentListAction"
                                                event="updateAppointmentStatus" class="button small blue"
                                                style="padding:8px;">
                                            <s:param name="appointmentId" value="${userAppointment.id}"/>
                                            <s:param name="appStatus"
                                                     value="<%=EnumAppointmentStatus.CONFIRMED.getId()%>"/>
                                            Confirm Appointment
                                        </s:link>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>


            </div>
        </div>


    </s:layout-component>

    <s:layout-component name="scriptComponent">

        <script type="text/javascript">
            $(document).ready(function () {

            });
        </script>
    </s:layout-component>
</s:layout-render>