<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo2.Footballer" %>
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

        if (footballers != null && !footballers.isEmpty()){
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
    } else {
    %>
    <tr>
        <td colspan="5">No footballers available.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="fffServlet" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="f_name" required><br><br>


    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="f_salary" required><br><br>

    <label for="club">Club:</label>
    <input type="text" id="club" name="f_club" required><br><br>

    <label for="transferPrice">Transfer Price:</label>
    <input type="number" id="transferPrice" name="f_price" required><br><br>

    <input type="submit" value="Add Footballer">
</form>

</body>
</html>
