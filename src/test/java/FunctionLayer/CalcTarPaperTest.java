package FunctionLayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @Test
    public void testGetTarPaperFlatRoof() {
        double length = 5000;
        double width = 4000;
        int expFlatQty = 5;  //4 rows, full fill, minus overlay (+1 extra).
        Product tagpap = new ProductPerMeterPrice(0, "ICOPAL SELVKLÆBER TOP SORT 1X5", "tagpap", 69900, 5000, 1000, 0);
        OrderLine flatResult = CalcTarPaper.getTarPaperFlatRoof(length, width, tagpap);
        assertNotNull(flatResult);
        assertEquals(expFlatQty, flatResult.quantity);
        assertEquals(tagpap.getName(), flatResult.product.getName());

    }

    @Test
    public void testGetTarPaperPitchedRoof() {
        double length = 5000;
        double width = 4000;
        int expPitchedQty = 10;  //4 rows, full fill, minus overlay (+1 extra) * 2 roof halves
        Product tagpap = new ProductPerMeterPrice(0, "ICOPAL SELVKLÆBER TOP SORT 1X5", "tagpap", 69900, 5000, 1000, 0);
        OrderLine pitchedResult = CalcTarPaper.getTarPaperPitchedRoof(length, width, tagpap);
        assertNotNull(pitchedResult);
        assertEquals(expPitchedQty, pitchedResult.quantity);
        assertEquals(tagpap.getName(), pitchedResult.product.getName());

    }

}
