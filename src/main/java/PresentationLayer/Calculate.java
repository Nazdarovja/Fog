/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
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
        String angle = null;
        if(roofType != null) {
        angle = request.getParameter("angle");
        }
        String shackCheckbox;
        int shackLength = 0;
        int shackWidth = 0;
        shackCheckbox = request.getParameter("shackCheckbox");
        if(shackCheckbox != null){
        shackLength = Integer.parseInt(request.getParameter("shackLength"));
        shackWidth = Integer.parseInt(request.getParameter("shackWidth"));
        }
        System.out.println(shackCheckbox);

        Inquiry inquiry = new Inquiry(0, height, length, width, shackWidth, shackLength, roofType, angle, null, null, null, "ny", null, 1);
        BillOfMaterials bom = LogicFacade.calculateBillofMaterials(inquiry);
        inquiry.setBom(bom);
        
        session.setAttribute("shackLength", shackLength);
        session.setAttribute("shackWidth", shackWidth);
        session.setAttribute("shackCheckbox", shackCheckbox);
        session.setAttribute("height", height);
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("angle", angle);
        session.setAttribute("roofType", roofType);
        session.setAttribute("inquiry", inquiry);
        return "QuickBuild";
    }
}
