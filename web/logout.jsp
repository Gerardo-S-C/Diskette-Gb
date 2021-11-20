<%-- 
    Document   : logout
    Created on : 14/11/2021, 01:51:41 AM
    Author     : illum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
<%
session.invalidate();
response.sendRedirect("index.html");
%>
    </body>
</html>
