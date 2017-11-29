<%-- 
    Document   : inquiries
    Created on : Nov 26, 2017, 5:53:58 PM
    Author     : Mellem
--%>

<%@page import="FunctionLayer.Customer"%>
<%@page import="FunctionLayer.Inquiry"%>
<%@page import="java.util.List"%>
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
        
        
        <link href="${pageContext.request.contextPath}/Style/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>All Customers With Pending Inquiry</h1>
        
        <% String idTable = "customertable"; %>
        <% List<Customer> c = (List<Customer>)request.getAttribute("customers"); %>
        
        <div class="container">
            <div class="sortbar">
                <input type="text" name="searchword1" style="margin: 10px">
                <input type="text" name="searchword2" style="margin: 10px">

                <select id="sortby" size="1">
                    <option value="0">Email</option>
                    <option value="4">Address</option>
                    <option value="5">Zipcode</option>
                </select>
                
                <input type="submit" value="Sort" >
            </div>
        </div>
        
        <div class="container">
            <div class="col-lg-12">
                <table class="table table-bordered" id="customertable">
                    
                        <tr>
                          <th class="sorthead" onclick="sortTable('customertable',0)">Email</th>
                          <th class="sorthead" onclick="sortTable('customertable',1)">Name</th>
                          <th class="sorthead" onclick="sortTable('customertable',2)">Surname</th>
                          <th class="sorthead" onclick="sortTable('customertable',3)">Phone number</th>
                          <th class="sorthead" onclick="sortTable('customertable',4)">Address</th>
                          <th class="sorthead" onclick="sortTable('customertable',5)">Zipcode</th>
                          <th class="sorthead" onclick="sortTable('customertable',6)">City</th>
                        </tr>
                    
                    <% for (Customer cos : c) { %>
                    <tr id="customer" onclick="findInquiries('<%= cos.getEmail() %>')">
                        <td> <%= cos.getEmail() %> </td>
                        <td> <%= cos.getName() %> </td>
                        <td> <%= cos.getSurname() %> </td>
                        <td> <%= cos.getPhonenumber() %> </td>
                        <td> <%= cos.getAddress() %> </td>
                        <td> <%= cos.getZipcode() %> </td>
                        <td> <%= cos.getCity() %> </td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <div class="col-lg-6">
                
            </div>
        </div>
                
        <script src="${pageContext.request.contextPath}/Scripts/QuickBuildJS.js" type="text/javascript"></script>
        
        
    </body>
</html>
