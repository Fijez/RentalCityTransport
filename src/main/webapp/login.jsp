<%--
  Created by IntelliJ IDEA.
  User: tempT
  Date: 23.11.2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <meta charset="utf-8">
    <title>sign in</title>
</head>
<body>
<form action = "login" method = "post">
    <p>
        <strong>Логин(email):</strong>
        <input type = "email" name = "login"> <br>
        <strong>Password:</strong>
        <input type = "password" name = "password"> <br>
        <input type = "submit" name = "loginButton" value = "sign in"> <br>
    </p>
</form>
</body>
</html>
