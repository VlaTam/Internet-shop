<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Registration">
    <section class="container">
        <div class="row justify-content-center">
            <div class="col-4 mb-3">
                <h2>Registration</h2>
            </div>
        </div>
        <sf:form action="${pageContext.servletContext.contextPath}/user/registration" modelAttribute="user" method="POST">
            <div class="form-row mb-3">
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="last_name_id">Last name</label>
                        <sf:input path="lastName" id="last_name_id" autocomplete="off" required="true" autofocus="true"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="first_name_id">First name</label>
                        <sf:input path="firstName" id="first_name_id" autocomplete="off" required="true"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="birthday_id">Birthday</label>
                        <sf:input path="birthday" type="date" id="birthday_id" autocomplete="off" required="true"/>
                    </div>
                </div>
            </div>
            <div class="form-row mb-3">
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="mail_address_id">Email</label>
                        <sf:input path="mailAddress" id="mail_address_id" autocomplete="off" required="true"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="password_id">Password</label>
                        <sf:input path="password" id="password_id" autocomplete="off" required="true"/>
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
                            <sf:input path="address.country" id="country_id" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="city_id">City</label>
                            <sf:input path="address.city" id="city_id" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="street_id">Street</label>
                            <sf:input path="address.street" id="street_id" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="postal_code_id">Postal code</label>
                            <sf:input path="address.postalCode" id="postal_code_id" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="house_number_id">House number</label>
                            <sf:input path="address.houseNumber" id="house_number_id" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="flat_number_id">Flat number</label>
                            <sf:input path="address.flatNumber" id="flat_number_id" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
            </fieldset>
            <div class="row justify-content-center">
                <div class="col-4">
                    <sf:button class="btn btn-success">Register</sf:button>
                </div>
            </div>
        </sf:form>
    </section>
</common:layout>
