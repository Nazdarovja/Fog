/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import static DataLayer.InquiryMapper.inquiryById;
import FunctionLayer.BillOfMaterials;
import FunctionLayer.Calculator;
import FunctionLayer.Customer;
import FunctionLayer.Inquiry;
import FunctionLayer.LogicFacade;
import FunctionLayer.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class PDF extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String customer = request.getParameter("customer");
        Customer cus = LogicFacade.viewCustomerByEmail(customer);
        int id = Integer.parseInt(request.getParameter("id"));
        Inquiry inquiry = LogicFacade.viewInquiry(id);
        BillOfMaterials bom = Calculator.getBillOfMaterials(inquiry);
        List<Product> flatMat, pitchedMat;

        flatMat = LogicFacade.getFlatRoofProducts();
        pitchedMat = LogicFacade.getPitchedRoofProducts();

        request.setAttribute("generatedPDF", LogicFacade.generatePDF(cus, inquiry, bom)); //TODO if generatedPDF på session, fjern "send pdf" knap fra inquiry.jsp
        request.setAttribute("pitchedMat", pitchedMat);
        request.setAttribute("flatMat", flatMat);
        request.setAttribute("customer", cus);
        request.setAttribute("bom", bom);
        request.setAttribute("inquiry", inquiry);
        request.setAttribute("id", id);
        

        return "inquiry";
    }

}
