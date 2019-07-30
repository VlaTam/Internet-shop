<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Add product">
    <form:form action="${pageContext.servletContext.contextPath}/product/add" method="POST" modelAttribute="product">
        <div>
            <label for="product_name">Name</label>
            <form:input path="name" id="product_name" autofocus="true" />
        </div>
        <div>
            <label for="product_price">Price</label>
            <form:input path="price" id="product_price"/>
        </div>
        <div>
            <label for="product_category">Category</label>
            <form:select path="category.id" id="product_category">
                <c:forEach var="currentCategory" items="${categories}">
                    <form:option value="${currentCategory.id}">${currentCategory.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div>
            <label for="product_parameters">Parameters</label>
            <c:forEach var="parameter" items="${parameters}">
                <div>
                    <form:radiobutton path="parameters.id" value="${parameter.id}" id="product_parameters"/>
                    ${parameter.brand} ${parameter.width}/${parameter.height} R${parameter.radius}
                </div>
            </c:forEach>
        </div>
        <div>
            <label for="product_weight">Weight</label>
            <form:input path="weight" id="product_weight"/>
        </div>
        <div>
            <label for="product_volume">Volume</label>
            <form:input path="volume" id="product_volume"/>
        </div>
        <div>
            <label for="product_quantityInStock">Quantity in stock</label>
            <form:input path="quantityInStock" id="product_quantityInStock"/>
        </div>
        <button>Save</button>
    </form:form>
</common:layout>
