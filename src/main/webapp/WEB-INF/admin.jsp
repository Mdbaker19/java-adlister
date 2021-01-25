

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome Mr. Admin</h1>
    <p>Is Admin : ${sessionScope.isAdmin}</p>
</div>

</body>
</html>
