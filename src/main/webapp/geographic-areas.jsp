
<%--
  Created by IntelliJ IDEA.
  User: Branden
  Date: 2024-03-07
  Time: 7:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="models.GeographicArea" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Geographic Areas</title>
</head>
<body>
<h2>Geographic Areas Classification List</h2>

<c:forEach var="entry" items="${areasByLevel}">
    <h3>Level ${entry.key}</h3>
    <ul>
        <c:forEach var="area" items="${entry.value}">
            <li>${area.name} (Code: ${area.code})</li>
        </c:forEach>
    </ul>
</c:forEach>

</body>
</html>

