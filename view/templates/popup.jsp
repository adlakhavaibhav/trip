<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/taglibInclude.jsp" %>
<s:layout-definition>
  <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <html>
  <head>
    <title>
        <%--<c:choose>
          <c:when test="${hk:isNotBlank(pageTitle)}">
            ${pageTitle}
          </c:when>
          <c:otherwise>
            <c:if test="${hk:isNotBlank(topHeading)}">
              ${topHeading}
            </c:if>
          </c:otherwise>
        </c:choose>--%>
      TripMD
    </title>
    <s:layout-component name="htmlHead"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/screen.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/kickstart.css"
          media="all"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/chosen.css"
          media="all"/>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/jquery.ui.theme.css"
          media="all"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css?v=1.1"
          media="all"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.8.21.custom.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/kickstart.js"></script>


  </head>
  <body>
  <s:layout-component name="modal"/>
    <%--<div id="container" class="container_24">--%>

  <s:layout-component name="header">
  </s:layout-component>

  <h1><s:layout-component name="heading"/></h1>

  <s:layout-component name="messages">
    <s:errors/>
    <div id="error-messages"></div>

  </s:layout-component>

  <s:layout-component name="content">

  </s:layout-component>

  <s:layout-component name="scriptComponent"/>
  <s:layout-render name="/templates/footer.jsp"/>

    <%--</div>--%>

  </body>
  </html>
</s:layout-definition>