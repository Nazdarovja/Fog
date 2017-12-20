/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stanislav
 */
public class SaveInquiry extends Command {

    /** Used to save a inquiry on the database, so the customer can see his previous saved inquiries.
    * returns "QuickBuild"
    * @author Orchi
    */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        Inquiry inquiry = (Inquiry) request.getSession().getAttribute("inquiry");
        
        inquiry.setEmail(customer.getEmail());
        inquiry.setStatus("gemt");
        LogicFacade.SendInquiry(inquiry);

        return "QuickBuild";
    }

}
