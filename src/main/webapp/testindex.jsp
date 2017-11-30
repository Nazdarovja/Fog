<%-- 
    Document   : forespørgelseoversigt
    Created on : 21-11-2017, 17:20:21
    Author     : ML
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="./img/foglogo.png"/>
        <title>Quick Byg Ansat</title>
    </head>
    <body>
        <h1>Til forespørgelsesoversigten!</h1>
        <form name="viewrequestcustomers" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewrequestcustomers">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
