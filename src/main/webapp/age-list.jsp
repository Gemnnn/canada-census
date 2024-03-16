<%--
  Created by IntelliJ IDEA.
  User: Branden
  Date: 2024-03-07
  Time: 9:31 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.AgeBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Age List</title>
</head>
<body>
    <div class="container">
        <div class="text-center pb-3">
            <h2>Population Data</h2>
        </div>
        <div class="row justify-content-center">
            <div class="col col-6 text-center pb-4">
                <jsp:useBean id="ageData" scope="request" type="java.util.List"/>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col" class="col-1">Year</th>
                            <th scope="col" class="col-1">Male Population</th>
                            <th scope="col" class="col-1">Female Population</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ageData}" var="data">
                            <tr>
                                <td>${data.year}</td>
                                <td>${data.malePopulation}</td>
                                <td>${data.femalePopulation}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
