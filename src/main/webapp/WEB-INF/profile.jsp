<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <%@ include file="partials/theme.jsp" %>

</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing your profile.</h1>
        <h1>Welcome ${sessionScope.user}</h1>
    </div>

    <form action="POST" method="/newAd">
        <label>
            Id
            <input name="id" id="id">
        </label>
        <label>
            User Id
            <input name="userId" id="userId">
        </label>
        <label>
            Title
            <input name="title" id="title">
        </label>
        <label>
            Description
            <input name="description" id="description">
        </label>


        <button type="submit">Add your Ad</button>
    </form>

</body>
</html>
