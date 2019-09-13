<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Registration">
    <div class="d-flex justify-content-center mt-5 mb-2">
        <div>
            <h2>Registration</h2>
        </div>
    </div>
        <form:form action="${pageContext.servletContext.contextPath}/user/registration" modelAttribute="user" method="POST">
            <div class="d-flex justify-content-center mt-2 mb-2">
                <form:errors path="*" cssClass="error text-danger"/>
            </div>
            <section class="container">
            <div class="form-row mb-3">
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="last_name_id">Last name</label>
                        <form:input path="lastName" maxlength="30" id="last_name_id" autocomplete="off" required="true" autofocus="true"/>
                        <%--<form:errors path="lastName" cssClass="error"/>--%>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="first_name_id">First name</label>
                        <form:input path="firstName" maxlength="30" id="first_name_id" autocomplete="off" required="true"/>
                        <%--<form:errors path="firstName" cssClass="error"/>--%>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="birthday_id">Birthday</label>
                        <form:input path="birthday" type="date" id="birthday_id" autocomplete="off" required="true"/>
                        <%--<form:errors path="birthday" cssClass="error"/>--%>
                    </div>
                </div>
            </div>
            <div class="form-row mb-3">
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="mail_address_id">Email</label>
                        <form:input path="mailAddress" maxlength="30" id="mail_address_id" autocomplete="off" required="true"/>
                        <%--<form:errors path="mailAddress" cssClass="error"/>--%>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="password_id">Password</label>
                        <form:input path="password" maxlength="30" type="password" id="password_id" autocomplete="off" required="true"/>
                        <%--<form:errors path="password" cssClass="error"/>--%>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="confirmation_id">Confirm password</label>
                        <form:input path="confirmation" maxlength="30" type="password" id="confirmation_id" autocomplete="off" required="true"/>
                            <%--<form:errors path="password" cssClass="error"/>--%>
                    </div>
                </div>
            </div>

            <fieldset class="form-group">
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <h2>Your address</h2>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="country_id">Country</label>
                            <form:input path="address.country" maxlength="30" id="country_id" autocomplete="off" required="true" />
                            <%--<form:errors path="address.country" cssClass="error"/>--%>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="city_id">City</label>
                            <form:input path="address.city" maxlength="30" id="city_id" autocomplete="off" required="true"/>
                            <%--<form:errors path="address.city" cssClass="error"/>--%>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="street_id">Street</label>
                            <form:input path="address.street" maxlength="30" id="street_id" autocomplete="off" required="true"/>
                            <%--<form:errors path="address.street" cssClass="error"/>--%>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="postal_code_id">Postal code</label>
                            <form:input path="address.postalCode" maxlength="6" id="postal_code_id" autocomplete="off" required="true"/>
                            <%--<form:errors path="address.postalCode" cssClass="error"/>--%>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="house_number_id">House number</label>
                            <form:input path="address.houseNumber" maxlength="3" id="house_number_id" autocomplete="off" required="true"/>
                            <%--<form:errors path="address.houseNumber" cssClass="error"/>--%>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="flat_number_id">Flat number</label>
                            <form:input path="address.flatNumber" maxlength="4" id="flat_number_id" autocomplete="off" required="true" />
                            <%--<form:errors path="address.flatNumber" cssClass="error"/>--%>
                        </div>
                    </div>
                </div>
            </fieldset>
        </section>
        <div class="d-flex justify-content-center mt-3">
            <div>
                <form:button class="btn btn-success">Register</form:button>
            </div>
        </div>
        </form:form>
</common:layout>
