<%--
  Created by IntelliJ IDEA.
  User: tempT
  Date: 27.03.2022
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="model.entity.UserEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <meta charset="text/html;charset=UTF-8">
    <title>Admin</title>
</head>
<body>
<form action = "admin" method = "post">
    <p>  Hello, you are in the admin menu<br>
        Users data: <br>
        <strong><%
            out.println("<ui>");
            for (UserEntity user
            :(List<UserEntity>)request.getSession().getAttribute("getAll")){
                out.println("<li>" + user + "</li>");
            }
            out.println("</ui>");
        %> </strong> <br>
    </p>
</form>

<form action = "testServlet" method = "post">
    <input type = "submit" name = "login" value = "test filter"> <br>
</form>
</body>
</html>
