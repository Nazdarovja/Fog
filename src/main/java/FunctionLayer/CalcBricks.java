/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Orchi
 */
public class CalcBricks {
    
    public static OrderLine calculateAmountOfBricks(int length, int width, Product brick) {
        int newWidth = brick.getWidth() - 20;
        int newLength = brick.getLength() - 100;
        
        int rows = width / newLength;
        rows++;
        
        int columns = length / newWidth;
        columns++;
        
        int quantity = rows * columns;
        
        return new OrderLine(brick, 0, quantity, "stk", "Monteres på taglægter fordelt på hver side af taget");
    }
    
    public static OrderLine calculateAmountOfTopBricks(int length, int width, Product brick) {
        int lengthMinusOverlap = brick.getLength() - 50;
        int quantity = length / lengthMinusOverlap;
        quantity++;
        return new OrderLine(brick, 0, quantity, "stk", "monteres på toplægte med medfølgende beslag se " +
                                                            "tagstens vejledning");
    }
}
