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
    
    public static void main(String[] args) {
        System.out.println(calcRoofWidth(600,45));
    }
}
