<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/19/21
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--set an attribute on the server side--%>
<% request.setAttribute("isAdmin", false); %>
<html>
<head>
    <title>To do list</title>
</head>
<body>


<h1>Here is your todo list</h1>

    <ul>
        <li>
            <%=request.getParameter("item")%>
        </li>
    </ul>

</body>
</html>
