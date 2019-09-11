<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Top products">
    <c:choose>
        <c:when test="${topTenProducts.size() > 0}">
            <c:forEach var="product" items="${topTenProducts}">
                <div>
                    ${product.parameters.brand} ${product.name} ${product.parameters.width}/${product.parameters.height} R${product.parameters.radius}
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div>
                No statistics
            </div>
        </c:otherwise>
    </c:choose>
</common:layout>
