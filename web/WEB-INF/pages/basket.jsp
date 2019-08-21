<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Bin">
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
                                    <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/basket/edit">Edit</a>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div>
                                    <a class="btn btn-danger" href="${pageContext.servletContext.contextPath}/basket/delete">Delete</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>

    </section>

</common:layout>
