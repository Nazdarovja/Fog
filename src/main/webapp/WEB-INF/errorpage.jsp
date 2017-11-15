<%-- 
    Document   : errorpage
    Created on : Nov 14, 2017, 5:45:29 PM
    Author     : Mellem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <% String errorMessage = (String)request.getAttribute("error"); %>
        
        <h1>Error!</h1>
        <br>
        <p>
           <%= errorMessage %>
        </p>
    </body>
</html>
