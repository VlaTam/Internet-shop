<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<common:layout title="Profile">
    <div class="row mt-5 justify-content-md-center align-items-md-center">
        <div>
            <h2>Profile</h2>
        </div>
    </div>
    <div class="row mt-2 justify-content-md-center align-items-md-center">
        <div>
            <p>Your email is <b>${user.mailAddress}</b></p>
        </div>
    </div>
    <sf:form action="${pageContext.servletContext.contextPath}/user" method="PUT" modelAttribute="user">
        <section class="row mt-2 justify-content-lg-center align-items-md-start">
            <sf:errors path="*" cssClass="error text-danger"/>
            <sf:input path="id" value="${user.id}" hidden="true"/>
            <sf:input path="mailAddress" value="${user.mailAddress}" hidden="true"/>
            <sf:input path="address.id" value="${user.address.id}" hidden="true"/>
            <sf:input path="role.id" value="${user.role.id}" hidden="true"/>
            <fieldset class="col-lg-3 mt-3">
                <div class="row justify-content-lg-center">
                    <div>
                        <label for="last_name_id">Last name</label>
                        <sf:input class="form-control" maxlength="30" path="lastName" id="last_name_id" value="${user.lastName}" required="true" autofocus="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="first_name_id">First name</label>
                        <sf:input class="form-control" maxlength="30" path="firstName" id="first_name_id" value="${user.firstName}" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <fmt:parseDate value="${user.birthday}" var="birthdayObject" pattern="yyyy-MM-dd"/>
                    <c:set value="" var="birthday"/>
                    <div>
                        <label for="birthday_id">Birthday</label>
                        <sf:input class="form-control" path="birthday" type="date" id="birthday_id" value="${birthday}" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="password_id">Password</label>
                        <sf:password class="form-control" maxlength="100" path="password" id="password_id" placeholder="Your password" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="confirmation_id">Confirm password</label>
                        <sf:password class="form-control" maxlength="100" path="confirmation" id="confirmation_id" placeholder="Confirm password" required="true"/>
                    </div>
                </div>
            </fieldset>

            <fieldset class="col-lg-3 mt-3">
                <div class="row justify-content-lg-center">
                    <div>
                        <label for="country_id">Country</label>
                        <sf:input class="form-control" maxlength="30" path="address.country" id="country_id" value="${user.address.country}" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="city_id">City</label>
                        <sf:input class="form-control" maxlength="30" path="address.city" id="city_id" value="${user.address.city}" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="street_id">Street</label>
                        <sf:input class="form-control" maxlength="30" path="address.street" id="street_id" value="${user.address.street}" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="postal_code_id">Postal code</label>
                        <sf:input class="form-control" maxlength="6" path="address.postalCode" id="postal_code_id" value="${user.address.postalCode}" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="House_number_id">House number</label>
                        <sf:input class="form-control" maxlength="4" path="address.houseNumber" id="House_number_id" value="${user.address.houseNumber}" required="true"/>
                    </div>
                </div>
                <div class="row justify-content-lg-center mt-3">
                    <div>
                        <label for="flat_number_id">Flat number</label>
                        <sf:input class="form-control" maxlength="4" path="address.flatNumber" id="flat_number_id" value="${user.address.flatNumber}" required="true"/>
                    </div>
                </div>
            </fieldset>
        </section>
        <div class="row mt-4 justify-content-lg-center">
            <sf:button class="btn btn-secondary">Update</sf:button>
        </div>
    </sf:form>
</common:layout>
