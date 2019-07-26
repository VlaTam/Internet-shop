<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Category</title>
    </head>
    <body>
        <form:form action="${pageContext.servletContext.contextPath}/category" method="POST" modelAttribute="category">
            <div>
                <%--<label for = "category_name_id">Название категории</label>--%>
                <form:input type = "text" name="name" path="name"/>
            </div>
            <div>
                <button type="submit">Submit</button>
            </div>
        </form:form>
    </body>
</html>

