<%@attribute name="title" required = "true"%>

<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <title>
            ${title}
            <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
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
