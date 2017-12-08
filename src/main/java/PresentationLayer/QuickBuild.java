/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Orchi
 */
public class QuickBuild extends Command {

    public QuickBuild() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("lastpage", "QuickBuild");
        HttpSession session = request.getSession();

        request.getSession().setAttribute("lastpage", "QuickBuild");
        String roofMaterialPitched = LogicFacade.getRoofMaterials("rejsning");
        String roofMaterialFlat = LogicFacade.getRoofMaterials("fladt");

        session.setAttribute("roofMaterialPitched", roofMaterialPitched);
        session.setAttribute("roofMaterialFlat", roofMaterialFlat);

        return "QuickBuild";
    }
}
