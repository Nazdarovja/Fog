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

                inquiry = new Inquiry(id, i.getCarportHeight(), i.getCarportLength(), i.getCarportWidth(), i.getShackWidth(), i.getShackLength(), i.getRoofType(), i.getAngle(), i.getCommentCustomer(), i.getCommentEmployee(), i.getPeriod(), i.getStatus(), i.getEmail(), i.getId_employee(), null);

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

    public static List<Inquiry> allInquiries() throws Exception {
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
            while (rs.next()) {
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
                        rs.getInt(14),
                        rs.getTimestamp(15));
                inquiries.add(i);
            }
            return inquiries;

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static Inquiry inquiryById(int id) throws Exception {
        Inquiry i;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * from Inquiry WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
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
                        rs.getInt(14),
                        rs.getTimestamp(15));
                return i;
            } else {
                throw new Exception(" no inquiry with specified id ");
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static Inquiry LatestInquiryByCustomer(String customerEmail) throws Exception {
        Inquiry i;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * FROM Inquiry WHERE email = ? AND date = ( SELECT MAX(date) FROM Inquiry WHERE email = ? GROUP BY email) ";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, customerEmail);
            ps.setString(2, customerEmail);
            rs = ps.executeQuery();
            if (rs.next()) {
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
                        rs.getInt(14),
                        rs.getTimestamp(15));
                return i;
            } else {
                throw new Exception(" no inquiry found ");
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static Inquiry updateCarportSize(int id, int height, int length, int width) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        Inquiry inquiry = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "UPDATE Inquiry SET carportHeight = ?, carportLength = ?, carportWidth = ? WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, height);
            ps.setInt(2, length);
            ps.setInt(3, width);
            ps.setInt(4, id);

            conn.setAutoCommit(false);
            int res = ps.executeUpdate();

            if (res == 1) {
                conn.commit();
                inquiry = inquiryById(id);
            } else {
                conn.rollback();
                throw new Exception(" Update error ");
            }

        } finally {
            if (ps != null) {
                ps.close();
            } if (conn != null) {
                conn.close();
            }
        }
        return inquiry;
    }
    
    public static Inquiry updateShackSize(int id, int length, int width) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        Inquiry inquiry = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "UPDATE Inquiry SET shackLength = ?, shackWidth = ? WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, length);
            ps.setInt(2, width);
            ps.setInt(3, id);

            conn.setAutoCommit(false);
            int res = ps.executeUpdate();

            if (res == 1) {
                conn.commit();
                inquiry = inquiryById(id);
            } else {
                conn.rollback();
                throw new Exception(" Update error ");
            }

        } finally {
            if (ps != null) {
                ps.close();
            } if (conn != null) {
                conn.close();
            }
        }
        return inquiry;
    }
    
    public static Inquiry updateInquiry(int id, int height, int length, int width, 
                                        int shackLength, int shackWidth, String roofType,
                                        String angle, String comment, String status) 
            throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        Inquiry inquiry = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "UPDATE Inquiry SET carportHeight = ?, carportLength = ?, carportWidth = ?, shackLength = ?, shackWidth = ?, roofType = ?, angle = ?, commentEmployee = ?, status = ? WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, height);
            ps.setInt(2, length);
            ps.setInt(3, width);
            ps.setInt(4, shackLength);
            ps.setInt(5, shackWidth);
            ps.setString(6, roofType);
            ps.setString(7, angle);
            ps.setString(8, comment);
            ps.setString(9, status);
            ps.setInt(10, id);

            conn.setAutoCommit(false);
            int res = ps.executeUpdate();

            if (res == 1) {
                conn.commit();
                inquiry = inquiryById(id);
            } else {
                conn.rollback();
                throw new Exception(" Update error ");
            }

        } finally {
            if (ps != null) {
                ps.close();
            } if (conn != null) {
                conn.close();
            }
        }
        return inquiry;
    }

}
