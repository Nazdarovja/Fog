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
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, Exception {
        List<Inquiry> i = LogicFacade.viewInquiries();
        String email = request.getParameter("email");
        String tableTagId = "inquirytabel";
        String inquiryTable = JspUtilTable.tableInquiry(tableTagId, i);
        
        if (email != null) request.setAttribute("email", email);
        else request.setAttribute("email", "");
        
        request.setAttribute("tableTagId", tableTagId);
        request.setAttribute("inquirytable", inquiryTable);
        request.setAttribute("inquiries", i); // not used..
        
        return "inquiries";
    }
    
}
