<%--
  Created by IntelliJ IDEA.
  User: Branden
  Date: 2024-03-07
  Time: 8:03 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.GeographicAreaBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Geographic Area Details</title>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col col-6 text-center pb-4">
                <h2>Select a Geographic Area</h2>
                <form action="area-details" method="post">
                    <select name="areaCode">
                        <option value="" selected disabled hidden>Select a Geographic Area...</option>
                        <jsp:useBean id="areas" scope="request" type="java.util.List"/>
                        <c:forEach items="${areas}" var="area">
                            <option value="${area.geographicAreaID}">${area.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Detail">
                </form>

                <c:if test="${not empty selectedAreaDetail}">
                    <div class="p-2">
                        <h3>Details for ${selectedAreaDetail.name}:</h3>
                    </div>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Code</th>
                            <th>Level</th>
                            <th>Total Population</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${selectedAreaDetail.name}</td>
                            <td>${selectedAreaDetail.code}</td>
                            <td>${selectedAreaDetail.level}</td>
                            <td>${selectedAreaDetail.totalPopulation}</td>
                        </tr>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>

