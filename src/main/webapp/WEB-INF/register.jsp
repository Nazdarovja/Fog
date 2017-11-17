<%-- 
    Document   : register
    Created on : Nov 16, 2017, 6:27:08 PM
    Author     : Mellem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register</h1>
        
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="command" value="register">
            Email:<br>
            <input type="email" name="email">
            <br>
            Password:<br>
            <input type="password" name="password1">
            <br>
            Re-enter Password:<br>
            <input type="password" name="password2">
            <br>
            Name:<br>
            <input type="text" name="name">
            <br>
            Surname:<br>
            <input type="text" name="surname">
            <br>
            Phone Number:<br>
            <input type="number" name="phonenumber">
            <br>
            Address:<br>
            <input type="text" name="address">
            <br>
            Zip code:<br>
            <input type="number" name="zipcode">
            <br>
            <input type="submit" value="Submit">
        </form>
        
    </body>
</html>
