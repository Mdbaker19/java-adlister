<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 2/1/21
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit your ad" />
    </jsp:include>
</head>
<body>

    <form method="POST" action="/edit">
        <div class="form-group">
            <label for="newTitle">Title</label>
            <input id="newTitle" name="newTitle" class="form-control" type="text" value="Title here">
        </div>
        <div class="form-group">
            <label for="newDesc">Description</label>
            <textarea id="newDesc" name="newDesc" class="form-control" type="text">Description here</textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>

</body>
</html>
