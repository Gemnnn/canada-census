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
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if (request.getAttribute("loginFailed") != null) { %>
<p>Invalid username or password. Please try again.</p>
<% } %>
<form action="LoginServlet" method="post">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
