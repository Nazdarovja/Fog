/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Inquiry;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stanislav
 */
public class InquiryMapperTest {
    
    public InquiryMapperTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testRegisterInitialInquiry() throws Exception {
        System.out.println("registerInitialInquiry");
        Inquiry i = new Inquiry(0, 0, 700, 360, 0, 0, "rejsning", "15", "", "", new Date(2017,11,21), "ny", "test1@test.dk", 0, null);
        Inquiry result = InquiryMapper.registerInitialInquiry(i);
        assertEquals("rejsning", result.getRoofType());
        assertTrue( result.getId() > 0);
    }
    
    @Test
    public void testUpdateCarportSize() throws Exception {
        System.out.println("update carport size");
        int id = 1, height = 300, length = 300, width = 300;
        int hRes = 300, lRes = 300, wRes = 300;
        
        Inquiry result = InquiryMapper.updateCarportSize(id, height, length, width);
        
        assertEquals(hRes, result.getCarportHeight());
        assertEquals(lRes, result.getCarportLength());
        assertEquals(wRes, result.getCarportWidth());
    }
    
    @Test
    public void testUpdateShackSize() throws Exception {
        System.out.println("update shack size");
        int id = 1, length = 300, width = 300;
        int lRes = 300, wRes = 300;
        
        Inquiry result = InquiryMapper.updateShackSize(id, length, width);
        
        assertEquals(lRes, result.getShackLength());
        assertEquals(wRes, result.getShackWidth());
    }
    
}
