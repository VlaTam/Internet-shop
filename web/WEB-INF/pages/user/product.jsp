<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</common:layout>
