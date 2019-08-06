<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Catalog">
    <c:forEach var="product" items="${products}">
        <a href="${pageContext.servletContext.contextPath}/product/${product.id}">
            ${product.parameters.brand} ${product.name} R${product.parameters.radius} ${product.parameters.width}/${product.parameters.height}
        </a>
    </c:forEach>
</common:layout>
