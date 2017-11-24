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
            bom.addOrderLine(PostCalc.getPostsFlatRoof(length, width, inquiry.getCarportHeight(), getChosenProduct("97x97mm. trykimp. Stolpe", products)));
            bom.addOrderLine(CalcTopPlate.getTopPlatesFlatRoof(length, width, getChosenProduct("45x195mm. spærtræ ubh.", products)));
            
            // PITCHED ROOF ALHORITHM
        } else {
            bom.addOrderLine(PostCalc.getPostsPitchedRoof(length, width, inquiry.getCarportHeight(), getChosenProduct("97x97mm. trykimp. Stolpe", products)));
            bom.addOrderLine(CalcTopPlate.getTopPlatesPitchedRoof(length, width, getChosenProduct("45x195mm. spærtræ ubh.", products)));

        }

        
        
        return bom;
    }


    private static Product getChosenProduct(String productName, List<Product> products) {
        Product product = null;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                product = p;
            }
        }
        return product;

    }
    
    private static double calcRoofWidth(int carportWidth, int angle){
        double halfWidth = carportWidth / 2;
        double radiantAngle = Math.toRadians(angle);
        double carportHeight =  halfWidth / Math.cos(radiantAngle);
        
        return calcHypotenuse(carportWidth,carportHeight);
    }
    
    private static double calcHypotenuse(double a, double b){
        double aPow = Math.pow(a, 2);
        double bPow = Math.pow(b, 2);
        return Math.sqrt(aPow+bPow);
    }
    

}
