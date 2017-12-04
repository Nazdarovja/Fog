/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.Inquiry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class SendInquiry extends Command {

    public SendInquiry() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        Inquiry i = (Inquiry) request.getSession().getAttribute("inquiry");
        int height = i.getCarportHeight();
        int length = i.getCarportLength();
        int width = i.getCarportWidth();
        String roofType = i.getRoofType();
        String roofMaterial = i.getRoofMaterial();
        String angle = i.getAngle();
        
        Inquiry inquiry = new Inquiry(0, height, length, width, 0, 0, roofType, roofMaterial, angle, null, null, null, "ny", customer.getEmail(), 1, null);
        LogicFacade.SendInquiry(inquiry);
        
        //remove stuff from session
        request.getSession().removeAttribute("inquiry");
        
        return "QuickBuild";
    }

}
