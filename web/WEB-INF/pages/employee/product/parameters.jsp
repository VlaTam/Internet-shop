<%@ page contentType="message/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<common:layout title="Parameters of product">
    <div>
        <a href="${pageContext.servletContext.contextPath}/">home page</a>
    </div>
    <div>
        <form:form action="${pageContext.servletContext.contextPath}/parameters" method="POST" modelAttribute="parameters">
            <div>
                <label for="parameter_brand">Brand</label>
                <form:input path="brand" id="parameter_brand"/>
            </div>
            <div>
                <label for="parameter_brand">Width</label>
                <form:input path="width" id="parameter_width"/>
            </div>
            <div>
                <label for="parameter_brand">Height</label>
                <form:input path="height" id="parameter_height"/>
            </div>
            <div>
                <label for="parameter_brand">Radius</label>
                <form:input path="radius" id="parameter_radius"/>
            </div>
            <div>
                <button>Save</button>
            </div>
        </form:form>
    </div>
</common:layout>
