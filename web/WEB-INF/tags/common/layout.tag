<%@attribute name="title" required = "true"%>

<!DOCTYPE html>
<html>
    <head>
        <title>
            ${title}
        </title>
    </head>
    <body>
        <header>
            <div>
                <a href="${pageContext.servletContext.contextPath}/">Go to main page</a>
            </div>
        </header>
        <jsp:doBody/>
    </body>
</html>