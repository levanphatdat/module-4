<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DAT LE
  Date: 28/02/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<h1>Form</h1>
<table class="container-fluid">
    <tr>
        <div class="form-control">
            <th>Languages:</th>
            <td>${emailBox.languages}</td>
        </div>
    </tr>
    <tr>
        <div class="form-control">
            <th>Page size:</th>
            <td><span>Show</span>
                <span>${emailBox.languages}</span>
                <span>emails per size</span></td>
        </div>
    </tr>
    <tr>
        <div class="form-control">
            <th>Languages:</th>
            <td>${emailBox.languages}</td>
        </div>
    </tr>
    <tr>
        <div class="form-control">
            <th>Span Filter:</th>
            <td>
            <span>
                <c:if test="${emailBox.spamFilter}">
                    Enable spams filter
                </c:if>
                <c:if test="${!emailBox.spamFilter}">
                    Disable spams filter
                </c:if>
            </span>
            </td>
        </div>
    </tr>
    <tr>
        <div class="form-control">
            <th>Signature:</th>
            <td>${emailBox.signature}</td>
        </div>
    </tr>
    <tr>
        <td><a href="/emailBox/" class="btn btn-primary">Update</a></td>
    </tr>
</table>
<script src="/js/bootstrap.js"></script>
</body>
</html>
