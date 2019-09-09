<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Tyres shop">
    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
        <div class="row mt-5 justify-content-md-center align-items-center">
            <div class="">
              <p>Welcome, ${user.firstName}</p>
            </div>
        </div>
        <div class="row mt-2 justify-content-md-center align-items-center">
            <div class="w-25">
                <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/order/history">Your orders</a>
            </div>
        </div>
        <div class="row mt-2 justify-content-md-center align-items-center">
            <div class="w-25">
              <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/user">Edit profile</a>
            </div>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="row mt-5 justify-content-md-center align-items-center">
            <div class="">
                <p>Hello, admin</p>
            </div>
        </div>
        <div class="row mt-4 justify-content-md-center align-items-center">
            <div class="w-25">
                <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/product/add">Add product</a>
            </div>
        </div>
        <div class="row mt-4 justify-content-md-center align-items-center">
            <div class="w-25">
                <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/order/manage">Order management</a>
            </div>
        </div>
        <div class="row mt-4 justify-content-md-center align-items-center">
            <div class="w-25">
                <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/category">Edit categories</a>
            </div>
        </div>
        <div class="row mt-4 justify-content-md-center align-items-center">
            <div class="w-25">
                <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/statistics/products">Top ten products</a>
            </div>
        </div>
        <div class="row mt-4 justify-content-md-center align-items-center">
            <div class="w-25">
                <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/statistics/users">Top ten customers</a>
            </div>
        </div>
        <div class="row mt-4 justify-content-md-center align-items-center">
            <div class="w-25">
                <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/statistics/profit">Profit</a>
            </div>
        </div>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
      <div class="row mt-5 justify-content-md-center align-items-center">
        <div class="">
          <p>Welcome, guest</p>
        </div>
      </div>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
      <div class="row mt-2 justify-content-md-center align-items-center">
        <div class="w-25">
          <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/user/login">Sign in</a>
        </div>
      </div>
      <div class="row mt-4 justify-content-md-center align-items-center">
        <div class="w-25">
          <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/user/registration">Registration</a>
        </div>
      </div>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
      <div class="row mt-4 justify-content-md-center align-items-center">
        <div class="w-25">
          <a class="btn btn-secondary btn-lg btn-block" href="${pageContext.servletContext.contextPath}/user/logout">Sign out</a>
        </div>
      </div>
    </sec:authorize>

    <div>
        <a href="${pageContext.servletContext.contextPath}/message">Send message</a>
    </div>
</common:layout>
