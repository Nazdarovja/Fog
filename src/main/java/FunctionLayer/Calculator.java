/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.ProductMapper;
import java.util.List;

/**
 *
 * @author Orchi
 */
public class Calculator {

    public static BillOfMaterials getBillOfMaterials(Inquiry inquiry) throws Exception {
        BillOfMaterials bom = new BillOfMaterials();
        List<Product> products = ProductMapper.getProducts();
        int length = inquiry.getCarportLength();
        int width = inquiry.getCarportWidth();

        // FLAT ROOF ALGORITHM        
        if (inquiry.getRoofType().equals("fladt")) {
            bom.addOrderLine(PostCalc.getPostsFlatRoof(length, width, inquiry.getCarportHeight(), "97x97 TRYKIMPR.", products));
            // PITCHED ROOF ALHORITHM
        } else {
            bom.addOrderLine(PostCalc.getPostsPitchedRoof(length, width, inquiry.getCarportHeight(), "97x97 TRYKIMPR.", products));

        }

        return bom;
    }
}
