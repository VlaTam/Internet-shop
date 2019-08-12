<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<common:layout title="Category control">
    <sf:form action="${pageContext.servletContext.contextPath}/category" method="POST" modelAttribute="category">
        <div>
            <label for = "category_name_id">Название категории</label>
            <sf:input id="category_name_id" path="name" required="true" autofocus="true" autocomplete="off"/>
        </div>
        <div>
            <sf:button>Add category</sf:button>
        </div>
    </sf:form>
    <div>
        <div>
            <ul>
                <c:choose>
                    <c:when test="${categories.size() > 0}">
                        <p>Created categories:</p>
                        <c:forEach var="category" items="${categories}">
                            <li>
                                    ${category.name}
                                <a href="${pageContext.servletContext.contextPath}/category/edit/${category.id}"> Edit</a>
                                <a href="${pageContext.servletContext.contextPath}/category/delete/${category.id}"> Delete</a>
                            </li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div>
                            <p>There are not categories</p>
                        </div>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</common:layout>
