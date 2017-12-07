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
        <h1>Forespørgelses oversigt</h1>
        
        <% Inquiry i = (Inquiry)request.getAttribute("inquiry"); %>
        <% BillOfMaterials bom = (BillOfMaterials)request.getAttribute("bom"); %>
        <% Customer cus = (Customer)request.getAttribute("customer"); %>
        
        <div class="container">
            <div class="col-lg-6" style="margin-right: 10%">
                <h2>Forespørgelse</h2>
                <table class="table table-bordered">
                    <tr>
                        <th>Carport højde</th>
                        <td>
                            <select class="form-control" name="height">
                                <% int height = i.getCarportHeight(); %>
                                <option value=210 <%if (height == 210) { %> selected <%} %>>210</option>
                                <option value=240 <%if (height == 240) { %> selected <%} %>>240</option>
                                <option value=270 <%if (height == 270) { %> selected <%} %>>270</option>
                                <option value=300 <%if (height == 300) { %> selected <%} %>>300</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Caport længde</th>
                        <td> 
                            <select class="form-control" name="length" id="length" >
                                <% int length = i.getCarportLength(); %>
                                <option value=240 <%if (length == 240) { %> selected <%} %>>240</option>
                                <option value=270 <%if (length == 270) { %> selected <%} %>>270</option>
                                <option value=300 <%if (length == 300) { %> selected <%} %>>300</option>
                                <option value=330 <%if (length == 330) { %> selected <%} %>>330</option>
                                <option value=360 <%if (length == 360) { %> selected <%} %>>360</option>
                                <option value=390 <%if (length == 390) { %> selected <%} %>>390</option>
                                <option value=420 <%if (length == 420) { %> selected <%} %>>420</option>
                                <option value=450 <%if (length == 450) { %> selected <%} %>>450</option>
                                <option value=480 <%if (length == 480) { %> selected <%} %>>480</option>
                                <option value=510 <%if (length == 510) { %> selected <%} %>>510</option>
                                <option value=540 <%if (length == 540) { %> selected <%} %>>540</option>
                                <option value=570 <%if (length == 570) { %> selected <%} %>>570</option>
                                <option value=600 <%if (length == 600) { %> selected <%} %>>600</option>
                                <option value=630 <%if (length == 630) { %> selected <%} %>>630</option>
                                <option value=660 <%if (length == 660) { %> selected <%} %>>660</option>
                                <option value=690 <%if (length == 690) { %> selected <%} %>>690</option>
                                <option value=720 <%if (length == 720) { %> selected <%} %>>720</option>
                                <option value=750 <%if (length == 750) { %> selected <%} %>>750</option>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <th>Carport bredde</th>
                        <td> 
                            <select class="form-control" id="width" name="width">
                                <% int width = i.getCarportWidth(); %>
                                <option value=240 <%if (width == 240) { %> selected <%} %>>240</option>
                                <option value=270 <%if (width == 270) { %> selected <%} %>>270</option>
                                <option value=300 <%if (width == 300) { %> selected <%} %>>300</option>
                                <option value=330 <%if (width == 330) { %> selected <%} %>>330</option>
                                <option value=360 <%if (width == 360) { %> selected <%} %>>360</option>
                                <option value=390 <%if (width == 390) { %> selected <%} %>>390</option>
                                <option value=420 <%if (width == 420) { %> selected <%} %>>420</option>
                                <option value=450 <%if (width == 450) { %> selected <%} %>>450</option>
                                <option value=480 <%if (width == 480) { %> selected <%} %>>480</option>
                                <option value=510 <%if (width == 510) { %> selected <%} %>>510</option>
                                <option value=540 <%if (width == 540) { %> selected <%} %>>540</option>
                                <option value=570 <%if (width == 570) { %> selected <%} %>>570</option>
                                <option value=600 <%if (width == 600) { %> selected <%} %>>600</option>
                                <option value=630 <%if (width == 630) { %> selected <%} %>>630</option>
                                <option value=660 <%if (width == 660) { %> selected <%} %>>660</option>
                                <option value=690 <%if (width == 690) { %> selected <%} %>>690</option>
                                <option value=720 <%if (width == 720) { %> selected <%} %>>720</option>
                                <option value=750 <%if (width == 750) { %> selected <%} %>>750</option>
                                <option value=780 <%if (width == 780) { %> selected <%} %>>780</option>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <th>Skur længde</th>
                        <td> <%= i.getShackLength() %> </td>
                    </tr>
                    <tr>
                        <th>Skur bredde</th>
                        <td> <%= i.getShackWidth() %> </td>
                    </tr>
                    <tr>
                        <th>Tagtype</th>
                        <td> 
                            <% String tagtype = i.getRoofType(); %>
                            <select class="form-control" name="tagtype">
                                <option value="rejsning" <% if(tagtype.equals("rejsning")) { %> selected <% } %> >Rejsning</option>
                                <option value="fladt" <% if(tagtype.equals("fladt")) { %> selected <% } %> >Fladt</option>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <th>Taghældning (hvis "rejsning")</th>
                        <td>
                            <select class="form-control" name="angle" >
                                <% int angle = -1;
                                    if (request.getSession().getAttribute("angle") != null) {
                                        angle = Integer.parseInt(i.getAngle());
                                    }
                                %>
                                <option value=15 <%if (angle == 15) { %> selected <%} %>>15°</option>
                                <option value=20 <%if (angle == 20) { %> selected <%} %>>20°</option>
                                <option value=25 <%if (angle == 25) { %> selected <%} %>>25°</option>
                                <option value=30 <%if (angle == 30) { %> selected <%} %>>30°</option>
                                <option value=35 <%if (angle == 35) { %> selected <%} %>>35°</option>
                                <option value=40 <%if (angle == 40) { %> selected <%} %>>40°</option>
                                <option value=45 <%if (angle == 45) { %> selected <%} %>>45°</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Kommentar ansat</th>
                        <td><textarea  class="form-control" style="resize: none"><% if(i.getCommentEmployee() != null) { %><%= i.getCommentEmployee() %><% } %></textarea></td>
                    </tr>
                    <tr>
                        <th>Kommentar kunde</th>
                        <td><%= i.getCommentCustomer() %></td>
                    </tr>
                    <tr>
                        <th>Ønsket levering til</th>
                        <td> <%= i.getPeriod() %> </td>
                    </tr>
                    <tr>
                        <th>Status</th>
                        <td> 
                        <% String status = i.getStatus(); %>
                        <select class="form-control" name="status">
                            <option value="ny" <% if(status.equals("ny")) { %> selected <% } %> >Ny</option>
                            <option value="behandles" <% if(status.equals("behandles")) { %> selected <% } %> >Behandles</option>
                            <option value="behandlet" <% if(status.equals("behandlet")) { %> selected <% } %> >Behandlet</option>
                        </select> 
                        </td> 
                    </tr>
                    <tr>
                        <th>Behandles af</th>
                        <td> <%= i.getId_employee() %> </td>
                    </tr>
                    <tr>
                        <th>Forespørgelse afsendt den</th>
                        <td> <%= i.getDate() %> </td>
                    </tr>
                </table>
            </div>
            
            <div class="col-lg-4">
                <h2>Kunde info</h2>
                <table class="table table-bordered">
                    <tr>
                        <th>Email</th>
                        <td> <%= cus.getEmail() %> </td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td> <%= cus.getName() %> </td>
                    </tr>
                    <tr>
                        <th>Surname</th>
                        <td> <%= cus.getSurname() %> </td>
                    </tr>
                    <tr>
                        <th>Phonenumber</th>
                        <td> <%= cus.getPhonenumber() %> </td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td> <%= cus.getAddress() %> </td>
                    </tr>
                    <tr>
                        <th>Zipcode</th>
                        <td> <%= cus.getZipcode() %> </td>
                    </tr>
                </table>
                    
                <h2>Muligheder</h2>
                <legend style="margin: 10px">
                    <input type="submit" value="Updater Forespørgelse" name="update" style="margin: 10px">   
                    <input type="submit" value="Genere PDF af stykliste" name="generate" style="margin: 10px">   
                </legend>
                    
                    
            </div>

            
        </div>
        <br><br>
        
        
        <div class="row">
            <h2 style="margin-left: 45%"> Stykliste </h2>
            <div class="middlediv">
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
            </div>
        </div>
    </body>
</html>
