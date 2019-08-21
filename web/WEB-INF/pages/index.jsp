<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Tyres shop">
  <section class="container">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
      <div class="row">
        <nav class="nav">
          <a class="nav-link" href="${pageContext.servletContext.contextPath}/product/add">Add product</a>
          <a class="nav-link" href="${pageContext.servletContext.contextPath}/category">Edit categories</a>
        </nav>
      </div>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
      <div class="row">
          <nav class="nav">
              <a class="nav-link" href="${pageContext.servletContext.contextPath}/user">Add product</a>
          </nav>
      </div>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
      <div class="row mb-2" style="width: 200px;">
        <a class="btn btn-info" href="<c:url value="/user/login" />" role="button">Sign in</a>
      </div>
      <div class="row mb-2" style="width: 200px;">
        <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/user/registration">Registration</a>
      </div>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
      <div class="row mb-2">
        <p>Ваш логин: <sec:authentication property="principal.username" /></p>
      </div>
      <div class="row mb-2">
        <a class="btn btn-info" href="<c:url value="/user/logout" />" role="button">Sign out</a>
      </div>
    </sec:authorize>

    <div class="row mb-2">
      <a class="btn btn-secondary" href="${pageContext.servletContext.contextPath}/catalog">Open catalog</a>
    </div>
    <div class="row mb-5">
      <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/bin">Open the bin</a>
    </div>
  </section>
</common:layout>
