<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"/>
    <title>Test</title>

    <link rel="stylesheet" type="text/css" th:href="@{/webjars/bootstrap/css/bootstrap.min.css}"/>
</head>

<body>
<div class="container text-center">
    <h1>Welcome to my application!</h1>
    <a class="h2 text-primary text-decoration-none" th:href="@{/about}">User Manager</a>
</div>
</body>

</html>
