/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Employee;
import FunctionLayer.LoginException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stanislav
 */
public class EmployeeMapperTest {

    private static Connection testConnection;
    private static final String USER = "test";
    private static final String USERPW = "Password1";
    private static final String DBNAME = "fogTest";
    private static final String HOST = "207.154.222.88";

    @Before
    public void setUp() {
        //INSERT INTO
        //EmployeeTest(name, surname, password)
        //VALUES('Martin', 'Fogmaster', 'emp1'),
            //('Johannes', 'Fog','emp2'),
            //('Frodo', 'Baggings','emp3');

        try {
            // avoid making a new connection for each test
            if (testConnection == null || testConnection.isClosed()) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test 
                DBConnector.setConn(testConnection);
            }
            // reset test database
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("drop table if exists Employee");
                stmt.execute("create table Employee like EmployeeTest");
                stmt.execute("insert into Employee select * from EmployeeTest");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }

    //TODO id ????? 
    //@Test
    public void testLogin() throws Exception {
        System.out.println("login");
        int id = 0;
        String pwd = "";
        String ipAddress = "";
        Employee expResult = null;
        Employee result = EmployeeMapper.login(id, pwd, ipAddress);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test(expected = LoginException.class)
    public void testLoginException() throws LoginException, Exception {
        Employee result = EmployeeMapper.login(0, "", "");
    }
}
