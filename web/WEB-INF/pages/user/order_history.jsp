<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Order history">
    <section class="row">
        <div>
            <div>
                <p>Your orders</p>
            </div>
        </div>
    </section>

    <c:if test="${orderList.size() == 0}">
        <section class="row">
            <div>
                <div>
                    <p>You don't have orders</p>
                </div>
            </div>
        </section>
    </c:if>
    <c:if test="${orderList.size() > 0}">
        <c:forEach var="order" items="${orderList}">
            <section class="container mb-3">
                <div class="row">
                    <div>
                        <div>
                            Date: ${order.date}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div>
                        <div>
                            Payment: ${order.payment.method}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div>
                        <div>
                            Delivery: ${order.delivery.method}
                        </div>
                    </div>
                </div>
                <c:forEach var="productOrder" items="${order.orderProducts}">
                    <div class="row mb-2">
                        <div class="col-md-6">
                            <div>
                                ${productOrder.product.parameters.brand} ${productOrder.product.name} R${productOrder.product.parameters.radius}
                                ${productOrder.product.parameters.width}/${productOrder.product.parameters.height}
                            </div>
                        </div>
                        <div class="col-md-1">
                            <div>
                                ${productOrder.quantityOfProduct}
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div>
                                ${productOrder.fixProductPrice}
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </section>
        </c:forEach>
    </c:if>
</common:layout>
