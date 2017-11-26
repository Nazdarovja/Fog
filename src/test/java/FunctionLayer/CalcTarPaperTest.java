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
    public void testGetTarPaperFlatRoof() throws Exception {
        double length = 500;
        double width = 400;
        int expFlatQty = 5;  //4 rows, full fill, minus overlay (+1 extra).
        Product tagpap = DataLayer.ProductMapper.getSingleProduct("tagpap", "ICOPAL TOP 500P SORT 1X5M");
        OrderLine flatResult = CalcTarPaper.getTarPaperFlatRoof(length, width, tagpap);
        assertNotNull(flatResult);
        assertEquals(expFlatQty, flatResult.quantity);
        assertEquals(tagpap.getName(), flatResult.product.getName());
        System.out.println(flatResult.product.getPrice());

    }

    @Test
    public void testGetTarPaperPitchedRoof() throws Exception {
        double length = 500;
        double width = 400;
        int expPitchedQty = 10;  //4 rows, full fill, minus overlay (+1 extra) * 2 roof halves
        Product tagpap = DataLayer.ProductMapper.getSingleProduct("tagpap", "ICOPAL TOP 500P SORT 1X5M");
        OrderLine pitchedResult = CalcTarPaper.getTarPaperPitchedRoof(length, width, tagpap);
        assertNotNull(pitchedResult);
        assertEquals(expPitchedQty, pitchedResult.quantity);
        assertEquals(tagpap.getName(), pitchedResult.product.getName());

    }

}
