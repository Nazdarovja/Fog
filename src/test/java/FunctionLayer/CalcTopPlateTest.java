/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stanislav
 */
public class CalcTopPlateTest {
    
    public CalcTopPlateTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetTopPlates() {
        System.out.println("getTopPlates");
        int length = 240;
        int width = 750;
        Product p = new Product(1, "45x195 SPÆRTRÆ UBH.", "rem", 1995, 1000, 45, 195);
        int expResult = 3;
        OrderLine result = CalcTopPlate.getTopPlatesFlatRoof(length, width, p);
        assertTrue(expResult == result.quantity);
    }
    
}
