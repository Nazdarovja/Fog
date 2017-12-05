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

    //int id, int carportHeight, int carportLength, int carportWidth, int shackWidth, int shackLength, String roofType, String roofMaterial, String angle, String commentCustomer, String commentEmployee, Date period, String status, String email, int id_employee, Timestamp date
    @Test
    public void testRegisterInitialInquiry() throws Exception {
        System.out.println("registerInitialInquiry");
        Inquiry i = new Inquiry(0, 0, 700, 360, 0, 0, "rejsning","tagpap", "15", "", "", new Date(2017,11,21), "ny", "test1@test.dk", 0, null);
        Inquiry result = InquiryMapper.registerInitialInquiry(i);
        assertEquals("tagpap", result.getRoofMaterial());
        assertTrue( result.getId() > 0);
    }
    
}
