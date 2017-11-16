<%-- 
    Document   : QuickBuild
    Created on : 14-11-2017, 12:40:08
    Author     : Orchi
--%>

<%@page import="FunctionLayer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center">Hejsa, vælg dine mål til din kommende carport!</h1>
        <div id="measurements" class="col-md-6 col-md-offset-4">
                <% Customer customer = null;
                    if((customer = (Customer) request.getSession().getAttribute("customer")) != null ) { %>
                    <p>Hello <%= customer.getName() %>, start buying!!! </p>
                <% } else {%>
                    <p>click <a href="FrontController?command=login">here</a> to log in!</p>
                <% } %>
            <form name="order" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="measurements">
                    <div class="col-sm-2">
                    Vælg længde<br>
                    <select class="form-control" name="length">
                            <option value=240>240</option>
                            <option value=270>270</option>
                            <option value=300>300</option>
                            <option value=330>330</option>
                            <option value=360>360</option>
                            <option value=390>390</option>
                            <option value=420>420</option>
                            <option value=450>450</option>
                            <option value=480>480</option>
                            <option value=510>510</option>
                            <option value=540>540</option>
                            <option value=570>570</option>
                            <option value=600>600</option>
                            <option value=630>630</option>
                            <option value=660>660</option>
                            <option value=690>690</option>
                            <option value=720>720</option>
                            <option value=750>750</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                    Vælg bredde<br>
                    <select class="form-control" name="width">
                            <option value=240>240</option>
                            <option value=270>270</option>
                            <option value=300>300</option>
                            <option value=330>330</option>
                            <option value=360>360</option>
                            <option value=390>390</option>
                            <option value=420>420</option>
                            <option value=450>450</option>
                            <option value=480>480</option>
                            <option value=510>510</option>
                            <option value=540>540</option>
                            <option value=570>570</option>
                            <option value=600>600</option>
                            <option value=630>630</option>
                            <option value=660>660</option>
                            <option value=690>690</option>
                            <option value=720>720</option>
                            <option value=750>750</option>
                            <option value=780>780</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                    Vælg højde<br>
                        <select class="form-control" name="height">
                            <option value=210>210</option>
                            <option value=240>240</option>
                            <option value=270>270</option>
                            <option value=300>300</option>
                            <option value=330>330</option>
                        </select>
                    </div>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>