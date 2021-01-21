<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/21/21
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Guessing Game</title>
</head>
<body>

    <form action="/guess" method="POST">
        <label>
            Enter a number between 1 and 3
            <input name="number">
        </label>
        <button type="submit">Submit</button>
    </form>
    <c:if test="${notValid}">
        <h1>Looks like you entered an invalid number</h1>
    </c:if>

</body>
</html>
