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
 * @author Stanislav
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Customer customer = null;
        if (request.getParameter("email") != null) {
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");
            customer = LogicFacade.login(email, password);
            request.getSession().setAttribute("customer", customer);
        }

        List<Inquiry> inquiriesList = LogicFacade.getCustomerInquiries(customer);
        String inquiries = LogicFacade.utilPreviousInquiries(inquiriesList);
        request.getSession().setAttribute("inquiries", inquiries);
        return "QuickBuild";
    }

}
