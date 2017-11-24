/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.CustomerMapper;
import DataLayer.ProductMapper;
import DataLayer.InquiryMapper;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Orchi
 */
public class LogicFacade {

    //USER 
    public static Customer login(String email, String password) throws Exception {
        return CustomerMapper.login(email, password);
    }

    public static Customer createCostumer(Customer c) throws Exception {
        return CustomerMapper.createCustomer(c);
    }

    //PRODUCT
    /**
     * Gets a category name parameter and returns a list from the database with
     * ProductMPrice objects.
     *
     * @param category
     * @return
     * @throws Exception
     */
    public static List<Product> getProducts() throws Exception {
        return ProductMapper.getProducts();
    }

    // CALCULATE
    public static BillOfMaterials calculateBillofMaterials(Inquiry inquiry) throws Exception {
        return Calculator.getBillOfMaterials(inquiry);
    }

    public static void SendInquiry(Inquiry inquiry) throws Exception {
        InquiryMapper.registerInitialInquiry(inquiry);
    }
    
    public static List<Inquiry> viewInquiries() throws Exception{
        return InquiryMapper.allInquiries();
    }
    
    public static List[] viewCustomersAndInquiries() throws Exception{
        List[] list = new List[2];
        
        list[0] = InquiryMapper.allInquiries();
        list[1] = CustomerMapper.customersForInquiries();
        
        return list;
    }
    
    public static Inquiry viewInquiry(int id) throws Exception{
        return InquiryMapper.inquiryById(id);
    }
}
