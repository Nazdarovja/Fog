/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author Orchi
 */
public class Calculator {
    
    public BillOfMaterials getBillOfMaterials(int height, int length, int width, String type) throws Exception {
        List<Product> stolper = LogicFacade.getCategory("stolpe");
        BillOfMaterials bom = new BillOfMaterials();
        
        int stolpeAntal = 1;
        //UDHÆNG TIL FRONTEN OG BAGENDEN AF SKURET (INGEN STOLPE)
        length += -130;

        // Placerer en stolpe pr. 3,10m  
        stolpeAntal = length /310;
        // Ganger med to så der er stolper til begge sider
        stolpeAntal *=  2;
        bom.addOrderLine(new OrderLine(stolper.get(0), stolpeAntal));
        return bom;
    }
}
