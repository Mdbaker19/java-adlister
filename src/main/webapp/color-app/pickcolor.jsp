<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/21/21
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick Color</title>
</head>
<body>

    <form action="/viewcolor" method="POST">
        <label>
            Enter a color
            <input name="color" id="color" placeholder="Enter your Color!">
            <button type="submit">Submit</button>
        </label>
    </form>

</body>
</html>
