<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo1.Footballer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Footballers</title>
</head>
<body>

<h1>Footballers List</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Club</th>
        <th>Transfer Price</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Footballer> footballers = (ArrayList<Footballer>) request.getAttribute("footballers");
        if (footballers != null){
            for (Footballer footballer : footballers){
    %>
    <tr>
        <td><%= footballer.getId() %></td>
        <td><%= footballer.getName() %></td>
        <td><%= footballer.getSalary() %></td>
        <td><%= footballer.getClub() %></td>
        <td><%= footballer.getTransferPrice() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
