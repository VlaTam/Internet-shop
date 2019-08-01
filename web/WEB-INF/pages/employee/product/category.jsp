<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<common:layout title="Category control">
    <form:form action="${pageContext.servletContext.contextPath}/category" method="POST" modelAttribute="category">
        <div>
            <label for = "category_name_id">Название категории</label>
            <form:input id="category_name_id" type = "text" path="name"/>
        </div>
        <div>
            <button type="submit">Add category</button>
        </div>
    </form:form>
    <div>
        <div>
            <ul>
                <c:forEach var="category" items="${categories}">
                    <li>
                            ${category.name}
                        <a href="${pageContext.servletContext.contextPath}/category/edit/${category.id}"> Edit</a>
                        <a href="${pageContext.servletContext.contextPath}/category/delete/${category.id}"> Delete</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</common:layout>
