<%--
  Created by IntelliJ IDEA.
  User: ndtha
  Date: 1/23/2024
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
</head>
<body>
<%!
    int x = 10;
    int y;
    int z = 0;
%>
<%
    y = 200;
    z = x + y;
%>
<h2 class="fws-uppercase">Hoặc có thể in ra bằng Expression</h2>
<hr>
<%=
    "Kết quả là: "
%>
<%=z%>
</body>
</html>
