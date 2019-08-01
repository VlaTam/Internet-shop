<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <%--<div>
        <a href="${pageContext.servletContext.contextPath}/category">Category</a>
        <a href="${pageContext.servletContext.contextPath}/parameters">Parameters</a>
        &lt;%&ndash;<a href="${pageContext.servletContext.contextPath}/product/add">Add product</a>&ndash;%&gt;
        <a href="${pageContext.servletContext.contextPath}/catalog">Catalog</a>
    </div>--%>

  </div>
</common:layout>
