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
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class Login extends Command {

    public Login() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "login";
    }

//        @Override
//    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegohusException {
//        String email = request.getParameter( "email" );
//        String password = request.getParameter( "password" );
//        User user = LogicFacade.login( email, password );
//        HttpSession session = request.getSession();
//        session.setAttribute( "user", user );
//        session.setAttribute( "role", user.getRole() );
//        return user.getRole() + "page";
}
