<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="Order">
    <div class="d-flex justify-content-center mt-3">
        <div class="container">
            <div class="row">
                <div class="justify-content-end">
                    <span><b>Your country is</b> "${user.address.country}"</span>
                </div>
            </div>
            <div class="row">
                <div>
                    <span><b>Your city is</b> "${user.address.city}"</span>
                </div>
            </div>
            <div class="row">
                <div>
                    <span><b>Your street is</b> "${user.address.street}"</span>
                </div>
            </div>
            <div class="row">
                <div>
                    <span><b>Your house number is</b> "${user.address.houseNumber}"</span>
                </div>
            </div>
            <div class="row">
                <div>
                    <span><b>Your flat number is</b> "${user.address.flatNumber}"</span>
                </div>
            </div>
        </div>
    </div>


    <sf:form action="${pageContext.servletContext.contextPath}/order/add" method="POST" modelAttribute="order">
        <section  class="d-flex justify-content-around mt-5">
        <div>
            <div>
                <label for="payment">Payment</label>
                <sf:select path="payment.id" id="payment" class="btn btn-secondary dropdown-toggle">
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
                <sf:select path="delivery.id" id="delivery" class="btn btn-secondary dropdown-toggle">
                    <c:forEach var="currentDelivery" items="${deliveryList}">
                        <c:if test="${currentDelivery.deliveryStatus == 'awaiting shipment'}">
                            <sf:option value="${currentDelivery.id}">${currentDelivery.method}</sf:option>
                        </c:if>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div>
            <div>
                <label for="comments">Your comments</label>
                <sf:textarea path="comments" id="comments" cols="50" rows="3" class="form-control"/>
            </div>
        </div>
        </section>
        <div class="d-flex justify-content-center mt-3">
            <sf:button class="btn btn-success">Confirm</sf:button>
        </div>

    </sf:form>

</common:layout>
