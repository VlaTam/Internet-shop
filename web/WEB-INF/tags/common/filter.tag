<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<section>
    <sf:form action="${pageContext.servletContext.contextPath}/filtered" method="GET" modelAttribute="paremeters">
        <div>
            <sf:select path="${}"
        </div>
    </sf:form>
</section>
