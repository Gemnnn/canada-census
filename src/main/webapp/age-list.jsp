<%--
  Created by IntelliJ IDEA.
  User: Branden
  Date: 2024-03-07
  Time: 9:31 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.AgeData" %>
<html>
<head>
    <title>Age List</title>
</head>
<body>
<h2>Population Data</h2>
<c:forEach items="${ageData}" var="data">
    <p>Year: ${data.year}</p>
    <p>Male Population: ${data.malePopulation}</p>
    <p>Female Population: ${data.femalePopulation}</p>
    <hr>
</c:forEach>
</body>
</html>
