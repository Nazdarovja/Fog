/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CalcShackCladdingTest {

    public CalcShackCladdingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCladdingForShack method, of class CalcShackCladding.
     */
    @Test
    public void testGetCladdingForShackFlatRoof() throws Exception {
        System.out.println("getCladdingForShack");
        int shackLength = 730;
        int shackWidth = 360;
        int carportHeight = 240;
        List<Product> claddingList = Calculator.getChosenCategory("beklædning", DataLayer.ProductMapper.getProducts());
        OrderLine result = CalcShackCladding.getCladdingForShackFlatRoof(shackLength, shackWidth, carportHeight, claddingList);
        int expResult = 269;
        assertEquals(expResult, result.quantity);
    }
    @Test
    public void testGetCladdingForShackPitchedRoofGable() throws Exception {
        System.out.println("getCladdingForShackPitchedRoofGable");
        int carportWidth = 360;
        int carportHeight = 240;
        int shackWidth = 360;
        int roofAngle = 15;
        List<Product> claddingList = Calculator.getChosenCategory("beklædning", DataLayer.ProductMapper.getProducts());
        OrderLine result = CalcShackCladding.getCladdingForShackPitchedRoofGable(carportWidth, carportHeight, shackWidth, roofAngle, claddingList);
        int expResult = 88;
        assertEquals(expResult, result.quantity);
    }

    @Test
    public void testGetCladdingForShackPitchedRoofSide() throws Exception {
        System.out.println("getCladdingForShackPitchedRoofSide");
        int carportWidth = 360;
        int carportHeight = 240;
        int shackLength = 730;
        int roofAngle = 15;
        List<Product> claddingList = Calculator.getChosenCategory("beklædning", DataLayer.ProductMapper.getProducts());
        OrderLine result = CalcShackCladding.getCladdingForShackPitchedRoofSide(carportWidth, carportHeight, shackLength, roofAngle, claddingList);
        int expResult = 181;        
        assertEquals(expResult, result.quantity);
    }

}
