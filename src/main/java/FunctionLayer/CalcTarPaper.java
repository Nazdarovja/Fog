/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */


public class CalcTarPaper {

    /**
     * Calculate tar paper needed for a specific flat roof area.
     * @param length 
     * @param width 
     * @param tarPaper Product
     * @return Orderline with Product & quantity needed.
     */
    public static OrderLine flat(double length, double width, Product tarPaper) {

        double tarPaperOverlay = 100;

        //(number of) rows of rolls needed
        double widthRollsNeeded = width / ((tarPaper.getWidth() * 10) - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (length / (tarPaper.getLength() * 10));

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows);

        return new OrderLine(tarPaper, result);
    }
    
    /**
     * Calculate tar paper needed for a specific pitched roof area.
     * @param length 
     * @param width 
     * @param tarPaper Product
     * @return Orderline with Product & quantity needed.
     */
    public static OrderLine pitched(double length, double width, Product tarPaper) {

        double tarPaperOverlay = 100;

        //(number of) rows of rolls needed
        double widthRollsNeeded = width / ((tarPaper.getWidth() * 10) - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (length / (tarPaper.getLength() * 10));

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows) * 2;

        return new OrderLine(tarPaper, result);
    }

}
