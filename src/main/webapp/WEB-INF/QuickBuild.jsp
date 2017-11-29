<%@page import="FunctionLayer.Inquiry"%>
<%@page import="FunctionLayer.BillOfMaterials"%>
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
        <title>Quick Byg</title>
    </head>
    <body>

        <div class="row">
            <h1 class="col-sm-6 col-sm-offset-3">Hejsa, vælg dine mål til din kommende carport!</h1>
            <% Customer customer = null;
                if ((customer = (Customer) request.getSession().getAttribute("customer")) != null) {%>
            <div class="col-sm-1 col-sm-offset-2" style="background: green; color: white;">
                <p>Hello <%= customer.getName()%>, start buying!!! </p>
            </div>
            <% } else {%>
            <div class="col-sm-1 col-sm-offset-2" style="background: beige;">
                <p>click <a href="FrontController?command=login">here</a> to log in!</p>

                <p>click <a href="FrontController?command=toregister">here</a> to register!</p>
            </div>
            <% } %>
        </div>
        <div id="measurements" >
            <div class="row ">

                <form name="order" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="calculate">
                    <div class="col-sm-2 col-sm-offset-2">
                        Vælg længde<br>
                        <select class="form-control" name="length" id="length" >
                            <% int length = 0;
                                if (request.getSession().getAttribute("length") != null) {
                                    length = (int) request.getSession().getAttribute("length");
                                }
                            %>
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
                        <br>
                        <br>
                    </div>
                    <div class="col-sm-2 col-sm-offset-1">
                        Vælg bredde<br>
                        <select class="form-control" id="width" name="width">
                            <% int width = 0;
                                if (request.getSession().getAttribute("width") != null) {
                                    width = (int) request.getSession().getAttribute("width");
                                }
                            %>
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
                    <br>
                    <br>
                    </div>

                    <div class="col-sm-2 col-sm-offset-1">
                        Vælg højde<br>
                        <select class="form-control" name="height">
                            <% int height = 0;
                                if (request.getSession().getAttribute("height") != null) {
                                    height = (int) request.getSession().getAttribute("height");
                                }
                            %>
                            <option value=210 <%if (height == 210) { %> selected <%} %>>210</option>
                            <option value=240 <%if (height == 240) { %> selected <%} %>>240</option>
                            <option value=270 <%if (height == 270) { %> selected <%} %>>270</option>
                            <option value=300 <%if (height == 300) { %> selected <%} %>>300</option>
                        </select>
                    <br>
                    <br>
                    </div>
            </div>

            <div class="row">
                <div class="col-sm-2 col-sm-offset-1">
                    Vælg tagtype<br>
                        <input id="roofTypeCheck" type="hidden" value="<% if (request.getSession().getAttribute("roofType") != null) { %><%=(String)request.getSession().getAttribute("roofType")%><%}%>">
                    <select class="form-control" name="roofType">
                        <% String roofType = "";
                            if (request.getSession().getAttribute("roofType") != null) {
                                roofType = (String) request.getSession().getAttribute("roofType");
                            }
                        %>
                        <option value="fladt" <%if (roofType.equals("fladt")) { %> selected <%} %>>fladt</option>
                        <option value="rejsning" <%if (roofType.equals("rejsning")) { %> selected <%} %>>rejsning</option>
                    </select>

                    <div >
                        <div id="angle">
                            Vælg hældning<br>
                            <select class="form-control" name="angle" >
                                <% int angle = -1;
                                    if (request.getSession().getAttribute("angle") != null) {
                                        angle = Integer.parseInt((String) request.getSession().getAttribute("angle"));
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
                        </div>
                    </div>
                </div>
                            
                            
                            <div class="col-sm-6 text-center lead" > <br><br><br><br><br>ADD SVG HERE </div>
                            
                            
                <div class="col-sm-2">
                    Tilvælg redskabsrum<br>
                    <input id="shackCheckbox" name="shackCheckbox" type="checkbox"/>
                    <input id="shackCheckboxCheck" name="shackCheckboxCheck" type="hidden"  value="<% if((String)request.getSession().getAttribute("shackCheckbox") != null) {%>on<%}%>">

                    <div id="shackLength" >
                        Redskabsrum Længde<br>
                        <input id="shackLengthInput" type="number" min="100" max="120" class="form-control" name="shackLength" value="<% if (request.getSession().getAttribute("shackLength") != null) { %><%= (int) request.getSession().getAttribute("shackLength")%><%}%>">
                    </div>
                    <div id="shackWidth" >
                        Redskabsrum Bredde<br>
                        <input id="shackWidthInput" type="number" min="100" max="240" class="form-control" name="shackWidth" value="<% if (request.getSession().getAttribute("shackWidth") != null) { %><%= (int) request.getSession().getAttribute("shackWidth")%><%}%>">
                    </div>
                </div>
            </div>
                            
            <div class="row">
                <div class="col-sm-2 col-sm-offset-9 well">
                    <% if (request.getSession().getAttribute("inquiry") != null) {  %>
                    <% Inquiry inquiry = (Inquiry) request.getSession().getAttribute("inquiry");%>
                    TOTAL PRIS: <br>
                    <%= inquiry.getBom().getTotalPrice()%>,-
                    <Br>
                    <%}%>

                    <input class="btn btn-default" type="submit" value="Calculate"/>
                </div>
            </div>
        </form>

        <!--if user is logged in and has made a calculation-->
        <%if (customer != null && request.getSession().getAttribute("inquiry") != null) {%>  
        <p>Send forespørgsel til Fog?</p>

        <form name="sendinquiry" action="FrontController" method="POST">
            <input type="hidden" name="command" value="sendinquiry">
            <input onclick="confirmFunction()" type="submit" value="Send forespørgsel"/>
        </form>

        <% }%>
        <script src="../Scripts/QuickBuildJS.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script src="Scripts/QuickBuildJS.js" type="text/javascript"></script>
</body>
</html>
