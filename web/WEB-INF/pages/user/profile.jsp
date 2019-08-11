<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
                <sf:form action="${pageContext.servletContext.contextPath}/user" method="post" modelAttribute="user">
                    <div>
                        <div>
                            <label for="last_name_id">Last name</label>
                            <sf:input path="lastName" id="last_name_id" class="lastName" />
                        </div>
                        <div>
                            <label for="first_name_id">First name</label>
                            <sf:input path="firstName" id="first_name_id" />
                        </div>
                        <div>
                            <label for="birthday_id">Birthday</label>
                            <sf:input path="birthday" type="date" id="birthday_id" />
                        </div>
                        <div>
                            <label for="mail_address_id">Email</label>
                            <sf:input path="mailAddress" id="mail_address_id" />
                        </div>
                        <div>
                            <label for="password_id">Password</label>
                            <sf:input path="password" id="password_id" />
                        </div>
                    </div>
                    <div>
                        <div>
                            <label for="country_id">Country</label>
                            <sf:input path="address.country" id="country_id" />
                        </div>
                        <div>
                            <label for="city_id">City</label>
                            <sf:input path="address.city" id="city_id" />
                        </div>
                        <div>
                            <label for="street_id">Street</label>
                            <sf:input path="address.street" id="street_id" />
                        </div>
                        <div>
                            <label for="postal_code_id">Postal code</label>
                            <sf:input path="address.postalCode" id="postal_code_id" />
                        </div>
                        <div>
                            <label for="House_number_id">House number</label>
                            <sf:input path="address.houseNumber" id="House_number_id" />
                        </div>
                        <div>
                            <label for="flat_number_id">Flat number</label>
                            <sf:input path="address.flatNumber" id="flat_number_id" />
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