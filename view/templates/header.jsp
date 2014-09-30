<%@ page import="com.td.shiro.PrincipalImpl" %>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@include file="/includes/taglibInclude.jsp" %>
<s:layout-definition>

    <link href="/pages/auth/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pages/auth/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="/pages/auth/themes/css//bootstrappage.css" rel="stylesheet"/>

    <!-- global styles -->
    <link href="/pages/auth/themes/css//flexslider.css" rel="stylesheet"/>
    <link href="/pages/auth/themes/css//main.css" rel="stylesheet"/>

    <!-- scripts -->
    <%--<script src="/pages/auth/themes/js//jquery-1.7.2.min.js"></script>--%>
    <%--<script src="/pages/auth/bootstrap/js//bootstrap.min.js"></script>
    <script src="/pages/auth/themes/js//superfish.js"></script>
    <script src="/pages/auth/themes/js//jquery.scrolltotop.js"></script>--%>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jMenu.jquery.css" type="text/css"/>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/kickstart.css"
          media="all"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/chosen.css"
          media="all"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/css/jquery.ui.autocomplete.css"
          media="all"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/jquery.ui.theme.css"
          media="all"/>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css?v=2.3"
          media="all"/>
    <!-- CUSTOM STYLES -->
    <%--<link href="../assets/css/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css"/>--%>

    <%--<link href="../assets/css/admin.css" rel="stylesheet" type="text/css"/>--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.8.21.custom.min.js"></script>

    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jMenu.jquery.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/underscore-1.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/kickstart.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/hkCommon.js?v=1.1"></script>


    <%
        boolean isDoctor = false;
        PrincipalImpl principal = (PrincipalImpl) SecurityUtils.getSubject().getPrincipal();
        if (principal != null) {
            pageContext.setAttribute("userId", principal.getId());
            isDoctor = principal.isDoctor();
        } else {
            pageContext.setAttribute("userId", null);
        }


    %>


    <div id='cssmenu'>


            <%--  <div class="span4" style="font-size: 24px;font-weight: bold">
                  <a href="${pageContext.request.contextPath}/Home.action">TripMD</a>
              </div>--%>


        <ul>

            <c:choose>
                <c:when test="${userId eq null}">
                    <li><a href='${pageContext.request.contextPath}/user/UserSignup.action'>Join as User</a>
                    </li>
                    <li><a href='${pageContext.request.contextPath}/doctor/DoctorSignup.action'>Join as
                        Doctor</a></li>
                    <li><a href='${pageContext.request.contextPath}/user/UserLogin.action'>Login</a></li>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="<%=isDoctor%>">
                            <li><a href="${pageContext.request.contextPath}/doctor/DoctorProfile.action">My
                                (Doc) Profile</a></li>
                            <li><a href="${pageContext.request.contextPath}/account/DoctorAppointmentList.action">My
                                Appointments</a></li>
                            <li><a href="${pageContext.request.contextPath}/auth/Logout.action">Hi Dr.<shiro:principal
                                    property="firstName"/> (Logout)</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/doctor/DoctorListing.action">Doctor
                                Listing</a></li>
                            <li><a href="${pageContext.request.contextPath}/doctor/DoctorSearch.action">Doctor
                                Search</a></li>
                            <li><a href="${pageContext.request.contextPath}/account/UserAppointmentList.action">My
                                Appointments</a></li>
                            <li><a href="${pageContext.request.contextPath}/auth/Logout.action">Hi <shiro:principal
                                    property="firstName"/> (Logout)</a></li>

                        </c:otherwise>
                    </c:choose>
                    <li class="brdr-t">
                            <%--  <s:link beanclass="com.td.web.action.auth.LogoutAction">
                                  <s:param name="redirectUrl" value="/"/>
                                  Logout
                              </s:link>--%>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>


</s:layout-definition>