
<%--
  Created by IntelliJ IDEA.
  User: Branden
  Date: 2024-03-07
  Time: 7:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="beans.GeographicBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Geographic Areas</title>
</head>
<body>
    <div class="container-fluid text-center pb-3">
        <h2>Geographic Areas Classification List</h2>
    </div>
    <div class="container">
        <div class="row justify-content-center">
            <c:forEach var="entry" items="${areasByLevel}">
                <div class="col-3">
                    <h4>Level ${entry.key}</h4>
                    <ul>
                        <c:forEach var="area" items="${entry.value}">
                            <li>${area.name} (Code: ${area.code})</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>

