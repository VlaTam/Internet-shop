<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Add address">
    <div>
        <div>
            <div>
                <h1>Add your address</h1>
            </div>
            <form:form action="${pageContext.servletContext.contextPath}/addAddress" method="POST" modelAttribute="address">
                <div>
                    <label for="country_id">Country</label>
                    <form:input path="country" id="country_id" required="true"/>
                </div>
                <div>
                    <label for="city_id">City</label>
                    <form:input path="city" id="city_id" required="true"/>
                </div>
                <div>
                    <label for="postal_code_id">Postal code</label>
                    <form:input path="postalCode" id="postal_code_id" required="true"/>
                </div>
                <div>
                    <label for="street_id">Street</label>
                    <form:input path="street" id="street_id" required="true"/>
                </div>
                <div>
                    <label for="house_number_id">House number</label>
                    <form:input path="houseNumber" id="house_number_id" required="true"/>
                </div>
                <div>
                    <label for="flat_number_id">Flat number</label>
                    <form:input path="flatNumber" id="flat_number_id" required="true"/>
                </div>
                <div>
                    <button>Confirm</button>
                </div>
            </form:form>
        </div>
    </div>
</common:layout>
