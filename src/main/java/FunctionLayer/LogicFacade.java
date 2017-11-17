/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.CustomerMapper;
import DataLayer.ProductMapper;
import java.util.List;

/**
 *
 * @author Orchi
 */
public class LogicFacade {

    //USER 
    public static Customer login(String email, String password) throws Exception{
        return CustomerMapper.login(email, password);
    }
    
    //PRODUCT
    
    /**
     * Gets a category name parameter and returns a list from the database with Product objects.
     * @param category
     * @return
     * @throws Exception 
     */
    public static List<Product> getCategory(String category) throws Exception {
        return ProductMapper.getCategory(category);
    }
    
    // CALCULATE
    public static BillOfMaterials calculateBillofMaterials(int length, int width, List<Product> stolper) throws Exception{
        return Calculator.getBillOfMaterials(length, width, stolper);
    }
}
