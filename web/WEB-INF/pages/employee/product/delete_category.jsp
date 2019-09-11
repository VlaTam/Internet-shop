<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Delete category">
    <section>
        <div class="d-flex justify-content-center mt-5">
            <p>Category will be deleted. Are you sure?</p>
        </div>
        <sf:form action="${pageContext.servletContext.contextPath}/category/delete" method="DELETE" modelAttribute="category">
            <sf:input path="id" value="${category.id}" hidden="true"/>
            <sf:input path="name" value="${category.name}" hidden="true"/>
            <div class="d-flex justify-content-center mt-5">
                <sf:button class="btn btn-danger">Delete</sf:button>
            </div>
        </sf:form>
        <div>
            <a href="${pageContext.servletContext.contextPath}/category">Go to categories</a>
        </div>
    </section>
</common:layout>
