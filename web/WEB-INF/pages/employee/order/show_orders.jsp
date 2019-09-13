<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<common:layout title="Orders">
    <jsp:useBean id="namesSet" class="java.util.HashSet"/>
    <sf:form action="${pageContext.servletContext.contextPath}/order/filtered" method="GET" modelAttribute="orderStatus">
        <div class="row mt-5 mb-5 justify-content-md-around align-items-end">
            <div class="">
                <label for="payment_status_id">Payment status</label>
                <sf:select class="form-control btn btn-secondary dropdown-toggle" path="payment.paymentStatus" id="payment_status_id">
                    <sf:option value="${null}">-</sf:option>
                    <c:forEach var="payment" items="${paymentList}">
                        <c:if test="${namesSet.add(payment.paymentStatus)}">
                            <sf:option value="${payment.paymentStatus}">${payment.paymentStatus}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <label for="payment_method_id">Payment method</label>
                <sf:select class="form-control btn btn-secondary dropdown-toggle" path="payment.method" id="payment_method_id">
                    <sf:option value="${null}">-</sf:option>
                    <c:forEach var="payment" items="${paymentList}">
                        <c:if test="${namesSet.add(payment.method)}">
                            <sf:option value="${payment.method}">${payment.method}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <label for="delivery_status_id">Delivery status</label>
                <sf:select class="form-control btn btn-secondary dropdown-toggle" path="delivery.deliveryStatus" id="delivery_status_id">
                    <sf:option value="${null}">-</sf:option>
                    <c:forEach var="delivery" items="${deliveryList}">
                        <c:if test="${namesSet.add(delivery.deliveryStatus)}">
                            <sf:option value="${delivery.deliveryStatus}">${delivery.deliveryStatus}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <label for="delivery_method_id">Delivery method</label>
                <sf:select class="form-control btn btn-secondary dropdown-toggle" path="delivery.method" id="delivery_method_id">
                    <sf:option value="${null}">-</sf:option>
                    <c:forEach var="delivery" items="${deliveryList}">
                        <c:if test="${namesSet.add(delivery.method)}">
                            <sf:option value="${delivery.method}">${delivery.method}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <sf:button class="btn btn-info">Show</sf:button>
            </div>
        </div>
    </sf:form>

    <section class="container">
        <c:choose>
            <c:when test="${activeOrders.size() == 0}">
                <p>There are not orders.</p>
            </c:when>
            <c:otherwise>
                <div class="row mb-3">
                    <div class="col">First name</div>
                    <div class="col">Last name</div>
                    <div class="col">Date</div>
                    <div class="col">Payment status</div>
                    <div class="col">Payment method</div>
                    <div class="col">Delivery status</div>
                    <div class="col">Delivery method</div>
                    <div class="col"></div>
                </div>
                <c:forEach var="order" items="${activeOrders}">
                    <div class="row mb-1">
                        <div class="col">
                            ${order.user.firstName}
                        </div>
                        <div class="col">
                            ${order.user.lastName}
                        </div>
                        <div class="col">
                            <fmt:formatDate value="${order.date}" pattern="dd-MM-yyyy" />
                        </div>
                        <div class="col">
                            ${order.payment.paymentStatus}
                        </div>
                        <div class="col">
                            ${order.payment.method}
                        </div>
                        <div class="col">
                            ${order.delivery.deliveryStatus}
                        </div>
                        <div class="col">
                            ${order.delivery.method}
                        </div>
                        <div class="col">
                            <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/order/edit/${order.id}">
                                Change status
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </section>
</common:layout>
