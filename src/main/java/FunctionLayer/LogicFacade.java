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
    public static List<Product> getCategory(String category) throws Exception {
        return ProductMapper.getCategory(category);
    }
    public static Product getSingleProduct(String category, String name) throws Exception {
        return ProductMapper.getSingleProduct(category, name);
    }

    // CALCULATE
    public static BillOfMaterials calculateBillofMaterials(int length, int width, HashMap<String, Product> products) throws Exception {
        return Calculator.getBillOfMaterials(length, width, products);
    }

    public static void SendInquiry(Inquiry inquiry) throws Exception {
        InquiryMapper.registerInitialInquiry(inquiry);
    }
}
