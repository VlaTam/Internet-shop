<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="authorization">
    <div>
        <div>
            <div>
                <h1>Authorization</h1>
            </div>
            <form:form action="${pageContext.servletContext.contextPath}/user/authorization" modelAttribute="user">
                <div>
                    <label for="mail_address_id">Mail address</label>
                    <form:input path="mailAddress" id="mail_address_id" required="true"/>
                </div>
                <div>
                    <label for="password_id">Password</label>
                    <form:input path="password" id="password_id" required="true"/>
                </div>
                <div>
                    <button>Confirm</button>
                </div>
            </form:form>
        </div>
    </div>
</common:layout>
