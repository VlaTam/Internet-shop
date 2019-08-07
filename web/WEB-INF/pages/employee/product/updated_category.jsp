<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<common:layout title="Updated category">
    <div>
        <p>Category is updated. New category name is ${category.name}</p>
    </div>
    <div>
        <a href="${pageContext.servletContext.contextPath}/category">Go to categories</a>
    </div>
</common:layout>
