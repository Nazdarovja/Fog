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
                <tr>
                    
                    <td> <%= bom.getMaterials().get(0).getQuantity() %> </td>
                    <td> <%= bom.getMaterials().get(0).getAmountType() %> </td>
                    <td> <%= bom.getMaterials().get(0).getOrderLinePrice() %> </td>
                    <td> <%= bom.getMaterials().get(0).getUsabilityComment() %> </td>
                </tr>
            </table>
    </body>
</html>
