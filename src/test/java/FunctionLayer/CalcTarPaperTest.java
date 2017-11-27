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
public class CalcTarPaperTest {

    public CalcTarPaperTest() {
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
     * Test of getTarPaperFlatRoof method, of class CalcTarPaper.
     */
    @Test
    public void testGetTarPaperFlatRoof() throws Exception {
        System.out.println("getTarPaperFlatRoof");
        double length = 8000;
        double width = 1000;
        List<Product> tarPaperList = Calculator.getChosenCategory("tagpap", DataLayer.ProductMapper.getProducts());
        String expResultName = "ICOPAL BASE 411 P 1X8M";
        int expQty = 2;  //1 to cover, 1 extra cause of overlay
        OrderLine result = CalcTarPaper.getTarPaperFlatRoof(length, width, tarPaperList);
        assertEquals(expResultName, result.product.getName());
        assertEquals(expQty, result.quantity);
        System.out.println(result.product.getName());
    }

    /**
     * Test of getTarPaperPitchedRoof method, of class CalcTarPaper.
     */
    @Test
    public void testGetTarPaperPitchedRoof() throws Exception {
        System.out.println("getTarPaperPitchedRoof");
        double length = 8000;
        double width = 1000;
        List<Product> tarPaperList = Calculator.getChosenCategory("tagpap", DataLayer.ProductMapper.getProducts());
        String expResultName = "ICOPAL BASE 411 P 1X8M";
        int expQty = 3;  //1 to cover each side, 1 extra cause of overlay
        OrderLine result = CalcTarPaper.getTarPaperPitchedRoof(length, width, tarPaperList);
        assertEquals(expResultName, result.product.getName());
        assertEquals(expQty, result.quantity);
    }

}
