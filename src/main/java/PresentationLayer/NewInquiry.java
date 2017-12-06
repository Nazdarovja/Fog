/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stanislav
 */
public class NewInquiry extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        
        if (session != null) {
            session.invalidate();
        }
        
        request.getSession().setAttribute("customer", customer);
        return "QuickBuild";
    }

}
