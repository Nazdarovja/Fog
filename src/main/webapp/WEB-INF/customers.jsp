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
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        
        <link href="${pageContext.request.contextPath}/Style/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        
        <% String idTable = "customertable"; %>
        <% List<Customer> c = (List<Customer>)request.getAttribute("customers"); %>
        
        <div class="topbar">
            <div style="margin: 10px;">
                <form name="viewinquiries" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="viewinquiries">
                    <input type="submit" value="view inquiries" />
                </form>
            </div>
        </div>
        
        <h1>Customers</h1>
        
        <div class="container">
            <div class="toolbar">
                <input type="text" class="searchbar" placeholder="email.." onkeyup="rowSorting('customertable')">
                <input type="text" class="searchbar" placeholder="name.." onkeyup="rowSorting('customertable')">
                <input type="text" class="searchbar" placeholder="surname.." onkeyup="rowSorting('customertable')">
                <input type="text" class="searchbar" placeholder="phonenumber.." onkeyup="rowSorting('customertable')">
                <input type="text" class="searchbar" placeholder="address.." onkeyup="rowSorting('customertable')">
                <input type="text" class="searchbar" placeholder="zipcode.." onkeyup="rowSorting('customertable')">
            </div>
        </div>

        <div class="container">
            <div class="col-lg-12">
                <table class="table table-bordered" id="customertable">
                    <thead>
                        <tr>
                          <th class="sorthead" onclick="sortTable('customertable',0)">
                              <b>Email</b> <i class="fa fa-fw fa-sort"></i>
                              <input type="hidden" class="ascdesc" value="asc">
                          </th>
                          <th class="sorthead" onclick="sortTable('customertable',1)">
                              <b>Name</b> <i class="fa fa-fw fa-sort"></i>
                              <input type="hidden" class="ascdesc" value="asc">
                          </th>
                          <th class="sorthead" onclick="sortTable('customertable',2)">
                              <b>Surname</b> <i class="fa fa-fw fa-sort"></i>
                              <input type="hidden" class="ascdesc" value="asc">
                          </th>
                          <th class="sorthead" onclick="sortTable('customertable',3)">
                              <b>Phonenumber</b> <i class="fa fa-fw fa-sort"></i>
                              <input type="hidden" class="ascdesc" value="asc">
                          </th>
                          <th class="sorthead" onclick="sortTable('customertable',4)">
                              <b>Address</b> <i class="fa fa-fw fa-sort"></i>
                              <input type="hidden" class="ascdesc" value="asc">
                          </th>
                          <th class="sorthead" onclick="sortTable('customertable',5)">
                              <b>Zipcode</b> <i class="fa fa-fw fa-sort"></i>
                              <input type="hidden" class="ascdesc" value="asc">
                          </th>
                          <th class="sorthead" onclick="sortTable('customertable',6)">
                              <b>City</b> <i class="fa fa-fw fa-sort"></i>
                              <input type="hidden" class="ascdesc" value="asc">
                          </th>
                        </tr>
                    </thead>
                    <% for (Customer cos : c) { %>
                    <tr class="clickablerow" onclick="findInquiriesByEmail('<%= cos.getEmail() %>')">
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
                
        <script src="${pageContext.request.contextPath}/Scripts/script.js" type="text/javascript"></script>
    </body>
</html>
