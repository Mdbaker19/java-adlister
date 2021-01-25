<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/25/21
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Change settings here" />
    </jsp:include>
    <%@ include file="partials/theme.jsp" %>
</head>
<body>

    <jsp:include page="partials/navbar.jsp" />

    <c:choose>

        <c:when test="${isLoggedIn}">

            <form method="POST" action="/settings">
                <label>
                    Dark Mode
                    <input type="radio" name="theme" value="dark" id="dark">
                </label>
                <label>
                    Light Mode (Default)
                    <input type="radio" name="theme" value="light" id="light" checked="checked">
                </label>
                <button type="submit">Apply change</button>
            </form>

            <form method="POST" action="/settings">
                <label>
                    Reset settings
                    <input type="hidden" value="yes" name="reset">
                    <button type="submit">Reset</button>
                </label>
            </form>

            <a href="/profile">Back to profile</a>

        </c:when>

        <c:otherwise>
            <h1>You need to log in to view settings</h1>
            <a href="/login">Login</a>
        </c:otherwise>

    </c:choose>

</body>
</html>
