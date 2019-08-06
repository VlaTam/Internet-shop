<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<common:layout title="Add product">
    <form id="addProductForm" onsubmit="addProduct()">
        <div>
            <label for="nameId">Name of product</label>
            <input name="name" id="nameId" required="true"/>
        </div>
        <div>
            <label for="priceId">Name of product</label>
            <input name="price" id="priceId" required="true"/>
        </div>
        <div>
            <button>Add product</button>
        </div>
    </form>
    <script src="<c:url value="/resources/add_product.js"/>"></script>
</common:layout>













<%--<common:layout title="Add product">
    <form:form action="${pageContext.servletContext.contextPath}/product/add" method="POST" modelAttribute="product">
        <div>
            <label for="product_name">Name</label>
            <form:input path="name" id="product_name" autofocus="true" required="true"/>
        </div>
        <div>
            <label for="product_price">Price</label>
            <form:input path="price" id="product_price" required="true"/>
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
            <form:input path="weight" id="product_weight" required="true"/>
        </div>
        <div>
            <label for="product_volume">Volume</label>
            <form:input path="volume" id="product_volume" required="true"/>
        </div>
        <div>
            <label for="product_quantityInStock">Quantity in stock</label>
            <form:input path="quantityInStock" id="product_quantityInStock" required="true"/>
        </div>
        <button>Save</button>
    </form:form>
</common:layout>--%>
