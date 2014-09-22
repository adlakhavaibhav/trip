<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/taglibInclude.jsp" %>
<s:layout-definition>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html>
    <head>
        <title>
            TripMD
        </title>
        <s:layout-component name="htmlHead"/>


    </head>
    <body style="background-color:#415252">
    <s:layout-component name="modal"/>


    <s:layout-component name="header">
        <s:layout-render name="/templates/header.jsp"/>
    </s:layout-component>

    <h1><s:layout-component name="heading"/></h1>


    <s:layout-component name="messages">
        <s:errors/>
        <div id="error-messages"></div>
        <div><s:messages key="generalMessages"/></div>
    </s:layout-component>

    <s:layout-component name="content">
    </s:layout-component>

    <s:layout-component name="scriptComponent"/>
    <s:layout-render name="/templates/footer.jsp"/>

        <%--</div>--%>

    </body>
    </html>
</s:layout-definition>