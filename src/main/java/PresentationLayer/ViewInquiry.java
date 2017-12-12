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
import FunctionLayer.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mellem
 */
public class ViewInquiry extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, Exception {

        String customer = request.getParameter("customer");
        Inquiry i = LogicFacade.viewLatestInquiryByEmail(customer);
        Inquiry inquiry = LogicFacade.viewInquiry(i.getId());
        BillOfMaterials bom = Calculator.getBillOfMaterials(inquiry);
        List<Product> flatMat, pitchedMat, neutralMat;

        flatMat = LogicFacade.getFlatRoofProducts();
        pitchedMat = LogicFacade.getPitchedRoofProducts();
        
        request.setAttribute("pitchedMat", pitchedMat);
        request.setAttribute("flatMat", flatMat);
        request.setAttribute("customer", LogicFacade.viewCustomerByEmail(customer));
        request.setAttribute("bom", bom);
        request.setAttribute("inquiry", i);
        
        return "inquiry";
    }
    
}
