<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Top users">
    <c:choose>
        <c:when test="${topTenUsers.size() > 0}">
            <c:forEach var="product" items="${topTenUsers}">
                <div>
                    ${product.lastName} ${product.firstName} ${product.birthday} ${product.mailAddress}
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
