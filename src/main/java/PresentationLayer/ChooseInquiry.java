/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BillOfMaterials;
import FunctionLayer.Customer;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stanislav
 */
public class ChooseInquiry extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Customer customer = (Customer)session.getAttribute("customer");
        List<Inquiry> inquiries = LogicFacade.getCustomerInquiries(customer);
        int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));
        Inquiry inquiry = LogicFacade.getChosenInquiry(inquiries, inquiryId);

        //Set Attributes to the chosen inquiry Attributes.
        //int id, int carportHeight, int carportLength, int carportWidth, int shackWidth, int shackLength, String roofType, String angle, 
        //String commentCustomer, Date period
        session.setAttribute("height", inquiry.getCarportHeight());
        session.setAttribute("length", inquiry.getCarportLength());
        session.setAttribute("width", inquiry.getCarportWidth());
        session.setAttribute("shackWidth", inquiry.getShackWidth());
        if(inquiry.getShackWidth() > 0){
            session.setAttribute("shackCheckbox", "on");
        }
        session.setAttribute("shackLength", inquiry.getShackLength());
        session.setAttribute("roofType", inquiry.getRoofType());
        session.setAttribute("angle", inquiry.getAngle());
        session.setAttribute("comment", inquiry.getCommentCustomer());
        if(inquiry.getPeriod() != null) {
        session.setAttribute("wishedDelivery", inquiry.getPeriod().getYear()+"-"+inquiry.getPeriod().getMonth()+"-"+inquiry.getPeriod().getDate());
        }
        BillOfMaterials bom = LogicFacade.calculateBillofMaterials(inquiry);
        inquiry.setBom(bom);
        inquiry.setId(0);
        session.setAttribute("inquiry", inquiry);
        
        return "QuickBuild";
    }

}
