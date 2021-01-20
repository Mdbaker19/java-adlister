<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/19/21
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blob file</title>
</head>
<body>

<h1>Welcome Mr. <%= request.getParameter("username") %></h1>
<h1>Welcome Mr. ${param.username}</h1>

<h1>The blob land</h1>
<p>blobs created : </p>
<p> blob's info here : </p>

<p>${header}</p>
<p>${cookie}</p>
<p>${sessionScope}</p>


</body>
</html>
