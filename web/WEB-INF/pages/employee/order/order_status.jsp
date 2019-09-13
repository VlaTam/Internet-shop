<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<common:layout title="Order status">
    <jsp:useBean id="namesSet" class="java.util.HashSet"/>
    <sf:form action="${pageContext.servletContext.contextPath}/order/edit" methodParam="_method" method="POST" modelAttribute="order">
        <sf:input path="id" value="${order.id}" hidden="true"/>
        <div class="row mt-5 mb-3 justify-content-md-around align-items-end">
            <div class="">
                <label for="payment_status_id">Payment status</label>
                <sf:select class="form-control" path="payment.paymentStatus" id="payment_status_id">
                    <c:if test="${namesSet.add(order.payment.paymentStatus)}">
                        <sf:option value="${order.payment.paymentStatus}">${order.payment.paymentStatus}</sf:option>
                    </c:if>
                    <c:forEach var="payment" items="${paymentList}">
                        <c:if test="${namesSet.add(payment.paymentStatus)}">
                            <sf:option value="${payment.paymentStatus}">${payment.paymentStatus}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <label for="payment_method_id">Payment method</label>
                <sf:select class="form-control" path="payment.method" id="payment_method_id">
                    <c:if test="${namesSet.add(order.payment.method)}">
                        <sf:option value="${order.payment.method}">${order.payment.method}</sf:option>
                    </c:if>
                    <c:forEach var="payment" items="${paymentList}">
                        <c:if test="${namesSet.add(payment.method)}">
                            <sf:option value="${payment.method}">${payment.method}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <label for="delivery_status_id">Delivery status</label>
                <sf:select class="form-control" path="delivery.deliveryStatus" id="delivery_status_id">
                    <c:if test="${namesSet.add(order.delivery.deliveryStatus)}">
                        <sf:option value="${order.delivery.deliveryStatus}">${order.delivery.deliveryStatus}</sf:option>
                    </c:if>
                    <c:forEach var="delivery" items="${deliveryList}">
                        <c:if test="${namesSet.add(delivery.deliveryStatus)}">
                            <sf:option value="${delivery.deliveryStatus}">${delivery.deliveryStatus}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <label for="delivery_method_id">Delivery method</label>
                <sf:select class="form-control" path="delivery.method" id="delivery_method_id">
                    <c:if test="${namesSet.add(order.delivery.method)}">
                        <sf:option value="${order.delivery.method}">${order.delivery.method}</sf:option>
                    </c:if>
                    <c:forEach var="delivery" items="${deliveryList}">
                        <c:if test="${namesSet.add(delivery.method)}">
                            <sf:option value="${delivery.method}">${delivery.method}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="">
                <sf:button class="btn btn-info">Change status</sf:button>
            </div>
        </div>
    </sf:form>

    <div class="d-flex justify-content-center">
        <h4 class="mt-3 text-danger">${param.message}</h4>
    </div>
    <section class="container">
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Last name:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.user.lastName}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>First name:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.user.firstName}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Email:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.user.mailAddress}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Date:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    <fmt:formatDate value="${order.date}" pattern="dd-MM-yyyy" />
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Total price:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.totalPrice}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Comments:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.comments}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Payment status:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.payment.paymentStatus}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Payment method:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.payment.method}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Delivery status:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.delivery.deliveryStatus}
                </div>
            </div>
        </div>
        <div class="row mb-1">
            <div class="col-lg-3">
                <div>
                    <b>Delivery method:</b>
                </div>
            </div>
            <div class="col-lg-9">
                <div>
                    ${order.delivery.method}
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-center mt-3 mb-3">
            <a href="${pageContext.servletContext.contextPath}/order/manage" class="btn btn-info">Go back to orders</a>
        </div>
    </section>
</common:layout>
