<%--
  Created by IntelliJ IDEA.
  User: ndtha
  Date: 1/23/2024
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="css/main.css">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
</head>
<body>
<%
    String yourName = request.getParameter("username");
    String yourPassword = request.getParameter("password");
    if (yourName.equals("ABC") && yourPassword.equals("MNK")) {
        response.sendRedirect("myCV.html");
    } else {
        response.sendRedirect("login.html");
    }
%>
</body>
</html>
