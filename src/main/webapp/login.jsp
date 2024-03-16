<%--
  Created by IntelliJ IDEA.
  User: Branden
  Date: 2024-03-07
  Time: 6:36 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Login</title>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col col-4 text-center">
                <h2>Census Canada Login</h2>
                <% if (request.getAttribute("loginFailed") != null) { %>
                <p>Invalid username or password. Please try again.</p>
                <% } %>
                <form action="LoginServlet" method="post">
                    <div class="mb-3 mt-3">
                        <label for="username" class="form-label">Username: </label>
                        <input type="text" class="form-control" name="username" id="username" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password: </label>
                        <input type="password" class="form-control" name="password" id="password" required>
                    </div>
                    <button type="submit" value="Login" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
