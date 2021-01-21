<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/21/21
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Order</title>
</head>
<body>

    <form action="/pizzaOrder" method="POST">
        <label>
            Select your crust
            <select name="crust">
                <option value="thin">Thin crust</option>
                <option value="normal">Normal</option>
                <option value="deepDish">Deep Dish</option>
            </select>
        </label>
        <label>
            Select your sauce
            <select name="sauce">
                <option value="bbq">bbq</option>
                <option value="other">other</option>
                <option value="red">red</option>
            </select>
        </label>
        <label>
            Select your size
            <select name="size">
                <option value="10">10</option>
                <option value="12">12</option>
                <option value="14">14</option>
            </select>
        </label>
        <label>
            Delivery Address
            <input name="address">
        </label>
        <label>
            Add Toppings?
            <input type="checkbox" name="toppings">
        </label>

        <button type="submit">Submit</button>
    </form>

</body>
</html>
