<%-- 
    Document   : billofmaterials
    Created on : Nov 24, 2017, 11:45:00 AM
    Author     : Mellem
--%>

<%@page import="FunctionLayer.Product"%>
<%@page import="FunctionLayer.ProductPerMeterPrice"%>
<%@page import="FunctionLayer.ProductPerPiece"%>
<%@page import="FunctionLayer.ProductPerPrice"%>
<%@page import="FunctionLayer.OrderLine"%>
<%@page import="FunctionLayer.BillOfMaterials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="./img/foglogo.png"/>
        <title>Stykliste Carport</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <% BillOfMaterials bom = (BillOfMaterials)request.getAttribute("bom"); %>
        
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
                <% for (OrderLine i : bom.getMaterials()) { %>
                    <td> 
                        <% if (i.getProduct() != null) { %>
                        <%= i.getProductName() %>
                        <% } else {%>
                        product
                        <% } %>
                    </td>
                    <td> 
                    <% if (i.getProduct() != null) { %>
                        <%= i.getProductCategory() %>
                        <% } else {%>
                        category
                        <% } %>
                    </td>
                    <td> <%= i.getQuantity() %> </td>
                    <td> <%= i.getAmountType() %> </td>
                    <td> 
                    <% if (i.getProduct() != null) { %>
                        <%= i.getOrderLinePrice() %> 
                        <% } else {%>
                        order line price
                        <% } %>
                    </td>
                    <td> <%= i.getUsabilityComment() %> </td>
                    
                </tr>  
                <% } %>
            </table>
    </body>
</html>
