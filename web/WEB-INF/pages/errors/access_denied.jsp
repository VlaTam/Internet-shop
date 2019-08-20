<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<common:layout title="Access denied">
    <section class="container">
        <div class="row mt-5">
            <div class="mx-auto">
                <h4 class="text-danger">Access is denied</h4>
            </div>
        </div>
        <div class="row mt-5">
            <div class="mx-auto">
                <img src="${pageContext.servletContext.contextPath}/resources/images/lock.png" alt="You have another authority">
            </div>
        </div>
        <div class="row mt-5">
            <div class="mx-auto">
                <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/catalog">Go to catalog</a>
            </div>
        </div>
    </section>
</common:layout>
