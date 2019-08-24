<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Catalog">
    <jsp:useBean id="parametersSet" class="java.util.HashSet"/>
    <sf:form action="${pageContext.servletContext.contextPath}/catalog/filtered" method="GET" modelAttribute="parameters">
        <section class="container mb-4">
            <div class="row">
                <div class="col">
                    <label for="brand_id">Brand</label>
                    <sf:select path="brand" id="brand_id">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="parameter" items="${parametersList}">
                            <c:if test="${parametersSet.add(parameter.brand)}">
                                <sf:option value="${parameter.brand}">${parameter.brand}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                    <label for="width_id">Width</label>
                    <sf:select path="width" id="width_id">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="parameter" items="${parametersList}">
                            <c:if test="${parametersSet.add(parameter.width)}">
                                <sf:option value="${parameter.width}">${parameter.width}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                    <label for="height_id">Height</label>
                    <sf:select path="height" id="height_id">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="parameter" items="${parametersList}">
                            <c:if test="${parametersSet.add(parameter.height)}">
                                <sf:option value="${parameter.height}">${parameter.height}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                    <label for="radius_id">Radius</label>
                    <sf:select path="radius" id="radius_id">
                        <sf:option value="${null}">-</sf:option>
                        <c:forEach var="parameter" items="${parametersList}">
                            <c:if test="${parametersSet.add(parameter.radius)}">
                                <sf:option value="${parameter.radius}">${parameter.radius}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="col">
                    <sf:button>Show</sf:button>
                </div>
            </div>
        </section>
    </sf:form>

    <section class="container">
        <c:choose>
            <c:when test="${orderProducts.size() == 0}">
                <p>Catalog is empty.</p>
            </c:when>
            <c:otherwise>
                <div class="row mb-3">
                    <div class="col">Brand</div>
                    <div class="col">Name</div>
                    <div class="col">Radius</div>
                    <div class="col">Width</div>
                    <div class="col">Height</div>
                    <div class="col">Buy</div>
                </div>
                <c:forEach var="product" items="${orderProducts}">
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
                            <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/product/${product.id}">Buy</a>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </section>
</common:layout>
