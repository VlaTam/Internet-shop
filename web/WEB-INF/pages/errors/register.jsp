<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<common:layout title="Error">
    <div>
        <p>User with such email has been already registered.</p>
        <p>Try
            <a href="${pageContext.servletContext.contextPath}/user/registration">register</a>
            again.
        </p>
    </div>
</common:layout>

