<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.Footballer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

    <tbody>
    <%
        ArrayList<Footballer> footballers = (ArrayList<Footballer>) request.getAttribute("footballers");
        if (footballers != null){
            for (Footballer footballer :footballers){
    %>
        <tr>
            <td>
                    <%= footballer.getId()%>
            </td>
        </tr>
    <%
            }
        }
    %>

    </tbody>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>