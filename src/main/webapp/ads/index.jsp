<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/22/21
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Ads" />
    </jsp:include>
    <style><%@include file="/Css/index.css"%></style>
</head>
<body>

    <c:forEach var="ad" items="${ads}">
        <div id="adBox">
            <h1>${ad.title}</h1>
            <p>${ad.description}</p>
        </div>
    </c:forEach>


</body>
</html>
