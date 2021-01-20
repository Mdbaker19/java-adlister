<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/19/21
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--set an attribute on the server side--%>
<% request.setAttribute("isAdmin", false); %>
<% request.setAttribute("isLoggedIn", false); %>
<% request.setAttribute("myItems", new String[] {"todo 1", "todo 2", "todo 3"}); %>

<html>
<head>
    <title>To do list</title>
</head>
<body>

<c:if test="${isAdmin}">
    <%@ include file="partials/adminNav.jsp" %>
</c:if>

<c:choose>
    <c:when test="${isLoggedIn}">
        <h3>You are logged In</h3>
    </c:when>
    <c:otherwise>
        <h3>You must log in first</h3>
    </c:otherwise>
</c:choose>


<h1>Here is your todo list</h1>

    <ul>
        <c:forEach items="${myItems}" var="li" >
            <li>${li}</li>
        </c:forEach>
        <li>
            <%=request.getParameter("item")%>
        </li>
    </ul>

</body>
</html>
