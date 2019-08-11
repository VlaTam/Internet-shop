<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<common:layout title="Error">
    <div>
        <p>Product is not added.</p>
        <p>Try
            <a href="${pageContext.servletContext.contextPath}/product/add">add product</a>
            again.
        </p>
    </div>
</common:layout>
