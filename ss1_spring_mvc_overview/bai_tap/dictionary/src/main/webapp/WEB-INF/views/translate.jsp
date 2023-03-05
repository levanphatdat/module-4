<%--
  Created by IntelliJ IDEA.
  User: DAT LE
  Date: 24/02/2023
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
<h1>Translate</h1>
<form action="/translate">
    <input type="text" name="string">
    <input type="submit" value="Translate">
</form>
<div>Result: ${translate}</div>
</body>
</html>
