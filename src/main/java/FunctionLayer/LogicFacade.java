/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.CustomerMapper;
import DataLayer.ProductMapper;
import DataLayer.InquiryMapper;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author Orchi
 */
public class LogicFacade {

    //USER 
    public static Customer login(String email, String password, String ipAddress) throws LoginException, Exception {
        return CustomerMapper.login(email, password, ipAddress);
    }

    public static Customer createCostumer(Customer c) throws FogException, Exception {
        return CustomerMapper.createCustomer(c);
    }

    //PRODUCT
    /**
     * Returns a list from the database with Product objects.
     *
     * @return
     * @throws FunctionLayer.FogException
     * @throws Exception
     */
    public static List<Product> getProducts() throws FogException, Exception {
        return ProductMapper.getProducts();
    }

    // CALCULATE
    public static BillOfMaterials calculateBillofMaterials(Inquiry inquiry) throws FogException, Exception {
        return Calculator.getBillOfMaterials(inquiry);
    }

    public static void SendInquiry(Inquiry inquiry) throws FogException, Exception {
        InquiryMapper.registerInitialInquiry(inquiry);
    }

    public static List<Inquiry> viewInquiries() throws FogException, Exception {
        return InquiryMapper.allInquiries();
    }

    public static List[] viewCustomersAndInquiries() throws FogException, Exception {
        List[] list = new List[2];

        list[0] = InquiryMapper.allInquiries();
        list[1] = CustomerMapper.customersWithInquiry();

        return list;
    }

    public static Inquiry viewInquiry(int id) throws FogException, Exception {
        return InquiryMapper.inquiryById(id);
    }

    public static Inquiry viewLatestInquiryByEmail(String customerEmail) throws FogException, Exception {
        return InquiryMapper.LatestInquiryByCustomer(customerEmail);
    }

    public static List<Customer> viewAllCustomers() throws FogException, Exception {
        return CustomerMapper.allCustomers();
    }

    public static Customer viewCustomerByEmail(String email) throws FogException, Exception {
        return CustomerMapper.customerByEmail(email);
    }

    public static List<Customer> viewCustomersByInquiryStatus(String status) throws FogException, Exception {
        switch (status) {
            case "ny":
            case "behandles":
            case "behandlet":
                return CustomerMapper.customersByInquiryStatus(status);
            default:
                throw new FogException(" unknown inquiry status ");
        }
    }

    public static List<Inquiry> getCustomerInquiries(Customer customer) throws FogException, Exception {
        return InquiryMapper.getCustomerInquiries(customer);
    }

    public static Inquiry updateInquiry(int id, int height, int length, int width,
            int shackLength, int shackWidth, String roofType,
            String roofMat, String angle, String comment, String status)
            throws FogException, Exception {
        return InquiryMapper.updateInquiry(id, height, length, width, shackLength, shackWidth, roofType, roofMat, angle, comment, status);
    }

    public static String getRoofMaterials(String roofType) throws FogException, Exception {
        return FormattingUtil.utilDropDownFlat(ProductMapper.getProducts(), roofType);
    }

    public static List<Product> getPitchedRoofProducts() throws FogException, Exception {
        List<Product> products = ProductMapper.getProducts();
        List<Product> res = new ArrayList<>();

        for (Product pro : products) {
            if (pro.getCategory().equals("tagsten") || pro.getCategory().equals("tagpap")) {
                res.add(pro);
            }
        }
        return res;
    }

    public static List<Product> getFlatRoofProducts() throws FogException, Exception {
        List<Product> products = ProductMapper.getProducts();
        List<Product> res = new ArrayList<>();

        for (Product pro : products) {
            if (pro.getCategory().equals("trapeztag") || pro.getCategory().equals("tagpap")) {
                res.add(pro);
            }
        }
        return res;
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

    public static MultiPartEmail generatePDF(Customer customer, Inquiry inquiry, BillOfMaterials bom) throws FileNotFoundException, IOException, EmailException, FogException, InterruptedException {
        return GeneratePDF.createPDF(customer, inquiry, bom);
    }

    public static StringBuilder getSVGFromSide(Inquiry inquiry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static StringBuilder getSVGFromTop(Inquiry inquiry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
