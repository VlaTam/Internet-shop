<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Profit">
    <section>
        <c:choose>
            <c:when test="${profitForMonth == null}">
                <div>
                    <b>Profit for week: </b>0
                </div>
                <div>
                    <b>Profit for month: </b>0
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <b>Profit for week: </b>${profitForWeek}
                </div>
                <div>
                    <b>Profit for month: </b>${profitForMonth}
                </div>
            </c:otherwise>
        </c:choose>
    </section>
</common:layout>
