<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Profit">
    <div class="d-flex justify-content-center mt-5">
        <h2>Profit</h2>
    </div>
    <c:choose>
        <c:when test="${profitForMonth == null}">
            <div class="d-flex justify-content-center mt-5">
                <b>Profit for week: </b>0
            </div>
            <div class="d-flex justify-content-center mt-3">
                <b>Profit for month: </b>0
            </div>
        </c:when>
        <c:otherwise>
            <div class="d-flex justify-content-center mt-5">
                <b>Profit for week:</b>${profitForWeek}
            </div>
            <div class="d-flex justify-content-center mt-3">
                <b>Profit for month:</b>${profitForMonth}
            </div>
        </c:otherwise>
    </c:choose>
</common:layout>
