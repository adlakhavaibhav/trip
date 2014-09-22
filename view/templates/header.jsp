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
    <script src="/pages/auth/themes/js//jquery-1.7.2.min.js"></script>
    <script src="/pages/auth/bootstrap/js//bootstrap.min.js"></script>
    <script src="/pages/auth/themes/js//superfish.js"></script>
    <script src="/pages/auth/themes/js//jquery.scrolltotop.js"></script>
    <div id="top-bar" class="container">
        <div class="row">

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


            <div class="span4" style="font-size: 24px;font-weight: bold">
                <a href="${pageContext.request.contextPath}/Home.action">TripMD</a>
            </div>

            <div class="span8" style="font-size: 13px;">
                <div class="account pull-right">
                    <ul class="user-menu">

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
                                        <li style="font-size: 13px;width: 50px;">Hi Dr. <shiro:principal
                                                property="firstName"/></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${pageContext.request.contextPath}/doctor/DoctorListing.action">Doctor
                                            Listing</a></li>
                                        <li style="font-size: 13px;width: 50px;">Hi <shiro:principal
                                                property="firstName"/></li>

                                    </c:otherwise>
                                </c:choose>
                                <li class="brdr-t">
                                    <s:link beanclass="com.td.web.action.auth.LogoutAction">
                                        <s:param name="redirectUrl" value="/"/>
                                        Logout
                                    </s:link>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>


        </div>
    </div>
</s:layout-definition>