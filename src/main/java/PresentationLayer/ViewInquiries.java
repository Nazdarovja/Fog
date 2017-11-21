/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

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
        
        List<Inquiry> iList = LogicFacade.viewInquiries();
        request.setAttribute("inquiries", iList);
        
        return "inquiries";
    }
    
}
