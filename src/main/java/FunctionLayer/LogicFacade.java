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
    public static List<Product> getCategory(String category) throws Exception {
        return ProductMapper.getCategory(category);
    }

}
