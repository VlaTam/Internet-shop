<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Edit category">
    <form:form action="${pageContext.servletContext.contextPath}/category/edit" method="POST" modelAttribute="category">
        <form:input path="id"/>
        <div>
            <label for = "category_name_id">New category name</label>
            <form:input path="name" id="category_name_id"/>
        </div>
        <div>
            <button>Confirm</button>
        </div>
    </form:form>
</common:layout>
