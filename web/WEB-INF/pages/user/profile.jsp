<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<common:layout title="Profile">
    <c:choose>
        <c:when test="${user == null}">
            <p>Such user is not found.</p>
        </c:when>
        <c:otherwise>
            <section>
                <div>
                    <h2>Profile</h2>
                </div>
                <div>
                    <p>Your email is <b>${user.mailAddress}</b></p>
                </div>
                <sf:form action="${pageContext.servletContext.contextPath}/user" method="PUT" modelAttribute="user">
                    <sf:input path="id" value="${user.id}" hidden="true"/>
                    <sf:input path="mailAddress" value="${user.mailAddress}" hidden="true"/>
                    <sf:input path="address.id" value="${user.address.id}" hidden="true"/>
                    <sf:input path="role.id" value="${user.role.id}" hidden="true"/>
                    <div>
                        <div>
                            <label for="last_name_id">Last name</label>
                            <sf:input path="lastName" id="last_name_id" class="lastName" value="${user.lastName}" required="true" autofocus="true"/>
                        </div>
                        <div>
                            <label for="first_name_id">First name</label>
                            <sf:input path="firstName" id="first_name_id" value="${user.firstName}" required="true"/>
                        </div>
                        <div>
                            <fmt:parseDate value="${user.birthday}" var="birthdayObject" pattern="yyyy-MM-dd"/>
                            <c:set value="" var="birthday"/>
                            <label for="birthday_id">Birthday</label>
                            <sf:input path="birthday" type="date" id="birthday_id" value="${birthday}" required="true"/>
                        </div>
                        <div>
                            <label for="password_id">Password</label>
                            <sf:password path="password" id="password_id" value="${user.password}" required="true"/>
                        </div>
                        <div>
                            <label for="confirmation_id">Confirm password</label>
                            <sf:password path="confirmation" id="confirmation_id" value="${user.password}" required="true"/>
                        </div>
                    </div>
                    <div>
                        <div>
                            <label for="country_id">Country</label>
                            <sf:input path="address.country" id="country_id" value="${user.address.country}" required="true"/>
                        </div>
                        <div>
                            <label for="city_id">City</label>
                            <sf:input path="address.city" id="city_id" value="${user.address.city}" required="true"/>
                        </div>
                        <div>
                            <label for="street_id">Street</label>
                            <sf:input path="address.street" id="street_id" value="${user.address.street}" required="true"/>
                        </div>
                        <div>
                            <label for="postal_code_id">Postal code</label>
                            <sf:input path="address.postalCode" id="postal_code_id" value="${user.address.postalCode}" required="true"/>
                        </div>
                        <div>
                            <label for="House_number_id">House number</label>
                            <sf:input path="address.houseNumber" id="House_number_id" value="${user.address.houseNumber}" required="true"/>
                        </div>
                        <div>
                            <label for="flat_number_id">Flat number</label>
                            <sf:input path="address.flatNumber" id="flat_number_id" value="${user.address.flatNumber}" required="true"/>
                        </div>
                    </div>
                    <div>
                        <sf:button>Sign up</sf:button>
                    </div>
                </sf:form>
            </section>
        </c:otherwise>
    </c:choose>
</common:layout>
