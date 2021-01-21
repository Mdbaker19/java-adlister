<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/21/21
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess Log in</title>
</head>
<body>

    <h1>Log in to play the guessing game</h1>

    <form method="POST" action="/guesslogin">
        <label>
            Your guesser name
            <input name="guesser">
        </label>
        <label>
            Enter the low end number to guess from
            <input name="low">
        </label>
        <label>
            Enter the high end number to guess to
            <input name="high">
        </label>
        <button type="submit">Log in</button>
    </form>

</body>
</html>
