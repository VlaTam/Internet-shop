<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Category</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}" method="POST">
            <div>
                <label for = "category_name_id">Название категории</label>
                <input id="category_name_id" type="text" name="name">
            </div>
            <div>
                <input type="submit">
            </div>
        </form>
    </body>
</html>

