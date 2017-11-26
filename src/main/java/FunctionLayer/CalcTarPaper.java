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

    public static OrderLine getTarPaperFlatRoof(double length, double width, Product tarPaper) {

        double lengthInMM = length * 10;
        double widthInMM = width * 10;

        double tarPaperOverlay = 100;

        //(number of) rows of rolls needed
        double widthRollsNeeded = widthInMM / (tarPaper.getWidth() - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (lengthInMM / tarPaper.getLength());

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows);

        return new OrderLine(tarPaper, 0, result, "roll", "tarPaper comment text");
    }

    public static OrderLine getTarPaperPitchedRoof(double length, double width, Product tarPaper) {

        double lengthInMM = length * 10;
        double widthInMM = width * 10;
        
        double tarPaperOverlay = 100;

        //(number of) rows of rolls needed
        double widthRollsNeeded = widthInMM / (tarPaper.getWidth() - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (lengthInMM / tarPaper.getLength());

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows) * 2;

        return new OrderLine(tarPaper, 0, result, "roll", "tarPaper comment text");
    }

}
