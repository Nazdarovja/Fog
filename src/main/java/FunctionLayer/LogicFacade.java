/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.CustomerMapper;

/**
 *
 * @author Orchi
 */
public class LogicFacade {

    //USER 
    public static Customer login(String email, String password) throws Exception{
        return CustomerMapper.login(email, password);
    }

}
