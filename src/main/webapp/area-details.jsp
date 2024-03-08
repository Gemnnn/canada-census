<%--
  Created by IntelliJ IDEA.
  User: Branden
  Date: 2024-03-07
  Time: 8:03 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.GeographicArea" %>
<html>
<head>
    <title>Geographic Area Details</title>
</head>
<body>

<h2>Select a Geographic Area</h2>
<form action="area-details" method="post">
    <select name="areaCode">
        <c:forEach items="${areas}" var="area">
            <option value="${area.geographicAreaID}">${area.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Detail">
</form>

<!-- Display the details for the selected area -->
<c:if test="${not empty selectedAreaDetail}">
    <div>
        <h3>Details for Selected Area:</h3>
        <p>Name: ${selectedAreaDetail.name}</p>
        <p>Code: ${selectedAreaDetail.code}</p>
        <p>Level: ${selectedAreaDetail.level}</p>
        <p>Total Population (2021): ${selectedAreaDetail.totalPopulation}</p>
    </div>
</c:if>

</body>
</html>

