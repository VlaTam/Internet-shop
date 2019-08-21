<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <sec:authorize access="!hasRole('ROLE_ADMIN')">
            <section class="container">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <div class="float-right">
                            <a href="${pageContext.servletContext.contextPath}/basket">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/basket_icon.png" alt="Basket">
                            </a>
                        </div>
                    </div>
                </div>
            </section>
        </sec:authorize>
        <jsp:doBody/>
    </body>
</html>
