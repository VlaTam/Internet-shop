<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <section class="container-fluid">
            <header class="row bg-secondary" style="height: 80px;">
                <div class="col-md-2 d-flex align-items-md-center justify-content-md-end">
                    <div>
                        <a href="${pageContext.servletContext.contextPath}/">
                            <img class="text-white img-fluid" src="${pageContext.servletContext.contextPath}/resources/images/logo.png" alt="Go to main page">
                        </a>
                    </div>
                </div>
            </header>

            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3 d-flex align-items-md-center justify-content-md-end">
                    <div class="">
                        <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/catalog">Open catalog</a>
                    </div>
                </div>
                <div class="col-md-3 d-flex align-items-md-center justify-content-md-start">
                    <sec:authorize access="!hasRole('ROLE_ADMIN')">
                        <a href="${pageContext.servletContext.contextPath}/basket">
                            <img src="${pageContext.servletContext.contextPath}/resources/images/basket_icon.png" alt="Basket">
                        </a>
                    </sec:authorize>
                </div>
            </div>
            <jsp:doBody/>
        </section>
    </body>
</html>
