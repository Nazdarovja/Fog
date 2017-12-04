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
        <link href="./Style/quickbuild.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="./img/foglogo.png"/>
        <title>Quick Byg</title>
    </head>
    <body>
        <div class="row">
            <img class="col-sm-3" style="margin-right: 0px; padding-right: 0px;" src="./img/johannesfog.jpg" alt="johannesfog" >
            <h1 class="col-sm-6 well text-center bg-primary text-white" style=" background:#124989; margin-top: 1px; margin-right: 0px; margin-bottom: 0px; padding-top: 30px; padding-bottom: 35px">Quick Byg</h1>
            <% Customer customer = null;
                if ((customer = (Customer) request.getSession().getAttribute("customer")) != null) {%>
            <h1 class="col-sm-3 well text-center bg-primary text-white" style=" background:#124989; margin-top: 1px; margin-right: 0px; margin-bottom: 0px; padding-top: 30px; padding-bottom: 35px">Hello <%= customer.getName()%></h1>
            <%--href="FrontController?command=login"--%>
        </div>
        <% } else {%>
        <div class="col-sm-3 well" style="background:#124989; margin-left: 0px; padding-top: 18px; padding-bottom: 8px;">
            <p class="text-right" style="margin-right: 42px"><a class="btn btn-sm btn-default"  data-toggle="modal" data-target="#login" >  Login  </a></p>
            <p class="text-right"><a class="btn btn-sm btn-default" data-toggle="modal" data-target="#registerUser">Register here</a></p>
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
                <input id="roofTypeCheck" type="hidden" value="<% if (request.getSession().getAttribute("roofType") != null) {%><%=(String) request.getSession().getAttribute("roofType")%><%}%>">
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


                <!--TAGMATERIALE - doesnt change correctly -->
                <input id="roofMaterialTypeCheck" type="hidden" value="<% if (request.getSession().getAttribute("roofMaterialType") != null) {%><%=(String) request.getSession().getAttribute("roofMaterialType")%><%}%>">
                Vælg tag materiale
                <select class="form-control" name="roofMaterialType">
                    <% String roofMaterialType = "";
                        if (request.getSession().getAttribute("roofMaterialType") != null) {
                            roofMaterialType = (String) request.getSession().getAttribute("roofMaterialType");
                        }
                    %>

                    <!--doesnt change at all-->
                    <% if (roofType.equals("fladt")) {%>
                    <option value="tagpap"<%if (roofMaterialType.equals("tagpap")) { %> selected <%} %>>tagpap</option>
                    <option value="trapeztag"<%if (roofMaterialType.equals("trapeztag")) { %> selected <%} %>>trapeztag</option>
                    <%} else {%>
                    <option value="tagpap"<%if (roofMaterialType.equals("tagpap")) { %> selected <%} %>>tagpap</option>
                    <option value="tagsten"<%if (roofMaterialType.equals("tagsten")) { %> selected <%} %>>tagsten</option>
                    <%}%>
                </select>




            </div>

            <div id="svg" class="col-sm-6 text-center lead" >
                <% if (request.getSession().getAttribute("svg") != null) {
                        String svg = (String) request.getSession().getAttribute("svg");%>
                <%= svg%>
                <% } %>
            </div>

            <div class="col-sm-2">
                Tilvælg redskabsrum<br>
                <input id="shackCheckbox" name="shackCheckbox" type="checkbox"/>
                <input id="shackCheckboxCheck" name="shackCheckboxCheck" type="hidden"  <% if ((String) request.getSession().getAttribute("shackCheckbox") != null) {%>value="on"<%}%>>

                <div id="shackLength" >
                    Redskabsrum Længde<br>
                    <input id="shackLengthInput" type="number" min="100" max="120" class="form-control" name="shackLength" value="<% if (request.getSession().getAttribute("shackLength") != null) {%><%= (int) request.getSession().getAttribute("shackLength")%><%}%>">
                </div>
                <div id="shackWidth" >
                    Redskabsrum Bredde<br>
                    <input id="shackWidthInput" type="number" min="100" max="240" class="form-control" name="shackWidth" value="<% if (request.getSession().getAttribute("shackWidth") != null) {%><%= (int) request.getSession().getAttribute("shackWidth")%><%}%>">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2 col-sm-offset-9 well bg-primary text-white" style=" background:#124989">
                <% if (request.getSession().getAttribute("inquiry") != null) {  %>
                <% Inquiry inquiry = (Inquiry) request.getSession().getAttribute("inquiry");%>
                TOTAL PRIS: <br>
                <%= inquiry.getBom().getTotalPrice()%>,-
                <Br>
                <%}%>

                <input class="btn btn-default"  type="submit" value="Beregn"/>
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

    <%----------------------------------------------------------------------------------------------%>
    <%-- MODAL FOR LOGIN AND REGISTER --%>
    <%----------------------------------------------------------------------------------------------%>
    <div class="container">
        <div class="row">

            <!-- Modal Register -->
            <form action="FrontController" method="post" id="registration" name="registration" >
                <div class="modal fade" id="registerUser" tabindex="-1" role="dialog" aria-labelledby="registerModal" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Luk</span></button>
                                <h4 class="modal-title" id="myModalLabel">Registrer</h4>
                            </div>

                            <div class="modal-body form-inline">
                                <div class="form-group has-feedback">
                                    <label class="control-label" for="emaillabel">* Email adresse</label>
                                    <input name="email" type="email" class="form-control"  id="emailinput" aria-describedby="emailinput" required="">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label" for="passwordlabel">* Password</label>
                                    <input name="password1" type="password" class="form-control" id="password1" aria-describedby="passwordinput" required="">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label" for="re-enterpasswordlabel">* Gentag password</label>
                                    <input name="password2" type="password" class="form-control" id="password2" aria-describedby="re-enterpasswordinput" required="">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label" for="postcodelabel">* Postnummer</label>
                                    <input name="zipcode" type="number" class="form-control" id="postcodeinput" aria-describedby="postcodeinput">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label" for="firstnamelabel">* Fornavn</label>
                                    <input name="name" type="text" class="form-control" id="firstnameinput" aria-describedby="firstnameinput" required="">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label" for="lastnamelabel">* Efternavn</label>
                                    <input name="surname" type="text" class="form-control" id="lastnameinput" aria-describedby="lastnameinput" required="">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label" for="phonenumber">* Tlf. nummer</label>
                                    <input name="phonenumber" type="number" class="form-control" id="phonenumber" aria-describedby="phonenumber" required="">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label" for="address">* Adresse</label>
                                    <input name="address" type="text" class="form-control" id="address" aria-describedby="address" required="">
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <br/>

                                <div class="form-group">
                                    <input  type="hidden" name="command" value="register">
                                    <button type="submit" class="btn btn-primary">Registrer</button>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </form>

            <%----------------------------------------------------------------------------------------------%>
            <!-- Modal Login form -->
            <form id="logingform" action="FrontController" method="post">
                <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="LoginModal" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Login</h4>
                            </div>

                            <div class="modal-body">
                                <div class="form-group has-feedback">
                                    <label class="control-label">Email</label>
                                    <input name="email" type="email" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status" placeholder="Email" required>
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label">Password</label>
                                    <input name="password" type="password" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status" placeholder="Password" required >
                                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                </div>

                                <input type="hidden" name="command" value="QuickBuild">
                                <button type="sumbit" class="btn btn-primary">Login</button>

                            </div>

                            <div class="modal-footer">
                                <h4 class="modal-title" id="myModalLabel">Register</h4>
                                Hvis du ikke allerede er medlem så  <a data-toggle="modal" data-target="#registerUser" data-dismiss="modal"> Registrer dig her</a>
                                <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>-->
                            </div>

                        </div>
                    </div>
                </div>
            </form> 

        </div>
    </div>


    <!-- Latest compiled JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="./Scripts/QuickBuildJS.js" type="text/javascript"></script>
</body>
</html>
