<%@attribute name="title" required = "true"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>
            ${title}
        </title>
    </head>
    <body>
        <header class="row w-100 mb-2">
            <div class="col">
                <a href="${pageContext.servletContext.contextPath}/">Go to main page</a>
            </div>
        </header>
        <jsp:doBody/>
    </body>
</html>