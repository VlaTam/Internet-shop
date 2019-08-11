<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<common:layout title="authorization">
    <section>
        <div>
            <div>
                <h1>Authorization</h1>
            </div>
            <sf:form id="authorizeForm" action="${pageContext.servletContext.contextPath}/user/authorization" method="POST" modelAttribute="user">
                <div>
                    <label for="mail_address_id">Mail address</label>
                    <sf:input path="mailAddress" id="mail_address_id" required="true"/>
                </div>
                <div>
                    <label for="password_id">Password</label>
                    <sf:input path="password" id="password_id" required="true"/>
                </div>
                <div>
                    <button>Confirm</button>
                </div>
            </sf:form>
        </div>
        <script src="${pageContext.servletContext.contextPath}/resources/authorization.js"></script>
    </section>
</common:layout>
