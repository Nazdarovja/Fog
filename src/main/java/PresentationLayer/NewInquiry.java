/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.FogException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stanislav
 */
public class NewInquiry extends Command {

    /** before deleting the current session, we pull the customer and the customer's inquiries from the session,
     * creates a new session and sets the customer and the inquiries. The current inquiry is deleted when the session is renewed 
    * returns "QuickBuild"
    * @author Orchi
    */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, Exception {
        HttpSession session = request.getSession(false);
        String inquiries = (String) session.getAttribute("inquiries");
        Customer customer = (Customer) session.getAttribute("customer");
        
        String roofMaterialPitched = (String) session.getAttribute("roofMaterialPitched");
        String roofMaterialFlat = (String) session.getAttribute("roofMaterialFlat");

        if (session != null) {
            session.invalidate();
        }

        request.getSession().setAttribute("roofMaterialPitched", roofMaterialPitched);
        request.getSession().setAttribute("roofMaterialFlat", roofMaterialFlat);
        request.getSession().setAttribute("inquiries", inquiries);
        request.getSession().setAttribute("customer", customer);
        return "QuickBuild";
    }

}
