<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/19/21
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Your Profile</title>
    <%@include file="partials/head.jsp" %>
</head>
<body>
<%@include file="partials/navBar.jsp" %>

<h1>Viewing profile for ${param.user}</h1>

</body>
</html>
