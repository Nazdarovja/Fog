/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.Calculator;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mellem
 */
public class ViewLatestInquiry extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, Exception {

        String customer = request.getParameter("customer");
        Inquiry i = LogicFacade.viewLatestInquiryByEmail(customer);
        Inquiry inquiry = LogicFacade.viewInquiry(i.getId());
        BillOfMaterials bom = Calculator.getBillOfMaterials(inquiry);
        
        System.out.println(bom.getMaterials().get(0).getProductName());
        
        request.setAttribute("bom", bom);
        request.setAttribute("inquiry", i);
        
        return "inquiry";
    }
    
}
