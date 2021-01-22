<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing your profile Mr admin.</h1>
        <h3>If you logged in as admin you are here</h3>
        <a href="/ads">View your ads</a>
    </div>

</body>
</html>
