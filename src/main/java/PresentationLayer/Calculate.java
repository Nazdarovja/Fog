/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.LogicFacade;
import FunctionLayer.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stanislav
 */
public class Calculate extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String length1 = (String) request.getAttribute("length");
        int length = Integer.parseInt(length1);
        String width1 = (String) request.getAttribute("width");
        int width = Integer.parseInt(width1);
        
        List<Product> stolper = LogicFacade.getCategory("stolpe");
        BillOfMaterials bom = LogicFacade.calculateBillofMaterials(length, width, stolper);
        
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("bom", bom);
        return "QuickBuild";
    }
    
}
