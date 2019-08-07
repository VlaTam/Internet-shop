<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<common:layout title="Tyres shop">
  <div>
    <div>
      <div>
        <h1>Orders control</h1>
      </div>
      <div>
        <a href="${pageContext.servletContext.contextPath}/employee/orders">Orders</a> <%--View of all orders--%>
      </div>
    </div>

    <div>
      <div>
        <h1>Statistic</h1>
      </div>
      <div>
        <a href="${pageContext.servletContext.contextPath}/employee/statistic">Statistic</a>
      </div>
    </div>

    <div>
      <div>
        <h1>Product control</h1>
      </div>
      <div>
        <a href="${pageContext.servletContext.contextPath}/product/add">Add product</a>
      </div>
      <div>
        <a href="${pageContext.servletContext.contextPath}/parameters">Add parameters of product</a>
      </div>
      <div>
        <a href="${pageContext.servletContext.contextPath}/category">Category control</a>
      </div>
    </div>

    <div>
      <h1>Add user</h1>
      <a href="${pageContext.servletContext.contextPath}/authorization">Authorize</a>
    </div>
    <div>
      <h1>Add address</h1>
      <a href="${pageContext.servletContext.contextPath}/address/add">Add address</a>
    </div>
    <div>
      <h1>Registration</h1>
      <a href="${pageContext.servletContext.contextPath}/registration">Registration</a>
    </div>
  </div>
</common:layout>
