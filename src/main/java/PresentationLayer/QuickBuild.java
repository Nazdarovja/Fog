/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orchi
 */
public class QuickBuild extends Command {

    public QuickBuild() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute("lastpage", "QuickBuild");
        return "QuickBuild";
    }
}
