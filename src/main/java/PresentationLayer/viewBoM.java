/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.Calculator;
import FunctionLayer.Inquiry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mellem
 */
public class viewBoM extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Inquiry inquiry = (Inquiry)request.getAttribute("inquiry");
        BillOfMaterials bom = Calculator.getBillOfMaterials(inquiry);
        
        request.setAttribute("bom", bom);
        
        return "billofmaterials";
    }
    
}
