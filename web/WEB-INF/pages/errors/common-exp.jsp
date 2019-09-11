<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<common:layout title="Somthing wrong">
    <div class="d-flex justify-content-center mt-5">
        <h2>Something wrong...</h2>
    </div>
    <div class="d-flex justify-content-center mt-5">
        <img src="${pageContext.servletContext.contextPath}/resources/images/icon-error.png">
    </div>
    <div class="d-flex justify-content-center mt-5">
        <a href="${pageContext.servletContext.contextPath}/" class="btn btn-success">Go to main page</a>
    </div>
</common:layout>

