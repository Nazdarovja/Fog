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
public class ViewCustomers extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Customer> cl = LogicFacade.viewAllCustomers();
        String tableTagId = "customertable";
        String customerTable = JspUtilTable.tableCustomer(tableTagId, cl);
        
        request.setAttribute("customertable", customerTable);
        request.setAttribute("customers", cl); // not used..
        
        return "customers";
    }
    
}
