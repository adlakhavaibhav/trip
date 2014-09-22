<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">
        <div id="wrapper" class="container">
        <section class="header_text sub">

            <h4><span>Regsiter as a User</span></h4>
        </section>
        <section class="main-content">
            <div class="row">

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

                            </div>
                        </fieldset>
                    </s:form>
                </div>
            </div>
        </section>


    </s:layout-component>

</s:layout-render>