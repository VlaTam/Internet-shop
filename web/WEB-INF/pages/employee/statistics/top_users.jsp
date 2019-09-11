<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Top users">
    <div class="d-flex justify-content-center mt-5 mb-2">
        <h2>Top of customers</h2>
    </div>
    <c:choose>
        <c:when test="${topTenUsers.size() > 0}">
            <c:forEach var="product" items="${topTenUsers}">
                <div  class="d-flex justify-content-center mt-2">
                    <p>${product.lastName} ${product.firstName} <b>${product.mailAddress}</b></p>
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
