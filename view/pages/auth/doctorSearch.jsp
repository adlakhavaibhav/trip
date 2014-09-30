<%@ include file="/includes/taglibInclude.jsp" %>

<s:layout-render name="/templates/general.jsp">

    <s:layout-component name="content">
        <s:useActionBean beanclass="com.td.web.action.doctor.DoctorSearchAction"
                         var="doctorSearchAction"/>
        <div class="content-outer wrap">
            <div class="col_12">
                <div id="page-heading">
                    <h4>Search Doctors</h4>
                </div>
                <div class="col_12">
                    <fieldset>
                        <s:form beanclass="com.td.web.action.doctor.DoctorSearchAction" id="searchSVForm"
                                class="vertical">
                            <div class="col_4">
                                <s:label name="Doctor Name"/>
                                <s:text name="doctorName" placeholder="Enter Doctor Name"/>
                            </div>
                            <div class="col_4">
                                <s:label name="Speciality"/>
                                <input type="text" class="auto-adjust" id="spcAutoComp"
                                       placeholder="Enter Speciality"/>
                                <s:hidden name="specialityId" id="specialityId"/>

                            </div>


                            <div class="col_2">
                                <s:submit name="searchStoreVariants" style="margin: 5px; margin-top:10px;"
                                          class="button blue small search">Search</s:submit>
                            </div>
                        </s:form>
                    </fieldset>
                </div>
            </div>
            <div class="clear"></div>
            <c:if test="${doctorSearchAction.doctors !=null}">
                <s:layout-render name="/layouts/paginationResultCount.jsp" paginatedBean="${doctorSearchAction}"/>
                <s:layout-render name="/layouts/pagination.jsp" paginatedBean="${doctorSearchAction}"/>
                <div class="col_12" style="background: #f5f5f5;">
                    <c:forEach items="${doctorSearchAction.doctors}" var="doctor">
                        <div class="col_12" style="border-bottom: 1px solid">
                            <div class="col_4">
                                <img src="/pages/auth/bootstrap/img/default_profile_pic.jpg"
                                     style="max-height: 120px;max-width: 100px;">
                            </div>
                            <div class="col_4">
                                <h5> Dr. ${doctor.name} </h5>
                                14 years experience
                                <br/>
                                Specialities:
                                <c:forEach items="${doctor.specialities}" var="speciality">

                                    ${speciality.speciality.name},

                                </c:forEach>

                            </div>
                            <div class="col_4">
                                <span style="font-weight: bold;font-size: 13px;margin-bottom: 15px;">Rs. 400</span>
                                <br/>
                                <button class="button orange">Book an appointment</button>
                            </div>


                        </div>

                    </c:forEach>

                </div>
            </c:if>


        </div>


    </s:layout-component>

    <s:layout-component name="scriptComponent">
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/autocompleter.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#specialityId').val("");

                var autoElem = $('#spcAutoComp');
                var autoMinLen = 2;

                var onBrandAutoCompleteSuccess = function (responseData) {
                    return $.map(responseData.results, function (item) {
                        if (HK.String.isBlank(item.sc)) {
                            return{
                                label: item.name,
                                value: item.name,
                                brandId: item.id
                            };
                        } else {
                            return{
                                label: item.name + " (" + item.sc + ")",
                                value: item.name + " (" + item.sc + ")",
                                brandId: item.id
                            };
                        }
                    });
                };

                var onBrandAutoCompleteSelect = function (ui) {
                    $('#specialityId').val((ui.item ? ui.item.brandId : ""));
                };

                // Overrides the default autocomplete filter function to search only from the beginning of the string
                var onBrandFilter = function (array, term) {
                    var matcher = new RegExp("^" + $.ui.autocomplete.escapeRegex(term), "i");
                    return $.grep(array, function (value) {
                        return matcher.test(value.label || value.value || value);
                    });
                };

                HK.AutoCompleterStatic().autocomplete(
                        autoElem,
                        HK.autoCompleterUrls.allSpecialities,
                        onBrandFilter,
                        onBrandAutoCompleteSuccess,
                        onBrandAutoCompleteSelect,
                        autoMinLen
                );
            });
        </script>
    </s:layout-component>
</s:layout-render>