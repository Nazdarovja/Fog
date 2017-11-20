/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Inquiry;
import FunctionLayer.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class InquiryMapper {

    public static void registerInitialInquiry(Inquiry i) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "INSERT INTO Inquiry (id, carportHeight,carportLength,carportWidth,shackWidth,shackLength,roofType,angle,commentCustomer,commentEmployee,period, status, email, id_employee) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, i.getId());
            pstmt.setInt(2, i.getCarportHeight());
            pstmt.setInt(3, i.getCarportLength());
            pstmt.setInt(4, i.getCarportWidth());
            pstmt.setInt(5, i.getShackWidth());
            pstmt.setInt(6, i.getShackLength());
            pstmt.setString(7, i.getRoofType());
            pstmt.setString(8, i.getAngle());
            pstmt.setString(9, i.getCommentCustomer());
            pstmt.setString(10, i.getCommentEmployee());
            pstmt.setDate(11, i.getPeriod());
            pstmt.setString(12, i.getStatus());
            pstmt.setString(13, i.getEmail());
            pstmt.setInt(14, i.getId_employee());
            pstmt.executeUpdate();
            

        } finally {
            // Always make sure result sets and statements are closed,
            // and the connection is returned to the pool

            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }


