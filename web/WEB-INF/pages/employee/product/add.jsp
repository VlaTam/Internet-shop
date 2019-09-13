<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Add product">
    <div class="d-flex justify-content-center mb-3">
        <h2>New product</h2>
    </div>
    <sf:form action="${pageContext.servletContext.contextPath}/product/add" method="POST" modelAttribute="product">
        <sf:errors path="*" cssClass="error text-danger"/>
        <div class="d-flex justify-content-around mt-5 align-items-baseline">
            <section>
                <div>
                    <label for="product_name">Name</label>
                    <sf:input path="name" maxlength="30" id="product_name" autofocus="true" required="true" autocomplete="off"/>
                </div>
                <div>
                    <label for="product_price">Price</label>
                    <sf:input path="price" type="number" min="0" max="9999999" step="0.1" maxlength="10" id="product_price" required="true" autocomplete="off"/>
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
                    <sf:input path="weight" type="number" min="1" max="1000" step="0.1" maxlength="7" id="product_weight" required="true" autocomplete="off"/>
                </div>
                <div>
                    <label for="product_volume">Volume</label>
                    <sf:input path="volume" type="number" min="1" max="1000" step="0.1" maxlength="7" id="product_volume" required="true" autocomplete="off"/>
                </div>
                <div>
                    <label for="product_quantityInStock">Quantity in stock</label>
                    <sf:input path="quantityInStock" type="number" min="0" max="9999999" maxlength="7" id="product_quantityInStock" required="true" autocomplete="off"/>
                </div>
            </section>

            <section>
                <div>
                    <label for="brand">Brand</label>
                    <sf:input path="parameters.brand" maxlength="30" id="brand" required="true" autocomplete="off"/>

                </div>
                <div>
                    <label for="width">Width</label>
                    <sf:input path="parameters.width" type="number" min="0" max="1000" maxlength="3" id="width" required="true" autocomplete="off"/>

                </div>
                <div>
                    <label for="height">Height</label>
                    <sf:input path="parameters.height" type="number" min="0" max="1000" maxlength="3" id="height" required="true" autocomplete="off"/>

                </div>
                <div>
                    <label for="radius">Radius</label>
                    <sf:input path="parameters.radius" type="number" min="0" max="200" maxlength="3" id="radius" required="true" autocomplete="off"/>

                </div>
            </section>
        </div>
        <div class="d-flex justify-content-center mt-3">
            <sf:button class="btn btn-success">Save product</sf:button>
        </div>
    </sf:form>
</common:layout>
