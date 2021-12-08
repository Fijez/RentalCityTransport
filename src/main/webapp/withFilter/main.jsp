<%--
  Created by IntelliJ IDEA.
  User: tempT
  Date: 29.11.2021
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.accenture.davydenko.model.entity.UserEntity" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <meta charset="text/html;charset=UTF-8">
    <title>Menu</title>
</head>
<body>
<form action = "menu" method = "post">
    <p>  Hello, you are in the main menu<br>
        User data: <br>
        <strong><%= request.getSession().getAttribute("user")%> </strong> <br>
    </p>
</form>

<form action = "testServlet" method = "post">
    <input type = "submit" name = "login" value = "test filter"> <br>
</form>
</body>
</html>
