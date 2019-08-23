<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Order">
    <section class="row">
        <div>
            <div>
                <label for="country">Your country</label>
                <input value="${user.address.country}" id="country" disabled>
            </div>
        </div>
        <div>
            <div>
                <label for="city">Your city</label>
                <input value="${user.address.city}" id="city" disabled>
            </div>
        </div>
        <div>
            <div>
                <label for="street">Your street</label>
                <input value="${user.address.street}" id="street" disabled>
            </div>
        </div>
        <div>
            <div>
                <label for="house">Your house number</label>
                <input value="${user.address.houseNumber}" id="house" disabled>
            </div>
        </div>
        <div>
            <div>
                <label for="flat">Your flat number</label>
                <input value="${user.address.country}" id="flat" disabled>
            </div>
        </div>
    </section>
    <sf:form action="${pageContext.servletContext.contextPath}/order/add" method="POST" modelAttribute="order">
        <section class="row">
            <div>
                <div>
                    <label for="payment">Payment</label>
                    <sf:select path="payment.id" id="payment">
                        <c:forEach var="currentPayment" items="${paymentList}">
                            <c:if test="${currentPayment.paymentStatus == 'not paid'}">
                                <sf:option value="${currentPayment.id}">${currentPayment.method}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>
            <div>
                <div>
                    <label for="delivery">Delivery</label>
                    <sf:select path="delivery.id" id="delivery">
                        <c:forEach var="currentDelivery" items="${deliveryList}">
                            <c:if test="${currentDelivery.deliveryStatus == 'not delivered'}">
                                <sf:option value="${currentDelivery.id}">${currentDelivery.method}</sf:option>
                            </c:if>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>
        </section>
        <div>
            <sf:button>Confirm</sf:button>
        </div>
    </sf:form>
</common:layout>
