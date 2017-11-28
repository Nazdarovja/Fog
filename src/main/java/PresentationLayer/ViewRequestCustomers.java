/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mellem
 */
public class ViewRequestCustomers extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List<Customer> c = LogicFacade.viewCustomersByInquiryStatus("ny");
        
        request.setAttribute("customers", c);
        
        return "inquiries";

    }
    
}
