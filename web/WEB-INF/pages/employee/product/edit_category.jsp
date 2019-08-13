<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Edit category">
    <sf:form action="${pageContext.servletContext.contextPath}/category/edit" method="PUT" modelAttribute="category">
        <sf:input path="id" value="${category.id}" hidden="true"/>
        <div>
            <label for = "category_name_id">New category name</label>
            <sf:input path="name" id="category_name_id"/>
        </div>
        <div>
            <sf:button>Confirm</sf:button>
        </div>
    </sf:form>
</common:layout>
