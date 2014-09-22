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
                PrincipalImpl principal = (PrincipalImpl) SecurityUtils.getSubject().getPrincipal();
                if (principal != null) {
                    pageContext.setAttribute("userId", principal.getId());
                    System.out.println("em" + principal.getEmail());
                } else {
                    pageContext.setAttribute("userId", null);
                }


            %>


            <div class="span4">
                TripMD
            </div>

            <div class="span8">
                <div class="account pull-right">
                    <ul class="user-menu">

                        <c:choose>
                            <c:when test="${userId eq null}">
                                <li><a href="#">Doctor Login</a></li>
                                <li><a href='${pageContext.request.contextPath}/user/UserSignup.action'>User Login</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="#">Doctor Listing</a></li>
                                <li style="font-size: 13px;">Hi <shiro:principal property="firstName"/></li>
                                <s:link beanclass="com.td.web.action.auth.LogoutAction">
                                    <li class="brdr-t">Logout</li>
                                    <s:param name="redirectUrl" value="/"/>
                                </s:link>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>


        </div>
    </div>
</s:layout-definition>