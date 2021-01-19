<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/19/21
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
  build this with the run and go to the local host / file name (home.jsp)
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int pageNum = 1; %>
<html>
<head>
    <title>Home Page Lec JSP</title>
</head>
<body>

    <%@ include file="partials/navbar.jsp"%>

    <h1>Hello Jupiter!</h1>

    <p><%= pageNum %></p>

<%--    through the action the values used in {name} can then be referenced through the request.get param--%>
    <form action="blob.jsp" method="get">
        <input type="hidden" id="username" name="username" value="Blob">
        <input type="hidden" id="lastname" name="lastname" value="theBloby">
        <button type="submit">Go There and see the Blobs</button>
    </form>


    <%@ include file="partials/footer.jsp"%>

    <form action="todo.jsp" method="get">
        <label>
            <input type="text" id="item" name="item">
            <button type="submit">See the todo list</button>
        </label>
    </form>

</body>
</html>
