/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.ProductMapper;
import java.util.ArrayList;
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

//        stolpe, rem,  spær, lægte,             algortime til hypotenuse, tagpap/tagsten
        // FLAT ROOF ALGORITHM        
        if (inquiry.getRoofType().equals("fladt")) {
            System.out.println("FLAT");
            //post / stolpe
            bom.addOrderLine(CalcPost.getPostsFlatRoof(length, width, inquiry.getCarportHeight(),getChosenCategory("stolpe", products)));
            //topplate / rem
//            bom.addOrderLine(CalcTopPlate.getTopPlatesFlatRoof(length, width, getChosenProduct("45x195mm. spærtræ ubh.", products)));
            //raft / spær
    //        bom.addOrderLine(CalcRafter.getRafterFlatRoof(length, width, getChosenProduct("45x195mm. spærtræ ubh. til spær", products)));
            //tarPaper / tagpap
      //      bom.addOrderLine(CalcTarPaper.getTarPaperFlatRoof(length, width, getChosenProduct("ICOPAL BASE 411 P 1X8M", products)));
            
        // PITCHED ROOF ALHORITHM
        } else {
            //post / stolpe
            System.out.println("PITCHED");
            bom.addOrderLine(CalcPost.getPostsPitchedRoof(length, width, inquiry.getCarportHeight(),getChosenCategory("stolpe", products)));
            //topplate / rem
        //    bom.addOrderLine(CalcTopPlate.getTopPlatesPitchedRoof(length, width, getChosenProduct("45x195mm. spærtræ ubh.", products)));
            //raft / spær
          //  bom.addOrderLine(CalcRafter.getRafterPitchedRoof(length, width, getChosenProduct("færdigskåret (byg-selv-spær)", products)));
            //lath / lægte
            //bom.addOrderLine(CalcLath.calculateRegularLath(length, (int) calcRoofWidth(width,Integer.parseInt(inquiry.getAngle())), getChosenProduct("38x73mm. Lægte ubh.", products)));
            //bom.addOrderLine(CalcLath.calculateTopLath(length, width, getChosenProduct("38x73mm. Lægte ubh.", products)));
            //tarPaper / tagpap
            
            //Bricks/rooftiles /tagsten
           // bom.addOrderLine(CalcBricks.calculateAmountOfBricks(length, (int) calcRoofWidth(width,Integer.parseInt(inquiry.getAngle())),getChosenProduct("RØDE VINGETAGSTEN GL. DANSK FORBRUG: 14,6 STK/M2", products)));
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
    private static List<Product> getChosenCategory(String category, List<Product> products){
        List<Product> chosenCategoryList = new ArrayList<>();
        for (Product p : products){
            if(p.getCategory().equalsIgnoreCase(category)){
                chosenCategoryList.add(p);
            }
        }
        return chosenCategoryList;
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
