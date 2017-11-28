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

//    @Test
    public void testRegisterInitialInquiry() throws Exception {
        System.out.println("registerInitialInquiry");
        Inquiry i = new Inquiry(0, 0, 700, 360, 0, 0, "rejsning", "15", "", "", new Date(2017,11,21), "ny", "test1@test.dk", 0);
        Inquiry result = InquiryMapper.registerInitialInquiry(i);
        assertEquals("rejsning", result.getRoofType());
        assertTrue( result.getId() > 0);
    }
    
}
