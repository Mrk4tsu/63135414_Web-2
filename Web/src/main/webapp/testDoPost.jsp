<!-- testDoPost.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TestDoPost</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="text-center">Bạn vừa yêu cầu Get</h1>
    <div class="row d-plex justify-content-center">
        <div class="col-md-6">
            <form method="post" action="TestDoPost">
                <div class="mb-3 form-floating">
                    <%--@declare id="fname"--%>
                    <input name="fname" type="text" placeholder="" class="form-control">
                    <label for="fname" class="form-label">Họ</label>

                </div>
                <div class="mb-3 form-floating">
                    <%--@declare id="lname"--%>

                    <input name="lname" type="text" placeholder="" class="form-control">
                    <label for="lname" class="form-label">Tên</label>

                </div>
                <button type="submit" class="btn btn-primary" style="width: 100%">Gửi</button>
            </form>

        </div>
    </div>


</div>

<!-- Bootstrap JS and Popper.js scripts (required for Bootstrap components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
