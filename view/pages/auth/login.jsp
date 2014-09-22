<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">
        <div id="wrapper" class="container">


        <section class="header_text sub">

            <h4><span>Login To Your Account</span></h4>
        </section>
        <section class="main-content">
            <div class="row">
                <div class="span12 center">
                    <s:form id="loginForm" beanclass="com.td.web.action.user.UserLoginAction" class="form-stacked">

                        <fieldset>
                            <div class="control-group">
                                <%--<label class="control-label">Email</label>--%>

                                <div class="controls">
                                    <s:text name="email" placeholder="Enter your email" class="input-xlarge"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <%--<label class="control-label">Password</label>--%>

                                <div class="controls">
                                    <s:password name="password" placeholder="Enter your password" class="input-xlarge"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <s:submit name="login" tabindex="3" class="btn btn-inverse large"
                                          value="Sign into your account"/>
                                <hr>
                                <p class="reset">Recover your <a tabindex="4" href="#"
                                                                 title="Recover your username or password">username or
                                    password</a></p>
                            </div>
                        </fieldset>
                    </s:form>
                </div>

            </div>
        </section>


    </s:layout-component>

</s:layout-render>