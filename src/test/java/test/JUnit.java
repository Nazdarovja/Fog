/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.Product;
import FunctionLayer.ProductPerMeterPrice;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Orchi
 */
public class JUnit {

    public JUnit() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testLoginCustomer() throws Exception {
        String email = "test1@test.dk";
        String password = "Hansen1";
        Customer customer = LogicFacade.login(email, password);
        assertTrue(email.equals(customer.getEmail()));
        assertTrue(password.equals(customer.getPassword()));
    }

    @Test
    public void testLoginNotExistingCustomer() throws Exception {
        try {
            String email = "harrypotter@hogwarts.com";
            String password = "sectumsembra";
            Customer customer = LogicFacade.login(email, password);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().equals("could not validate user"));
        }
    }

    @Test
    public void testGetCategory() throws Exception {
        String categoryToBeFound = "søm";
        String categoryNotToBeFound = "Hammer";
        List<Product> product = LogicFacade.getCategory(categoryToBeFound);
        assertTrue(categoryToBeFound.equals(product.get(0).getName()));
        assertFalse(categoryNotToBeFound.equals(product.get(0).getName()));
        
    }
    
    @Test
    public void testCreateCustomer() throws Exception {
        Customer newCustomer = new Customer("test@test.dk", "test", "tester", 12345678, "streetname 6", 2750, "password", "Ballerup");
        Customer ExpectedCustomer = LogicFacade.createCostumer(newCustomer);
        assertNotNull(ExpectedCustomer);
//        assertNotEquals(newCustomer, ExpectedCustomer);
//        LogicFacade;
    }    

}
