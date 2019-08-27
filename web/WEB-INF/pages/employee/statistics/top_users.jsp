<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Top users">
    <c:choose>
        <c:when test="${topTenUsers.size() > 0}">
            <c:forEach var="user" items="${topTenUsers}">
                <div>
                    ${user.lastName} ${user.firstName} ${user.birthday} ${user.mailAddress}
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
