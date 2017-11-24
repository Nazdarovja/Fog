/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Mellem
 */
public class CalcRafter {
    public static OrderLine getRafterFlatRoof(double length, double width, Product tarPaper) {

        double tarPaperOverlay = 100;

        //(number of) rows of rolls needed
        double widthRollsNeeded = width / ((tarPaper.getWidth() * 10) - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (length / (tarPaper.getLength() * 10));

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows);

        return new OrderLine(tarPaper, 0, result, "roll", "rafter comment text");
    }

    
    
    public static OrderLine getRafterPitchedRoof(double length, double width, Product tarPaper) {

        double tarPaperOverlay = 100;

        //(number of) rows of rolls needed
        double widthRollsNeeded = width / ((tarPaper.getWidth() * 10) - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (length / (tarPaper.getLength() * 10));

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows) * 2;

        return new OrderLine(tarPaper, 0, result, "roll", "rafter comment text");
    }
}
