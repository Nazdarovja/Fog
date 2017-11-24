<%-- 
    Document   : billofmaterials
    Created on : Nov 24, 2017, 11:45:00 AM
    Author     : Mellem
--%>

<%@page import="FunctionLayer.OrderLine"%>
<%@page import="FunctionLayer.BillOfMaterials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <tr>
                    <td> <%= i.getProduct().getName() %> </td>
                    <td> <%= i.getProduct().getCategory() %> </td>
                    <td> <%= i.getQuantity() %> </td>
                    <td> <%= i.getAmountType() %> </td>
                    <td> <%= i.getOrderLinePrice() %> </td>
                    <td> <%= i.getUsabilityComment() %> </td>
                </tr>
                <% } %>
            </table>
    </body>
</html>
