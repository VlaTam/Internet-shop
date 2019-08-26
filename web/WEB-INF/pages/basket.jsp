<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Basket">
    <section class="container border border-dark mt-3">
        <c:choose>
            <c:when test="${sessionScope.purchaseSet == null || sessionScope.purchaseSet.size() < 1}">
                <div>
                    <p>Basket is empty.</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="row justify-content-md-center mb-3">
                    <div class="col-md-6">
                        <div class="mx-auto" style="width: 200px;">
                            <b>Name</b>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="mx-auto" style="width: 200px;">
                            <b>Amount</b>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mx-auto" style="width: 200px;">
                            <b>Price</b>
                        </div>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-1"></div>
                </div>
                <c:forEach var="purchase" items="${sessionScope.purchaseSet}">
                    <div class="row mb-2">
                        <div class="col-md-6">
                            <div>
                                ${purchase.product.parameters.brand} ${purchase.product.name} R${purchase.product.parameters.radius}
                                ${purchase.product.parameters.width}/${purchase.product.parameters.height}
                            </div>
                        </div>
                        <div class="col-md-1">
                            <div>
                                ${purchase.quantity}
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div>
                                ${purchase.totalCost}
                            </div>
                        </div>
                        <div class="col-md-1">
                            <div>
                                <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/product/${purchase.product.id}">Edit</a>
                            </div>
                        </div>
                        <div class="col-md-1">
                            <sf:form action="${pageContext.servletContext.contextPath}/basket/delete" method="DELETE" modelAttribute="product">
                                <sf:input path="name" value="${purchase.product.name}" hidden="true"/>
                                <sf:input path="parameters.brand" value="${purchase.product.parameters.brand}" hidden="true"/>
                                <sf:input path="parameters.width" value="${purchase.product.parameters.width}" hidden="true"/>
                                <sf:input path="parameters.height" value="${purchase.product.parameters.height}" hidden="true"/>
                                <sf:input path="parameters.radius" value="${purchase.product.parameters.radius}" hidden="true"/>
                                <sf:input path="category.name" value="${purchase.product.category.name}" hidden="true"/>
                                <sf:input path="category.status" value="${purchase.product.category.status}" hidden="true"/>
                                <sf:button class="btn btn-danger">Delete</sf:button>
                            </sf:form>
                        </div>
                    </div>
                </c:forEach>
                <div class="row mb-2">
                    <div class="ml-3">
                        <b>Total price:</b> ${sessionScope.totalPrice}
                    </div>
                </div>
                <div class="row mb-3 mt-3">
                    <div class="mx-auto" style="width: 200px;">
                        <a href="${pageContext.servletContext.contextPath}/order/add" class="btn btn-success">Buy</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </section>
</common:layout>
