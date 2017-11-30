<%-- 
    Document   : login
    Created on : Nov 15, 2017, 5:13:38 PM
    Author     : Alexander W. Hørsted-Andersen <awha86@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="../Style/main.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="./img/foglogo.png"/>
        <title>Login Page</title>
    </head>
    <body>
        <h1 style="text-align: center;">Carport QuickByg Login</h1>  
        <div class="col-sm-8 col-md-offset-5">
        <table>
            <tr>
                <td class="col-sm-4">
                    <p>Login</p>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="QuickBuild">
                        Email:<br>
                        <input type="text" name="email">
                        <br>
                        Password:<br>
                        <input type="password" name="password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
<!--                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email">
                        <br>
                        Password:<br>
                        <input type="password" name="password1">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>-->
            </tr>
        </table>
    </div>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>
            
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
