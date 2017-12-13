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

    //@Test
    public void testRegisterInitialInquiry() throws Exception {
        System.out.println("registerInitialInquiry");
        Inquiry i = new Inquiry(0, 0, 700, 360, 0, 0, "rejsning", "trapeztag", "15", "", "", new Date(2017, 11, 21), "ny", "test1@test.dk", 0, null);
        Inquiry result = InquiryMapper.registerInitialInquiry(i);
        assertEquals("trapeztag", result.getRoofMaterial());
        assertTrue(result.getId() > 0);
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
    
    //@Test
//    public void testUpdateInquiry() throws Exception {
//        System.out.println("update shack size");
//        int id = 1, height = 300, length = 300, width = 300, shackLength = 200, shackWidth = 200;
//        int lRes = 200, wRes = 200;
//        String roofType = "fladt";
//        String roofMat = "testMat";
//        String angle = null;
//        String comment = null;
//        String status = "ny";
//        
//        Inquiry result = InquiryMapper.updateInquiry(id, height, length, width, shackLength, shackWidth, roofType, roofMat, angle, comment, status);
//        
//        assertEquals(lRes, result.getShackLength());
//        assertEquals(wRes, result.getShackWidth());
//    }
    

}
