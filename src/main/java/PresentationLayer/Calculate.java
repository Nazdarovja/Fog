/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import FunctionLayer.Product;
import java.util.HashMap;
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
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        
        Inquiry inquiry = new Inquiry(0, 0, length, width, 0, 0, "input rooftype variable", " input angle variable", null, null, null, "ny", null, 1);
        BillOfMaterials bom = LogicFacade.calculateBillofMaterials(inquiry);
        inquiry.setBom(bom);
        
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("inquiry", inquiry);
        return "QuickBuild";
    }
}
