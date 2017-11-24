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

        return new OrderLine(tarPaper, 0, result, "stk.", "rafter comment text");
    }


    
    public static OrderLine getRafterPitchedRoof(double length, double width, Product tarPaper) {

        double tarPaperOverlay = 100;

        //(number of) rows of rolls needed
        double widthRollsNeeded = width / ((tarPaper.getWidth() * 10) - tarPaperOverlay);

        //number of rolls needed for all rows
        double rollsForAllRows = widthRollsNeeded * (length / (tarPaper.getLength() * 10));

        //rounding up
        int result = (int) Math.ceil(rollsForAllRows) * 2;

        return new OrderLine(tarPaper, 0, result, "sæt", "rafter comment text");
    }
    
    
    
    public static void main(String[] args) {
        
        System.out.println(270/30);
        System.out.println(270/60);
        System.out.println(270/90);
        System.out.println(270/120);
        
        
        
    }
    
    
    //    <option value=240>240</option>
//                        <option value=270>270</option>
//                        <option value=300>300</option>
//                        <option value=330>330</option>
//                        <option value=360>360</option>
//                        <option value=390>390</option>
//                        <option value=420>420</option>
//                        <option value=450>450</option>
//                        <option value=480>480</option>
//                        <option value=510>510</option>
//                        <option value=540>540</option>
//                        <option value=570>570</option>
//                        <option value=600>600</option>
//                        <option value=630>630</option>
//                        <option value=660>660</option>
//                        <option value=690>690</option>
//                        <option value=720>720</option>
//                        <option value=750>750</option>
}
