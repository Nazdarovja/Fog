/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ML
 */
public class EmployeeMapper {

    public static Employee login(int id, String pwd, String ipAddress) throws LoginException, Exception {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * from Employee WHERE id=? AND password=?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int empId = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String pass = rs.getString("password");
                
                Employee emp = new Employee(empId, name, surname, pass);
                return emp;
            } else {
                // TODO INSERT LOG OF FAIL (EMAIL PRESENT IN LOG) login failure
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                throw new LoginException("Login attempt on user with id: " + id + ", pwd: " + pwd + ", IP Address: " + ipAddress);
            }
        } 
        catch (SQLException ex) {
            throw new FogException( ex.getMessage() );
        }
        finally {
            if (rs != null) {
                rs.close();
            } if (pstmt != null) {
                pstmt.close();
            } if (conn != null) {
                conn.close();
            }
        }

    }
    
}