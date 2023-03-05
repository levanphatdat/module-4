<%--
  Created by IntelliJ IDEA.
  User: DAT LE
  Date: 27/02/2023
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <input type="checkbox" value="lettuce" , name="condiment"> Lettuce
    <input type="checkbox" value="tomato" , name="condiment"> Tomato
    <input type="checkbox" value="mustard" , name="condiment"> Mustard
    <input type="checkbox" value="sprouts" , name="condiment"> Sprouts
    <br>
    <input type="submit" value="Save">
</form>
<div>${condiment}</div>
</body>
</html>
