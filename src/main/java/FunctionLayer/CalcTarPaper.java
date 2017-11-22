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

        int tarPaperCounter = 0;
        double productLength = tarPaper.getLength();

        double tarPaperLenNeeded = length * ((width) / 10000);  //pr meter width 

        //tarPaper rolls needed
        while (tarPaperLenNeeded > 0) {
            tarPaperLenNeeded -= productLength;
            tarPaperCounter++;
        }
        return new OrderLine(tarPaper, tarPaperCounter);
    }

    public static void main(String[] args) {
        double length = 2500;
        double width = 4000;
        Product tagpap = new ProductPerMeterPrice(0, "ICOPAL SELVKLÆBER TOP SORT 1X5", "tagpap", 13980, 500, 100, 0);  //meterpris i Øre = 69900
        OrderLine result = calcTarPaper(length, width, tagpap);
        System.out.println(result.quantity);
    }

}
