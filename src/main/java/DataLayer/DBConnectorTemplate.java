/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Stanislav
 */
public class DBConnectorTemplate {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://207.154.222.88:3306/fog";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static Connection conn = null;

    public static Connection getConnection() throws Exception {
        if (conn == null || conn.isClosed()) {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conn;
    }

    /* USED AFTER A MAPPER METHEOD IS EXECUTED TO CLOSE STANDING CONNECTIONS !!!
    try {
    
    //// MAPPER METHEOD HERE 
    
    finally
    {
        // Always make sure result sets and statements are closed,
        // and the connection is returned to the pool
        
            if (rs != null)
                rs.close ();
            if (stmt != null)
                stmt.close ();
            if (pstmt != null)
                pstmt.close ();
            if (conn != null)
                conn.close ();
        }
        */
}
