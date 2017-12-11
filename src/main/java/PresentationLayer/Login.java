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
import FunctionLayer.LoginException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stanislav
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, LoginException, Exception{
        request.setAttribute("lastpage", "QuickBuild");
        Customer customer = null;
        if (request.getParameter("email") != null) {
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");
            String ipAddress = request.getRemoteAddr();
            customer = LogicFacade.login(email, password, ipAddress);
            request.getSession().setAttribute("customer", customer);
        }

        List<Inquiry> inquiriesList = LogicFacade.getCustomerInquiries(customer);
        String inquiries = LogicFacade.utilPreviousInquiries(inquiriesList);
        request.getSession().setAttribute("inquiries", inquiries);
        
        String roofMaterialPitched = LogicFacade.getRoofMaterials("rejsning");
        String roofMaterialFlat = LogicFacade.getRoofMaterials("fladt");
        return "QuickBuild";
    }

}
