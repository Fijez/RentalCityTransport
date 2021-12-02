<%--
  Created by IntelliJ IDEA.
  User: tempT
  Date: 23.11.2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Вход в систему</title>
</head>
<body>
<form action = "login" method = "post">
    <p>
        <strong>Логин(email):</strong>
        <input type = "email" name = "login"> <br>
        <strong>Пароль:</strong>
        <input type = "password" name = "password"> <br>
        <input type = "submit" name = "loginButton" value = "Войти в систему"> <br>
    </p>
</form>
</body>
</html>
