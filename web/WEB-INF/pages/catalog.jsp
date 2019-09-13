<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<common:layout title="Catalog">
    <jsp:useBean id="parametersSet" class="java.util.HashSet"/>
    <sf:form action="${pageContext.servletContext.contextPath}/catalog/filtered" method="GET" modelAttribute="parameters">
        <section class="container mb-4">
            <div class="row">
                <div class="col">
                    <label for="brand_id">Brand</label>
                    <sf:select path="brand" id="brand_id" class="btn btn-secondary dropdown-toggle">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="product" items="${productList}">
                            <c:if test="${parametersSet.add(product.parameters.brand)}">
                                <sf:option value="${product.parameters.brand}">${product.parameters.brand}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                    <label for="width_id">Width</label>
                    <sf:select path="width" id="width_id" class="btn btn-secondary dropdown-toggle">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="product" items="${productList}">
                            <c:if test="${parametersSet.add(product.parameters.width)}">
                                <sf:option value="${product.parameters.width}">${product.parameters.width}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                        ${parametersSet.clear()}
                    <label for="height_id">Height</label>
                    <sf:select path="height" id="height_id" class="btn btn-secondary dropdown-toggle">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="product" items="${productList}">
                            <c:if test="${parametersSet.add(product.parameters.height)}">
                                <sf:option value="${product.parameters.height}">${product.parameters.height}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                    <label for="radius_id">Radius</label>
                        ${parametersSet.clear()}
                    <sf:select path="radius" id="radius_id" class="btn btn-secondary dropdown-toggle">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="product" items="${productList}">
                            <c:if test="${parametersSet.add(product.parameters.radius)}">
                                <sf:option value="${product.parameters.radius}">${product.parameters.radius}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                    <sf:button class="btn btn-info">Show</sf:button>
                </div>
            </div>
        </section>
    </sf:form>

    <section class="container">
        <c:choose>
            <c:when test="${products.size() == 0}">
                <p>Catalog is empty.</p>
            </c:when>
            <c:otherwise>
                <div class="row mb-3">
                    <div class="col">Brand</div>
                    <div class="col">Name</div>
                    <div class="col">Radius</div>
                    <div class="col">Width</div>
                    <div class="col">Height</div>
                    <div class="col">Price, RUB</div>
                    <div class="col"></div>
                </div>
                <c:forEach var="product" items="${products}">
                    <div class="row mb-1">
                        <div class="col">
                            ${product.parameters.brand}
                        </div>
                        <div class="col">
                            ${product.name}
                        </div>
                        <div class="col">
                            ${product.parameters.radius}
                        </div>
                        <div class="col">
                            ${product.parameters.width}
                        </div>
                        <div class="col">
                            ${product.parameters.height}
                        </div>
                        <div class="col">
                            ${product.price}
                        </div>
                        <div class="col">
                            <div class="d-flex justify-content-between">
                                <sec:authorize access="!hasRole('ROLE_ADMIN')">
                                    <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/product/${product.id}">Buy</a>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/product/update/${product.id}">Update</a>
                                    <a class="btn btn-danger" href="${pageContext.servletContext.contextPath}/product/delete/${product.id}">Delete</a>
                                </sec:authorize>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </section>
</common:layout>
