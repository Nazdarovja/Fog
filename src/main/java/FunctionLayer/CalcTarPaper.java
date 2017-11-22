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
public class CalcTarPaper {  //milimeter

    public static OrderLine calcTarPaper(double length, double width, Product tarPaper, String roofType) {
        
        double overlay = 100;
        int tarPaperCounter = 0;
        double productLength = tarPaper.getLength();
        double productWidth = tarPaper.getWidth();
        
        //
        double widthRollsNeeded = width / ((productWidth*10)-overlay);  
        System.out.println("rolls needed (width): "+widthRollsNeeded);
        
        double tarPaperLenNeeded = length * (width / 10000);  //pr meter width 
        System.out.println("DEBUG - tarPaperLenNeeded: "+tarPaperLenNeeded);
        
        double rowLengt = length / (productLength*10);
        double res = widthRollsNeeded * rowLengt;
        
        //tarPaper rolls needed
        while (tarPaperLenNeeded > 0) {
            tarPaperLenNeeded -= productLength;
            tarPaperCounter++;
        }
        
        //Pitched roof
        if (roofType.equals("rejsning")) {
            res = res * 2;
        }

        return new OrderLine(tarPaper, tarPaperCounter);
    }

    public static void main(String[] args) {
        double length = 5000;
        double width = 4000;
        Product tagpap = new ProductPerMeterPrice(0, "ICOPAL SELVKLÆBER TOP SORT 1X5", "tagpap", 13980, 500, 100, 0);  //meterpris i Øre = 69900
        OrderLine result = calcTarPaper(length, width, tagpap, "fladt");
        System.out.println(result.quantity);
    }

}
