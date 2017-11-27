/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CalcTarPaper {

    public static OrderLine getTarPaperFlatRoof(int length, int width, List<Product> tarPaperList) {

        double tarPaperOverlay = 100;
        Product tarPaper = getLargesQuadrametertProduct(tarPaperList);
        
        //(number of) rows of rolls needed
        double widthRollsNeeded = width / (tarPaper.getWidth() - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (length / tarPaper.getLength());

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows);

        return new OrderLine(tarPaper, 0, result, "roll", "tarPaper comment text");
    }

    public static OrderLine getTarPaperPitchedRoof(int length, int width, List<Product> tarPaperList) {

        
        double tarPaperOverlay = 100;
        Product tarPaper = getLargesQuadrametertProduct(tarPaperList);
        
        //(number of) rows of rolls needed
        double widthRollsNeeded = width / (tarPaper.getWidth() - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (length / tarPaper.getLength());

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows) * 2;

        return new OrderLine(tarPaper, 0, result, "roll", "tarPaper comment text");
    }

    private static Product getLargesQuadrametertProduct(List<Product> tarPaper) {

        Product largestTarPaper = tarPaper.get(0);
        double largestTarPaerQuadrameter = largestTarPaper.getLength() * largestTarPaper.getWidth();

        for (int i = 0; i < tarPaper.size(); i++) {
            Product p = tarPaper.get(i);
            double productQuadratmeter = p.getLength() * p.getWidth();
            if (productQuadratmeter > largestTarPaerQuadrameter) {
                largestTarPaper = p;
                largestTarPaerQuadrameter = p.getLength() * p.getWidth();
            }
        }
        return largestTarPaper;
    }
    
}
