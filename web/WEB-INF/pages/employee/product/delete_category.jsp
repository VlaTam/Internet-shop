<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<common:layout title="Delete category">
    <p>Category is deleted</p>
    <a href="${pageContext.servletContext.contextPath}/category">Go to categories</a>
</common:layout>
