<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Registration">
    <section>
        <div>
            <h2>Registration</h2>
        </div>
        <form id="registrationForm" onsubmit="createUser()">
            <div>
                <div>
                    <label for="last_name_id">Last name</label>
                    <input name="lastName" id="last_name_id" class="lastName" />
                </div>
                <div>
                    <label for="first_name_id">First name</label>
                    <input name="firstName" id="first_name_id" />
                </div>
                <div>
                    <label for="birthday_id">Birthday</label>
                    <input type="date" name="birthday" id="birthday_id" />
                </div>
                <div>
                    <label for="mail_address_id">Email</label>
                    <input name="mailAddress" id="mail_address_id" />
                </div>
                <div>
                    <label for="password_id">Password</label>
                    <input name="password" id="password_id" />
                </div>
            </div>
            <div>
                <div>
                    <label for="country_id">Country</label>
                    <input name="country" id="country_id" />
                </div>
                <div>
                    <label for="city_id">City</label>
                    <input name="city" id="city_id" />
                </div>
                <div>
                    <label for="street_id">Street</label>
                    <input name="street" id="street_id" />
                </div>
                <div>
                    <label for="postal_code_id">Postal code</label>
                    <input name="postalCode" id="postal_code_id" />
                </div>
                <div>
                    <label for="House_number_id">House number</label>
                    <input name="houseNumber" id="House_number_id" />
                </div>
                <div>
                    <label for="flat_number_id">Flat number</label>
                    <input name="flatNumber" id="flat_number_id" />
                </div>
            </div>
            <div>
                <button>Sign up</button>
            </div>
        </form>
    </section>
    <script src="${pageContext.servletContext.contextPath}/resources/registration.js"></script>
</common:layout>
