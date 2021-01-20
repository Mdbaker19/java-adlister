<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/19/21
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% if(request.getMethod().equals("post")) {
    String password = request.getParameter("pass");
    String username = request.getParameter("user");
    if(password.equals("password") && username.equals("admin")){
        response.sendRedirect("/profile.jsp");
    }
}
%>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Log in page</h1>
    <form action="login.jsp" method="post">
        <label>
            Enter Username
            <input type="text" name="user" id="user">
        </label>
        <label>
            Enter Password
            <input type="password" name="pass" id="pass">
        </label>
        <button type="submit">Log in</button>
    </form>

</body>
</html>
