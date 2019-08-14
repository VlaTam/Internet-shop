<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Product">
    <div>
        Category: ${product.category.name}
    </div>
    <div>
        Brand: ${product.parameters.brand}
    </div>
    <div>
        Name: ${product.name}
    </div>
    <div>
        Width: ${product.parameters.width}
    </div>
    <div>
        Height: ${product.parameters.height}
    </div>
    <div>
        Radius: ${product.parameters.radius}
    </div>
    <div>
        Price: ${product.price} RUB
    </div>
    <div>
        In stock: ${product.quantityInStock}
    </div>
    <div>
        <form action="${pageContext.servletContext.contextPath}/bin/add">
            <input name="product" value="${product.id}" hidden/>
            <input name="quantity" type="number" min="1" max="${product.quantityInStock}"/>
            <button>Add to bin</button>
        </form>
    </div>
</common:layout>
