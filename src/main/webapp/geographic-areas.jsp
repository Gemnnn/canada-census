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
<html>
<head>
    <title>Geographic Areas</title>
</head>
<body>
<h2>Geographic Area Classification List</h2>
<% Map<Integer, List<GeographicArea>> areasByLevel = (Map<Integer, List<GeographicArea>>) request.getAttribute("areasByLevel");
    for (Map.Entry<Integer, List<GeographicArea>> entry : areasByLevel.entrySet()) {
        int level = entry.getKey();
        List<GeographicArea> areas = entry.getValue();
%>
<h3>Level <%= level %> - <%= level == 0 ? "Country" : level == 1 ? "Provinces and Territories" : level == 2 ? "CMA and CA" : "Provincial parts of CMA/CA" %></h3>
<ul>
    <% for (GeographicArea area : areas) { %>
    <li><%= area.getName() %></li>
    <% } %>
</ul>
<% } %>
</body>
</html>
