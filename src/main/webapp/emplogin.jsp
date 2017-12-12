<%-- 
    Document   : emplogin
    Created on : Dec 12, 2017, 10:26:58 AM
    Author     : Mellem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Employee</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <link href="${pageContext.request.contextPath}/Style/emplogin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="inner">
            <div class="formbackground">

                <div class="picholder">
                    <img src="./img/foglogo2.png" alt="Fog">
                </div>

                <form>
                    <div class="formcontent" id="emplogin" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="emplogin">
                        <input class="form-control" type="text" id="loginid" placeholder="id" style="margin-bottom: 30px;">
                        <input class="form-control" type="password" id="loginpwd" placeholder="password"style="margin-bottom: 60px;">
                        <input id="buttondown" class="form-control" type="submit" value="login">
                    </div>
                </form>
            </div>
            </div>
        </div>
    </body>
</html>
