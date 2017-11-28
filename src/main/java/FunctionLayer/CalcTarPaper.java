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

    public static OrderLine getTarPaperFlatRoof(int length, int width, Product tarPaper) {

        double newWidth = tarPaper.getWidth() - 100;  //overlay
        double newLength = tarPaper.getLength();
        double rows = width / newWidth;
        double columns = length / newLength;
        double res = rows * columns;
        int result = (int) Math.ceil(res);

        return new OrderLine(tarPaper, 0, result, "roll", "tarPaper comment text");
    }

    public static OrderLine getTarPaperPitchedRoof(int length, int width, Product tarPaper) {

        double newWidth = tarPaper.getWidth() - 100;  //overlay
        double newLength = tarPaper.getLength();
        double rows = width / newWidth;
        double columns = length / newLength;
        double res = (rows * columns) *2;
        int result = (int) Math.ceil(res);
        return new OrderLine(tarPaper, 0, result, "roll", "tarPaper comment text");
    }


}
