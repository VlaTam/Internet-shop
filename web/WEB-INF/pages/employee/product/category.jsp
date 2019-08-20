<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<common:layout title="Category control">
    <section class="container">
        <sf:form action="${pageContext.servletContext.contextPath}/category" method="POST" modelAttribute="category">
            <div class="form-row justify-content-md-center">
                <div class="col-md-2"></div>
                <div class="col-md-auto mb-3">
                    <h3>Add new category</h3>
                </div>
                <div class="col-md-2"></div>
            </div>

            <div class="form-row justify-content-md-center">
                <div class="col-md-2"></div>
                <div class="col-md-auto">
                    <label for = "category_name_id">Название категории</label>
                    <sf:input id="category_name_id" path="name" required="true" autofocus="true" autocomplete="off"/>
                    <div>
                        <sf:button class="btn btn-success">Add category</sf:button>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </sf:form>
        <div class="form-row justify-content-md-center mt-3">
            <div class="col-md-2"></div>
            <div class="col-md-auto mb-3">
                <ul>
                    <c:choose>
                        <c:when test="${categories.size() > 0}">
                            <h4 class="mb-3">Created categories:</h4>
                            <c:forEach var="category" items="${categories}">
                                <div class="mb-2">
                                    <li>
                                            ${category.name}
                                        <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/category/edit/${category.id}"> Edit</a>
                                        <a class="btn btn-danger" href="${pageContext.servletContext.contextPath}/category/delete/${category.id}"> Delete</a>
                                    </li>
                                </div>
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
            <div class="col-md-2"></div>
        </div>
    </section>
</common:layout>
