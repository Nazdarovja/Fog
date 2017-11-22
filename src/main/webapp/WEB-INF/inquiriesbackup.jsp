<%-- 
    Document   : Inquiry
    Created on : 21-11-2017, 17:38:00
    Author     : ML
--%>

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
        <h1>All Inquiries</h1>
        
        <% List<Inquiry> inquiries = (List<Inquiry>)request.getAttribute("inquiries"); %>
        
        
        <div class="container">
            <div class="col-lg-6">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                          <th>ID</th>
                          <th>CarportHeight</th>
                          <th>CarportLength</th> 
                          <th>CarportWidth</th>
                          <th>ShackWidth</th>
                          <th>ShackLength</th>
                          <th>RoofType</th>
                          <th>Angle</th>
                          <th>CommentCustomer</th>
                          <th>CommentEmployee</th>
                          <th>Period</th>
                          <th>Status</th>
                          <th>Email</th>
                          <th>Id_employee</th>
                        </tr>
                    </thead>
                    <% for (Inquiry i : inquiries) { %>
                    <tr>
                        <td> <%= i.getId() %> </td>
                        <td> <%= i.getCarportHeight() %> </td>
                        <td> <%= i.getCarportLength() %> </td>
                        <td> <%= i.getCarportWidth() %> </td>
                        <td> <%= i.getShackWidth() %> </td>
                        <td> <%= i.getShackLength() %> </td>
                        <td> <%= i.getRoofType() %> </td>
                        <td> <%= i.getAngle() %> </td>
                        <td> <%= i.getCommentCustomer() %> </td>
                        <td> <%= i.getCommentEmployee() %> </td>
                        <td> <%= i.getPeriod() %> </td>
                        <td> <%= i.getStatus() %> </td>
                        <td> <%= i.getEmail() %> </td>
                        <td> <%= i.getId_employee() %> </td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <div class="col-lg-6">
                
            </div>
        </div>
    </body>
</html>
