<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Bin">
    <c:forEach var="purchase" items="${sessionScope.bin.purchaseList}">
        <div>
            <p>${purchase.product.name}</p>
        </div>
    </c:forEach>
</common:layout>
