<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<common:layout title="authorization">
    <div>
        <div>
            <div>
                <h1>Authorization</h1>
            </div>
            <form:form action="${pageContext.servletContext.contextPath}/user/authorization" method="POST" modelAttribute="user">
                <div>
                    <label for="mail_address_id">Mail address</label>
                    <form:input path="mailAddress" id="mail_address_id" required="true"/>
                </div>
                <div>
                    <label for="password_id">Password</label>
                    <form:input path="password" id="password_id" required="true"/>
                </div>
                <div>
                    <label for="last_name_id">Last name</label>
                    <form:input path="lastName" id="last_name_id" required="true"/>
                </div>
                <div>
                    <label for="first_name_id">First name</label>
                    <form:input path="firstName" id="first_name_id" required="true"/>
                </div>
                <div>
                    <label for="birthday_id">Birthday</label>
                    <form:input path="birthday" id="birthday_id" required="true"/>
                </div>
                <div>
                    <button>Confirm</button>
                </div>
            </form:form>
        </div>
    </div>
</common:layout>
