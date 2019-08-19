<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Log in">
    <div class="container" style="width: 300px;">
        <sf:form action="${pageContext.servletContext.contextPath}/j_spring_security_check" method="POST">
            <h2 class="form-signin-heading">Please sign in</h2>
            <div class="mb-3">
                <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus autocomplete="off">
            </div>
            <div class="mb-3">
                <input type="password" class="form-control" name="j_password" placeholder="Password" required autocomplete="off">
            </div>
            <div>
                <button class="btn btn-lg btn-primary btn-block">Войти</button>
            </div>
        </sf:form>
    </div>
</common:layout>
