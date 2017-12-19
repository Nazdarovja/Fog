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

    /**
     * Checks if employee with given credentials exist in database.
     * @param id String 
     * @param pwd String
     * @param ipAddress String
     * @return Employee Objec if found. 
     * @throws LoginException
     * @throws FogException
     */
    public static Employee login(int id, String pwd, String ipAddress) throws LoginException, FogException {
        String SQL = "SELECT * from Employee WHERE id=? AND password=?";
        try (Connection conn = DBConnector.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(SQL);) {
            pstmt.setInt(1, id);
            pstmt.setString(2, pwd);
            try (ResultSet rs = pstmt.executeQuery()) {
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
        } 
        catch (SQLException ex) {
            throw new FogException( ex.getMessage() );
        }
    }
}
