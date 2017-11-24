<%-- 
    Document   : Inquiry
    Created on : 21-11-2017, 17:38:00
    Author     : ML
--%>

<%@page import="FunctionLayer.Customer"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Inquiry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1 style="padding-left: 42%">All Inquiries</h1>
        
        <% List<Inquiry> inquiries = (List<Inquiry>)request.getAttribute("inquiries"); %>
        <% List<Customer> customers = (List<Customer>)request.getAttribute("customers"); %>
        <% int j = 0; %>
        <div class="container" style="background-color: grey; margin-bottom: 40px">
            <input type="text" name="searchword1" style="margin: 10px">
            <input type="text" name="searchword2" style="margin: 10px">
            
            <select name="sortby" size="1">
                <option>status</option>
                <option>customer</option>
                <option>employee</option>
            </select>
        </div>
        
        <div class="container">
            <div class="col-lg-6">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                          <th>ID</th>
                          <th>CommentCustomer</th>
                          <th>CommentEmployee</th>
                          <th>Period</th>
                          <th>Status</th>
                          <th>Customer phone</th>
                          <th>Id_employee</th>
                        </tr>
                    </thead>
                    <% for (Inquiry i : inquiries) { %>
                    <tr>
                        <td> <%= i.getId() %> </td>
                        <td> <%= i.getCommentCustomer() %> </td>
                        <td> <%= i.getCommentEmployee() %> </td>
                        <td> <%= i.getPeriod() %> </td>
                        <td> <%= i.getStatus() %> </td>
                        <td> <%= customers.get(j).getPhonenumber() %> </td>
                        <td> <%= i.getId_employee() %> </td>
                    </tr>
                    <% j++; %>
                    <% } %>
                </table>
            </div>
            <div class="col-lg-4" style="margin-left: 150px">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                          <th>Info</th>
                          <th>Updates</th>
                          <th>When</th>
                          <th>A</th>
                        </tr>
                    </thead>
                    <tr>
                        <td> row </td>
                        <td> in </td>
                        <td> the </td>
                        <td> tabel </td>
                    </tr>
                    <tr>
                        <td> to </td>
                        <td> the </td>
                        <td> left is clicked, </td>
                        <td> with js </td>
                    </tr>
                </table>
                <input type="submit" value="Se stykliste" name="inquiry" />
            </div>
        </div>
    </body>
</html>
