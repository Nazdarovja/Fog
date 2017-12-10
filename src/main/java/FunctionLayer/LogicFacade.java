/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.CustomerMapper;
import DataLayer.ProductMapper;
import DataLayer.InquiryMapper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Orchi
 */
public class LogicFacade {

    //USER 
    public static Customer login(String email, String password) throws LoginException, SQLException, ClassNotFoundException, Exception {
        return CustomerMapper.login(email, password);
    }

    public static Customer createCostumer(Customer c) throws FogException, SQLException,Exception {
        return CustomerMapper.createCustomer(c);
    }

    //PRODUCT
    /**
     * Returns a list from the database with
     * Product objects.
     *
     * @return
     * @throws Exception
     */
    public static List<Product> getProducts() throws SQLException,Exception {
        return ProductMapper.getProducts();
    }

    // CALCULATE
    public static BillOfMaterials calculateBillofMaterials(Inquiry inquiry) throws FogException, SQLException, ClassNotFoundException, Exception {
        return Calculator.getBillOfMaterials(inquiry);
    }

    public static void SendInquiry(Inquiry inquiry) throws SQLException,Exception {
        InquiryMapper.registerInitialInquiry(inquiry);
    }

    public static List<Inquiry> viewInquiries() throws SQLException,Exception {
        return InquiryMapper.allInquiries();
    }

    public static List[] viewCustomersAndInquiries() throws SQLException,Exception {
        List[] list = new List[2];

        list[0] = InquiryMapper.allInquiries();
        list[1] = CustomerMapper.customersWithInquiry();

        return list;
    }

    public static Inquiry viewInquiry(int id) throws FogException, SQLException,Exception {
        return InquiryMapper.inquiryById(id);
    }

    public static Inquiry viewLatestInquiryByEmail(String customerEmail) throws FogException,SQLException,Exception {
        return InquiryMapper.LatestInquiryByCustomer(customerEmail);
    }

    public static List<Customer> viewAllCustomers() throws SQLException,Exception {
        return CustomerMapper.allCustomers();
    }

    public static Customer viewCustomerByEmail(String email) throws FogException,SQLException,Exception {
        return CustomerMapper.customerByEmail(email);
    }

    public static List<Customer> viewCustomersByInquiryStatus(String status) throws FogException,SQLException,Exception {
        switch (status) {
            case "ny":
            case "behandles":
            case "behandlet":
                return CustomerMapper.customersByInquiryStatus(status);
            default:
                throw new FogException(" unknown inquiry status ");
        }
    }

    public static List<Inquiry> getCustomerInquiries(Customer customer) throws SQLException,Exception {
        return InquiryMapper.getCustomerInquiries(customer);
    }

    public static String utilPreviousInquiries(List<Inquiry> inquiriesList) {
        return FormattingUtil.utilPreviousInquiries(inquiriesList);
    }

    public static Inquiry getChosenInquiry(List<Inquiry> inquiries, int inquiryId) {
        for (Inquiry i : inquiries) {
            if (i.getId() == inquiryId) {
                return i;
            }
        }
        return null;
    }

    public static String getRoofMaterials(String roofType) throws SQLException, Exception {
        return FormattingUtil.utilDropDownFlat(ProductMapper.getProducts(), roofType);
        
    }

}
