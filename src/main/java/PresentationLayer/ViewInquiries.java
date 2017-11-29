/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ML
 */
public class ViewInquiries extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Inquiry> i = LogicFacade.viewInquiries();
        String email = request.getParameter("email");
        
        if (email != null) request.setAttribute("email", email);
        else request.setAttribute("email", "");
        
        request.setAttribute("inquiries", i);
        
        return "inquiries";
    }
    
}
