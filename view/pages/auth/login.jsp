<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">

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

                <div class="span4">
                    TripMD
                </div>

                <div class="span8">
                    <div class="account pull-right">
                        <ul class="user-menu">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Your Cart</a></li>
                            <li><a href="#">Checkout</a></li>
                            <li><a href='${pageContext.request.contextPath}/user/UserSignup.action'>Login</a></li>
                        </ul>
                    </div>
                </div>


            </div>
        </div>
        <div id="wrapper" class="container">


        <section class="header_text sub">

            <h4><span>Login or Regsiter</span></h4>
        </section>
        <section class="main-content">
            <div class="row">
                <div class="span5">
                    <h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>

                    <form action="#" method="post">
                        <input type="hidden" name="next" value="/">
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">Username</label>

                                <div class="controls">
                                    <input type="text" placeholder="Enter your username" id="username"
                                           class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Username</label>

                                <div class="controls">
                                    <input type="password" placeholder="Enter your password" id="password"
                                           class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <input tabindex="3" class="btn btn-inverse large" type="submit"
                                       value="Sign into your account">
                                <hr>
                                <p class="reset">Recover your <a tabindex="4" href="#"
                                                                 title="Recover your username or password">username or
                                    password</a></p>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="span7">
                    <h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>

                    <s:form id="registerForm" beanclass="com.td.web.action.user.UserSignupAction" class="form-stacked">

                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">Email address:</label>

                                <div class="controls">
                                    <s:text name="email" placeholder="Enter your email" class="input-xlarge"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">First Name:</label>

                                <div class="controls">
                                    <s:text name="fname" placeholder="Enter your first name" class="input-xlarge"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Last Name:</label>

                                <div class="controls">
                                    <s:text name="lname" placeholder="Enter your last name" class="input-xlarge"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Password:</label>

                                <div class="controls">
                                    <s:password name="password" placeholder="Enter your password" class="input-xlarge"/>
                                </div>
                            </div>


                            <hr>
                            <div class="actions">
                                <s:submit name="signup" tabindex="9" class="btn btn-inverse large"
                                          value="Create your account"/>
                                <input>
                            </div>
                        </fieldset>
                    </s:form>
                </div>
            </div>
        </section>


    </s:layout-component>

</s:layout-render>