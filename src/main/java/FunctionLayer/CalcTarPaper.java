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

    public static OrderLine calcTarPaper(double length, double width, Product tarPaper) {

        double productLength = tarPaper.getLength();
        double productWidth = tarPaper.getWidth();
        
        double overlay = 100;
        
//        if(overlay * productWidth/1000 > )
        
        double tarPaperLenNeeded = length * ((width - overlay) / 10000);  //3,9 * 5000 = 19500
        //sørge for at den runder korrekt op!
        int tarPaperCounter = 0;
        while (tarPaperLenNeeded > 0) {
            tarPaperLenNeeded -= productLength;
            tarPaperCounter++;
        }

        return new OrderLine(tarPaper, tarPaperCounter);
    }

    public static void main(String[] args) {
        double length = 6000;
        double width = 5000;
        Product tagpap = new ProductPerMeterPrice(0, "ICOPAL SELVKLÆBER TOP SORT 1X5", "tagpap", 13980, 500, 100, 0);  //meterpris i Øre = 69900
        OrderLine result = calcTarPaper(length, width, tagpap);
        System.out.println(result.quantity);
    }

}
