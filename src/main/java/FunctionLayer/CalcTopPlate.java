/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Stanislav
 */
public class CalcTopPlate {

    public static OrderLine getTopPlates(int length, int width, Product p) {
        int rowsOfPoles = 2;

        //ROOF EAVES FRONT AND BACK (NO POLES UNDER EAVES) FLATROOF = 1000mm
        int roofSideEves = 70;

        //REDUCE THE COMPLETE LENGTHS WITH THE ROOF EVE SIZES
        width -= roofSideEves;

        // FIND OUT HOW MANY ROWS OF POLES ARE NECESSARY
        if (width >= 600) {
            rowsOfPoles += (width / 300) - 1;
        }
        
        return new OrderLine(p, width, rowsOfPoles, "stk", "Remme i sider, sadles ned i stolper");
    }
    
}
