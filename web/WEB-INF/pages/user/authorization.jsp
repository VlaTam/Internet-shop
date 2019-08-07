<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<common:layout title="authorization">
    <div>
        <div>
            <div>
                <h1>Authorization</h1>
            </div>
            <form id="authorizeForm" onsubmit="authorize()">
                <div>
                    <label for="mail_address_id">Mail address</label>
                    <input name="mailAddress" id="mail_address_id" required/>
                </div>
                <div>
                    <label for="password_id">Password</label>
                    <input name="password" id="password_id" required/>
                </div>
                <button>Authorize</button>
            </form>
        </div>
    </div>
    <script defer src="<c:url value="/resources/authorization.js"/>"></script>
</common:layout>
