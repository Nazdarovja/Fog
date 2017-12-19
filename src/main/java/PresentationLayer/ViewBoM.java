/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.Calculator;
import FunctionLayer.FogException;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Get id from request and use it to get Inquiry, then Calculate BillOfMaterials from it. 
 * Set BillOfMaterials on request
 * @author Mellem
 */
public class ViewBoM extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));

        Inquiry inquiry = LogicFacade.viewInquiry(id);
        BillOfMaterials bom = Calculator.getBillOfMaterials(inquiry);
        // NEEDS CHANGING 

        request.setAttribute("bom", bom);

        return "billofmaterials";
    }

}
