/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.Calculator;
import FunctionLayer.Customer;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class PDF extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String customer = request.getParameter("customer");
        Customer cus = LogicFacade.viewCustomerByEmail(customer);
        Inquiry i = LogicFacade.viewLatestInquiryByEmail(customer);
        Inquiry inquiry = LogicFacade.viewInquiry(i.getId());
        BillOfMaterials bom = Calculator.getBillOfMaterials(inquiry);

        request.setAttribute("generatedPDF", LogicFacade.generatePDF(cus, inquiry, bom)); //TODO if generatedPDF på session, fjern "send pdf" knap fra inquiry.jsp

        request.setAttribute("customer", cus);
        request.setAttribute("bom", bom);
        request.setAttribute("inquiry", i);
        
        return "inquiry"; 
    }

}
