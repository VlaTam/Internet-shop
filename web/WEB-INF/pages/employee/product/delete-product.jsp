<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Delete product">
    <div class="d-flex justify-content-center mt-5">
        <h3>Do you want delete the product?</h3>
    </div>
    <sf:form action="${pageContext.servletContext.contextPath}/product/delete" method="DELETE" modelAttribute="product">
        <sf:input path="id" value="${product.id}" hidden="true"/>
        <sf:input path="weight" value="${product.weight}" hidden="true"/>
        <sf:input path="volume" value="${product.volume}" hidden="true"/>
        <sf:input path="price" value="${product.price}" hidden="true"/>
        <sf:input path="name" value="${product.name}" hidden="true"/>
        <sf:input path="quantityInStock" value="${product.quantityInStock}" hidden="true"/>
        <sf:input path="category.name" value="${product.category.name}" hidden="true"/>
        <sf:input path="category.status" value="${product.category.status}" hidden="true"/>
        <sf:input path="category.id" value="${product.category.id}" hidden="true"/>
        <sf:input path="parameters.id" value="${product.parameters.id}" hidden="true"/>
        <sf:input path="parameters.brand" value="${product.parameters.brand}" hidden="true"/>
        <sf:input path="parameters.radius" value="${product.parameters.radius}" hidden="true"/>
        <sf:input path="parameters.width" value="${product.parameters.width}" hidden="true"/>
        <sf:input path="parameters.height" value="${product.parameters.height}" hidden="true"/>
        <div class="d-flex justify-content-center mt-5">
            <sf:button class="btn btn-danger">Delete</sf:button>
        </div>
    </sf:form>
</common:layout>
