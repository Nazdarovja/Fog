<%-- 
    Document   : inquiry
    Created on : Nov 26, 2017, 8:49:00 PM
    Author     : Mellem
--%>

<%@page import="FunctionLayer.OrderLine"%>
<%@page import="FunctionLayer.BillOfMaterials"%>
<%@page import="FunctionLayer.Customer"%>
<%@page import="FunctionLayer.Inquiry"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="./img/foglogo.png"/>
        <title>Forespørgsel</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <link href="${pageContext.request.contextPath}/Style/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Inquiry</h1>
        
        <% Inquiry i = (Inquiry)request.getAttribute("inquiry"); %>
        <% BillOfMaterials bom = (BillOfMaterials)request.getAttribute("bom"); %>
        
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
            <div class="col-lg-12">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                          <th>ID</th>
                          <th>CommentCustomer</th>
                          <th>CommentEmployee</th>
                          <th>Period</th>
                          <th>Status</th>
                          <th>Customer Email</th>
                          <th>Id_employee</th>
                        </tr>
                    </thead>
                    <tr>
                        <td> <%= i.getId() %> </td>
                        <td> <%= i.getCommentCustomer() %> </td>
                        <td> <%= i.getCommentEmployee() %> </td>
                        <td> <%= i.getPeriod() %> </td>
                        <td> <%= i.getStatus() %> </td>
                        <td> <%= i.getEmail() %> </td>
                        <td> <%= i.getId_employee() %> </td>
                    </tr>
                </table>
            </div>
        </div>
        <br><br>
        
        <h1>Bill of Materials</h1>
        
        <table class="table table-bordered">
                <thead>
                    <tr>
                      <th>Product</th>
                      <th>Category</th>
                      <th>Qty</th>
                      <th>Unit</th>
                      <th>Price</th>
                      <th>Usability Comment</th>
                    </tr>
                </thead>
                <% for (OrderLine j : bom.getMaterials()) { %>
                    <td> 
                        <% if (j.getProduct() != null) { %>
                        <%= j.getProductName() %>
                        <% } else {%>
                        product
                        <% } %>
                    </td>
                    <td> 
                    <% if (j.getProduct() != null) { %>
                        <%= j.getProductCategory() %>
                        <% } else {%>
                        category
                        <% } %>
                    </td>
                    <td> <%= j.getQuantity() %> </td>
                    <td> <%= j.getAmountType() %> </td>
                    <td> 
                    <% if (j.getProduct() != null) { %>
                        <%= j.getOrderLinePrice() %> 
                        <% } else {%>
                        order line price
                        <% } %>
                    </td>
                    <td> <%= j.getUsabilityComment() %> </td>
                </tr>  
                <% } %>
            </table>
    </body>
</html>
