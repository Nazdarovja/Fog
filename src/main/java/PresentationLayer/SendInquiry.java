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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class SendInquiry extends Command {

    public SendInquiry() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("lastpage", "QuickBuild");
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        Inquiry inquiry = (Inquiry) request.getSession().getAttribute("inquiry");

        inquiry.setEmail(customer.getEmail());
        inquiry.setStatus("ny");
        
        LogicFacade.SendInquiry(inquiry);
        
        //remove stuff from session
        if (session != null) {
            session.invalidate();
        }
        
        request.getSession().setAttribute("lastpage", "QuickBuild");
        request.getSession().setAttribute("customer", customer);

        return "QuickBuild";
    }

}
