<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Add product">
    <sf:form action="${pageContext.servletContext.contextPath}/product/add" method="POST" modelAttribute="product">
        <section>
            <div>
                <label for="product_name">Name</label>
                <sf:input path="name" id="product_name" autofocus="true" required="true"/>
            </div>
            <div>
                <label for="product_price">Price</label>
                <sf:input path="price" id="product_price" required="true"/>
            </div>
            <div>
                <label for="product_category">Category</label>
                <sf:select path="category.id" id="product_category">
                    <c:forEach var="currentCategory" items="${categories}">
                        <sf:option value="${currentCategory.id}">${currentCategory.name}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
            <div>
                <label for="product_weight">Weight</label>
                <sf:input path="weight" id="product_weight" required="true"/>
            </div>
            <div>
                <label for="product_volume">Volume</label>
                <sf:input path="volume" id="product_volume" required="true"/>
            </div>
            <div>
                <label for="product_quantityInStock">Quantity in stock</label>
                <sf:input path="quantityInStock" id="product_quantityInStock" required="true"/>
            </div>
        </section>

        <section>
            <div>
                <h2>Parameters</h2>
            </div>
            <div>
                <label for="brand">Brand</label>
                <sf:input path="parameters.brand" id="brand" required="true"/>
            </div>
            <div>
                <label for="width">Width</label>
                <sf:input path="parameters.width" id="width" required="true"/>
            </div>
            <div>
                <label for="height">Height</label>
                <sf:input path="parameters.height" id="height" required="true"/>
            </div>
            <div>
                <label for="radius">Radius</label>
                <sf:input path="parameters.radius" id="radius" required="true"/>
            </div>
        </section>
        <div>
            <sf:button>Save product</sf:button>
        </div>
    </sf:form>
</common:layout>
