/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.GenerateSVG;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Stanislav
 */
public class Calculate extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        String roofType = request.getParameter("roofType");
        String roofMaterial = request.getParameter("roofMaterial");
        String angle = request.getParameter("angle");
        String comment = request.getParameter("comment");
        String wishedDelivery = request.getParameter("wishedDelivery");
        System.out.println(wishedDelivery);
        Date wishDeliveryDate = null;
        if (wishedDelivery.length() > 1) {
            wishDeliveryDate = new Date(Integer.parseInt(wishedDelivery.substring(0, 4))-1900, Integer.parseInt(wishedDelivery.substring(5, 7))-1, Integer.parseInt(wishedDelivery.substring(8)));
        }
        String shackCheckbox = null;
        int shackLength = 0;
        int shackWidth = 0;
        shackCheckbox = request.getParameter("shackCheckbox");
        boolean withShack = false;
        if (request.getParameter("shackCheckbox") != null && request.getParameter("shackCheckbox").equals("on")) {
            withShack = true;
            shackLength = Integer.parseInt(request.getParameter("shackLength"));
            shackWidth = Integer.parseInt(request.getParameter("shackWidth"));
            session.setAttribute("shackLength", shackLength);
            session.setAttribute("shackWidth", shackWidth);
        }

        Inquiry inquiry = new Inquiry(0, height, length, width, shackWidth, shackLength, roofType, roofMaterial, angle, comment, null, wishDeliveryDate, "", null, 1, null);
        BillOfMaterials bom = LogicFacade.calculateBillofMaterials(inquiry);
        inquiry.setBom(bom);

        String SVG = GenerateSVG.generateSVGHTML(length, width, withShack, shackWidth, shackLength, roofType, Integer.parseInt(angle));

        session.setAttribute("svg", SVG);
        session.setAttribute("shackCheckbox", shackCheckbox);
        session.setAttribute("height", height);
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("angle", angle);
        session.setAttribute("comment", comment);
        session.setAttribute("wishedDelivery", wishedDelivery);
        session.setAttribute("roofType", roofType);
        session.setAttribute("roofMaterial", roofMaterial);
        session.setAttribute("inquiry", inquiry);
        return "QuickBuild";
    }
}
