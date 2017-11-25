/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Inquiry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class InquiryMapper {

    public static Inquiry registerInitialInquiry(Inquiry i) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Inquiry inquiry = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "INSERT INTO Inquiry (id, carportHeight,carportLength,carportWidth,shackWidth,shackLength,roofType,angle,commentCustomer,commentEmployee,period, status, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
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
            pstmt.setDate(11, i.getPeriod());  //
            pstmt.setString(12, i.getStatus());
            pstmt.setString(13, i.getEmail());
            conn.setAutoCommit(false);
            int res = pstmt.executeUpdate();
            int id = -1;  //dummy

            if (res == 1) {
                rs = pstmt.getGeneratedKeys();
                rs.next();
                id = rs.getInt(1);

                inquiry = new Inquiry(id, i.getCarportHeight(), i.getCarportLength(), i.getCarportWidth(), i.getShackWidth(), i.getShackLength(), i.getRoofType(), i.getAngle(), i.getCommentCustomer(), i.getCommentEmployee(), i.getPeriod(), i.getStatus(), i.getEmail(), i.getId_employee());

                conn.commit();
            } else {
                conn.rollback();
                throw new Exception("Error creating Inquiry in database.");
            }

        } finally {
            // Always make sure result sets and statements are closed,
            // and the connection is returned to the pool

            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return inquiry;
    }
    
    public static List<Inquiry> allInquiries() throws Exception{
        List<Inquiry> inquiries = new ArrayList<>();
        Inquiry i;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * from Inquiry";
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                i = new Inquiry(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14));
                inquiries.add(i);
            }
            return inquiries;
            
        } finally {
            if (rs != null) {
                rs.close();
            } if (ps != null) {
                ps.close();
            } if (conn != null) {
                conn.close();
            }
        }

    }
    
    
}
