<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DAT LE
  Date: 28/02/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<h1>Setting</h1>
<table class="container-fluid">
    <form:form action="/emailBox" modelAttribute="emailBox" method="post">
        <tr>
            <div class="form-control">
                <th>Languages:</th>
                <td><form:select path="languages" items="${languages}"/></td>
            </div>
        </tr>
        <tr>
            <div class="form-control">
                <th>Page Size:</th>
                <td>
                    <span>Show</span>
                    <form:select path="pageSize" items="${pageSize}"/></td>
            </div>
        </tr>
        <tr>
            <div class="form-control">
                <th>Spams Filter:</th>
                <td>
                    <form:checkbox path="spamFilter"/>
                    <label for="">Enable spams filter</label>
                </td>
            </div>
        </tr>
        <div class="form-control">
            <th>Signature:</th>
            <td>
                <form:textarea path="signature"/>
            </td>
        </div>
        </tr>
        <tr>
            <div class="form-control">
                <td>
                    <button type="submit" class="btn btn-primary">Update</button>
                    <button type="button" class="btn btn-primary" onclick="window.location.href='/emailBox'">Cancel
                    </button>
                </td>
            </div>
        </tr>
    </form:form>
</table>
<script src="/js/bootstrap.js"></script>
</body>
</html>
