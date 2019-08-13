<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Catalog">
    <jsp:useBean id="parametersSet" class="java.util.HashSet"/>
    <sf:form action="${pageContext.servletContext.contextPath}/catalog/filtered" method="GET" modelAttribute="parameters">
        <div>
            <label for="brand_id">Brand</label>
            <sf:select path="brand" id="brand_id">
                <sf:option value="${null}">${parameters.brand}</sf:option>
                <c:forEach var="parameter" items="${parametersList}">
                    <c:if test="${parametersSet.add(parameter.brand)}">
                        <sf:option value="${parameter.brand}">${parameter.brand}</sf:option>
                    </c:if>
                </c:forEach>
            </sf:select>
        </div>
        <div>
            <label for="width_id">Width</label>
            <sf:select path="width" id="width_id">
                <sf:option value="${null}">${parameters.width}</sf:option>
                <c:forEach var="parameter" items="${parametersList}">
                    <c:if test="${parametersSet.add(parameter.width)}">
                        <sf:option value="${parameter.width}">${parameter.width}</sf:option>
                    </c:if>
                </c:forEach>
            </sf:select>
        </div>
        <div>
            <label for="height_id">Height</label>
            <sf:select path="height" id="height_id">
                <sf:option value="${null}">${parameters.height}</sf:option>
                <c:forEach var="parameter" items="${parametersList}">
                    <c:if test="${parametersSet.add(parameter.height)}">
                        <sf:option value="${parameter.height}">${parameter.height}</sf:option>
                    </c:if>
                </c:forEach>
            </sf:select>
        </div>
        <div>
            <label for="radius_id">Radius</label>
            <sf:select path="radius" id="radius_id">
                <sf:option value="${null}">${parameters.radius}</sf:option>
                <c:forEach var="parameter" items="${parametersList}">
                    <c:if test="${parametersSet.add(parameter.radius)}">
                        <sf:option value="${parameter.radius}">${parameter.radius}</sf:option>
                    </c:if>
                </c:forEach>
            </sf:select>
        </div>
        <div>
            <sf:button>Show</sf:button>
        </div>
    </sf:form>
    <c:choose>
        <c:when test="${products.size() == 0}">
            <p>Catalog is empty.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="product" items="${products}">
                <div>
                    <a href="${pageContext.servletContext.contextPath}/product/${product.id}">
                            ${product.parameters.brand} ${product.name} R${product.parameters.radius} ${product.parameters.width}/${product.parameters.height}
                    </a>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</common:layout>
