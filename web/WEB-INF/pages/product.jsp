<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Product">
    <section class="container">
        <div class="row mt-5">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b >Category:</b> ${product.category.name}
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b>Brand:</b> ${product.parameters.brand}
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b>Name:</b> ${product.name}
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b>Width:</b> ${product.parameters.width}
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b>Height:</b> ${product.parameters.height}
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b>Radius:</b> ${product.parameters.radius}
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b>Price:</b> ${product.price} RUB
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <b>In stock:</b> ${product.quantityInStock}
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form action="${pageContext.servletContext.contextPath}/basket/add" method="POST">
                    <input name="productId" value="${product.id}" hidden/>
                    <input name="quantity" type="number" min="1" max="${product.quantityInStock}"/>
                    <button>Add to the basket</button>
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
        <div>
            <p class="mt-3 text-danger">${param.message}</p>
        </div>
    </section>
</common:layout>
