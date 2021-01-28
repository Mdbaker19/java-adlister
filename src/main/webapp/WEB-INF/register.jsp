
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Registration" />
    </jsp:include></head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />


<h1>Welcome ! please register below</h1>
<c:if test="${sessionScope.userNameTakenAlready}">
    <h1>Username already taken</h1>
</c:if>
<c:if test="${sessionScope.invalidUn}">
    <h1>Invalid Username</h1>
</c:if>
<c:if test="${sessionScope.invalidEm}">
    <h1>Invalid Email</h1>
</c:if>
<c:if test="${sessionScope.invalidPa}">
    <h1>Invalid Password</h1>
</c:if>


    <form method="POST" action="/register">
        <label>
            Username (must be at least 5 characters)
            <input id="un" name="un">
        </label>
        <label>
            Email
            <input id="email" name="email" type="email">
        </label>
        <label>
            Password ( must be at least 8 characters)
            <input type="password" id="pass" name="pass">
        </label>
        <button type="submit">Register</button>
    </form>

</body>
</html>
