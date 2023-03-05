<%--
  Created by IntelliJ IDEA.
  User: DAT LE
  Date: 27/02/2023
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <br><br>
    <input type="submit" name="calculation" value="Addition(+)">
    <input type="submit" name="calculation" value="Subtraction(-)">
    <input type="submit" name="calculation" value="Multiplication(*)">
    <input type="submit" name="calculation" value="Division(/)">
</form>
<div>${result}</div>
</body>
</html>
