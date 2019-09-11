<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Top products">
    <div class="d-flex justify-content-center mt-5">
        <h2>Top of products</h2>
    </div>
    <c:choose>
        <c:when test="${topTenProducts.size() > 0}">
            <c:forEach var="product" items="${topTenProducts}">
                <div class="d-flex justify-content-center mt-3">
                    ${product.parameters.brand} ${product.name} ${product.parameters.width}/${product.parameters.height} R${product.parameters.radius}
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="d-flex justify-content-center mt-3">
                No statistics
            </div>
        </c:otherwise>
    </c:choose>
</common:layout>
