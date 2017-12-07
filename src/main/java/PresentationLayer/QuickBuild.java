/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orchi
 */
public class QuickBuild extends Command {

    public QuickBuild() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute("lastpage", "QuickBuild");
        if(request.getParameter("email") != null) {
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");
            Customer customer = LogicFacade.login(email, password);
            request.getSession().setAttribute("customer", customer);
        }
        return "QuickBuild";
    }
}
