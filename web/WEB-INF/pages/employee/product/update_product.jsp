<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Update product">
    <section class="container">
        <div class="row justify-content-center">
            <div class="col-4 mb-3">
                <h2>Update product</h2>
            </div>
        </div>
        <sf:form action="${pageContext.servletContext.contextPath}/product/update" modelAttribute="product" method="POST">
            <sf:errors path="*" cssClass="error text-danger"/>
            <sf:input path="id" value="${product.id}" hidden="true"/>
            <%--<sf:input path="parameters.id" value="${product.parameters.id}" hidden="true"/>--%>
            <sf:input path="status" value="${product.status}" hidden="true"/>
            <%--<sf:input path="category.status" value="${product.category.status}" hidden="true"/>--%>
            <div class="form-row mb-3">
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="name_id">Name</label>
                        <sf:input path="name" maxlength="30" id="name_id" value="${product.name}" required="true" autofocus="true"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="quantityInStock_id">Quantity in stock</label>
                        <sf:input path="quantityInStock" type="number" min="0" max="9999999" maxlength="7" id="quantityInStock_id" value="${product.quantityInStock}" autocomplete="off" required="true"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="price_id">Price, RUB</label>
                        <sf:input path="price" type="number" min="0" max="9999999" step="0.1" maxlength="10" id="price_id" value="${product.price}" autocomplete="off" required="true"/>
                    </div>
                </div>
            </div>
            <div class="form-row mb-3">
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="brand_id">Brand</label>
                        <sf:input path="parameters.brand" maxlength="30" id="brand_id" value="${product.parameters.brand}" autocomplete="off" required="true"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="float-right">
                        <label for="weight_id">Weight</label>
                        <sf:input path="weight" type="number" min="0" max="1000" step="0.1" length="7" id="weight_id" value="${product.weight}" autocomplete="off" required="true"/>
                    </div>
                </div>
            </div>

            <fieldset class="form-group">
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="radius_id">Radius</label>
                            <sf:input path="parameters.radius" type="number" min="0" max="200" maxlength="3" id="radius_id" value="${product.parameters.radius}" autocomplete="off" required="true"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="float-right">
                            <label for="volume_id">Volume</label>
                            <sf:input path="volume" type="number" min="0" max="1000" step="0.1" maxlength="7" id="volume_id" value="${product.volume}" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="height_id">Height</label>
                            <sf:input path="parameters.height" type="number" min="0" max="1000" maxlength="3" id="height_id" value="${product.parameters.height}" autocomplete="off" required="true"/>
                        </div>
                    </div>
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="product_category">Category</label>
                            <sf:select path="category.id" id="product_category">
                                <sf:option value="${product.category.id}">${product.category.name}</sf:option>
                                <c:forEach var="currentCategory" items="${categoryList}">
                                    <sf:option value="${currentCategory.id}">${currentCategory.name}</sf:option>
                                </c:forEach>
                            </sf:select>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="mb-3 col-md-4">
                        <div class="float-right">
                            <label for="width_id">Width</label>
                            <sf:input path="parameters.width" maxlength="3"  type="number" min="0" max="1000" id="width_id" value="${product.parameters.width}" autocomplete="off" required="true"/>
                        </div>
                    </div>
                </div>
            </fieldset>
            <div class="d-flex justify-content-center">
                <sf:button class="btn btn-success">Update</sf:button>
            </div>
        </sf:form>
    </section>
</common:layout>
