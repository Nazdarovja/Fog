/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mellem
 */
public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Customer c = null;
        
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String name = request.getParameter( "name" );
        String surname = request.getParameter( "surname" );
        int phonenumber = Integer.parseInt(request.getParameter( "phonenumber" ));
        String address = request.getParameter( "address" );
        int zipcode = Integer.parseInt(request.getParameter( "zipcode" ));
        
        if ( password1.equals( password2 ) ) {
            c = LogicFacade.createCostumer( new Customer(email, name, surname, phonenumber, address, zipcode, password1, null ));
            // HttpSession session = request.getSession();
            // session.setAttribute( "user", user );
            return "login";
        } else {
            throw new Exception( "the two passwords did not match" );
        }








    }
    
}
