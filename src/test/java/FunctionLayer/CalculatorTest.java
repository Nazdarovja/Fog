/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stanislav
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetBillOfMaterials() throws Exception {
        System.out.println("getBillOfMaterials");
        Inquiry inquiry = null;
        BillOfMaterials expResult = null;
        BillOfMaterials result = Calculator.getBillOfMaterials(inquiry);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
}
