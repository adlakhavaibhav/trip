<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="themes/css/bootstrappage.css" rel="stylesheet"/>

        <!-- global styles -->
        <link href="themes/css/flexslider.css" rel="stylesheet"/>
        <link href="themes/css/main.css" rel="stylesheet"/>

        <!-- scripts -->
        <script src="themes/js/jquery-1.7.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="themes/js/superfish.js"></script>
        <script src="themes/js/jquery.scrolltotop.js"></script>

        <div id="top-bar" class="container">
            <div class="row">

                <div class="span4">
                    TripMD
                </div>

                <div class="span8">
                    <div class="account pull-right">
                        <ul class="user-menu">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Doctor Listing</a></li>
                            <li><a href="#">Doctor Login</a></li>
                            <li><a href='${pageContext.request.contextPath}/user/UserSignup.action'>User Login</a></li>
                        </ul>
                    </div>
                </div>


            </div>
        </div>
        <div id="wrapper" class="container">


        <section class="header_text">
            We�re on a mission to make high quality healthcare accessible worldwide
        </section>


    </s:layout-component>

</s:layout-render>