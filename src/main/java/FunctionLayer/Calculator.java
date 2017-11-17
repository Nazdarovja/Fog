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
    
    public static BillOfMaterials getBillOfMaterials(int length, int width, List<Product> stolper) throws Exception {
        BillOfMaterials bom = new BillOfMaterials();
        
        int stolpeAntal = 1;
        //UDHÆNG TIL FRONTEN OG BAGENDEN AF SKURET (INGEN STOLPE)
        length += -130;

        // Placerer en stolpe pr. 3,10m  
        stolpeAntal = length / 310;
        
        //Placerer en ekstra stolpe hvis der er over eller præcis 1m tilovers.
        if(length % 310 >= 100){
            stolpeAntal += 1;
        }
        
        // Ganger med to så der er stolper til begge sider
        stolpeAntal *=  2;
        
        // Tilføjer den rigtige længde til stolpen til udregning af samlet meter pris.
        Product p = stolper.get(0);
        p.setLength(270);
        
        bom.addOrderLine(new OrderLine(p, stolpeAntal));
        return bom;
    }

}
