<%--
  Created by IntelliJ IDEA.
  User: DAT LE
  Date: 24/02/2023
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<h1>Chuyển đổi USD sang VND</h1>
<form action="/currency">
    <input type="text" name="usd">
    <input type="submit" value="Đổi">
</form>
<div>Kết quả: ${vnd} VND.</div>
</body>
</html>
