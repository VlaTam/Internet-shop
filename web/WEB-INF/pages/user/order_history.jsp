<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<common:layout title="Order history">
    <c:if test="${orderList.size() == 0}">
        <section class="d-flex justify-content-center mt-5 mb-2">
            <div>
                <div>
                    <h3>You don't have orders</h3>
                </div>
            </div>
        </section>
    </c:if>
    <c:if test="${orderList.size() > 0}">
        <section class="d-flex justify-content-center mt-5 mb-2">
            <div>
                <div>
                    <h3>Your orders</h3>
                </div>
            </div>
        </section>
        <c:forEach var="order" items="${orderList}">
            <section class="container mb-3">
                <div class="row">
                    <div>
                        <div>
                            <span><b>Date:</b> <fmt:formatDate value="${order.date}" pattern="dd-MM-yyyy" /></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div>
                        <div>
                            <span><b>Payment:</b> ${order.payment.method}</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div>
                        <div>
                            <span><b>Delivery:</b> ${order.delivery.method}</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div>
                        <div>
                            <span><b>Total price:</b> ${order.totalPrice} RUB</span>
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
                        <div class="col-md-4">
                            <div>
                                <span>${productOrder.quantityOfProduct} X ${productOrder.fixProductPrice} = ${productOrder.quantityOfProduct*productOrder.fixProductPrice} RUB</span>
                            </div>
                        </div>
                    <%--    <div class="col-md-3">
                            <div>
                                ${productOrder.fixProductPrice}
                            </div>
                        </div>--%>
                    </div>
                </c:forEach>
            </section>
        </c:forEach>
    </c:if>
</common:layout>
