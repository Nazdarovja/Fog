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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Register Page</title>
    </head>
    <body>
        <h1 class="col-sm-12" style="text-align: center">Register</h1>
        <div class="col-sm-5"></div>
        <div class="col-sm-2">
        <form class="form-group" name="register" action="FrontController" method="POST">
            <input  type="hidden" name="command" value="register">
            Email:<br>
            <input class="form-control" type="email" name="email">
            <br>
            Password:<br>
            <input  class="form-control" type="password" name="password1">
            <br>
            Re-enter Password:<br>
            <input class="form-control" type="password" name="password2">
            <br>
            Name:<br>
            <input class="form-control" type="text" name="name">
            <br>
            Surname:<br>
            <input class="form-control" type="text" name="surname">
            <br>
            Phone Number:<br>
            <input class="form-control" type="number" name="phonenumber">
            <br>
            Address:<br>
            <input class="form-control" type="text" name="address">
            <br>
            Zip code:<br>
            <input class="form-control" type="number" name="zipcode">
            <br>
            <input class="form-control" type="submit" value="Submit">
        </form>
            </div>
        <div class="col-sm-5"></div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
