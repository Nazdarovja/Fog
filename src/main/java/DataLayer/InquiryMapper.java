/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Customer;
import FunctionLayer.FogException;
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
 * @author Alexander W. Hørsted-Andersen
 */
public class InquiryMapper {

    /**
     * Insert Inquiry object into database.
     * @param i Inquiry object
     * @return Inquiry object
     * @throws FogException
     * @throws Exception
     */
    public static Inquiry registerInitialInquiry(Inquiry i) throws FogException, Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Inquiry inquiry = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "INSERT INTO Inquiry (id, carportHeight,carportLength,carportWidth,shackWidth,shackLength,roofType,roofMaterial,angle,commentCustomer,commentEmployee,period, status, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, i.getId());
            pstmt.setInt(2, i.getCarportHeight());
            pstmt.setInt(3, i.getCarportLength());
            pstmt.setInt(4, i.getCarportWidth());
            pstmt.setInt(5, i.getShackWidth());
            pstmt.setInt(6, i.getShackLength());
            pstmt.setString(7, i.getRoofType());
            pstmt.setString(8, i.getRoofMaterial());
            pstmt.setString(9, i.getAngle());
            pstmt.setString(10, i.getCommentCustomer());
            pstmt.setString(11, i.getCommentEmployee());
            pstmt.setDate(12, i.getPeriod());  //
            pstmt.setString(13, i.getStatus());
            pstmt.setString(14, i.getEmail());
            conn.setAutoCommit(false);
            int res = pstmt.executeUpdate();
            int id = -1;  //dummy

            if (res == 1) {
                rs = pstmt.getGeneratedKeys();
                rs.next();
                id = rs.getInt(1);

                inquiry = new Inquiry(id, i.getCarportHeight(), i.getCarportLength(), i.getCarportWidth(), i.getShackWidth(), i.getShackLength(), i.getRoofType(), i.getRoofMaterial(), i.getAngle(), i.getCommentCustomer(), i.getCommentEmployee(), i.getPeriod(), i.getStatus(), i.getEmail(), i.getId_employee(), null);

                conn.commit();
            } else {
                conn.rollback();
                throw new FogException("Error creating Inquiry in database.");
            }

        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
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

    /**
     * Get list of all inquiries from database.
     * @return List of Inquiry Objects.
     * @throws FogException
     * @throws Exception
     */
    public static List<Inquiry> allInquiries() throws FogException, Exception {
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
                        rs.getString(11),
                        rs.getDate(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(15),
                        rs.getTimestamp(16));
                inquiries.add(i);
            }
            return inquiries;

        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
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

    /**
     * Get inquiry with given id from database.
     * @param id of inquiry as int
     * @return Inquiry object
     * @throws FogException
     * @throws Exception
     */
    public static Inquiry inquiryById(int id) throws FogException, Exception {
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
                        rs.getInt("id"),
                        rs.getInt("carportHeight"),
                        rs.getInt("carportLength"),
                        rs.getInt("carportWidth"),
                        rs.getInt("shackWidth"),
                        rs.getInt("shackLength"),
                        rs.getString("roofType"),
                        rs.getString("roofMaterial"),
                        rs.getString("angle"),
                        rs.getString("commentCustomer"),
                        rs.getString("commentEmployee"),
                        rs.getDate("period"),
                        rs.getString("status"),
                        rs.getString("email"),
                        rs.getInt("id_employee"),
                        rs.getTimestamp("date"));
                return i;
            } else {
                throw new FogException(" no inquiry with specified id ");
            }

        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
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

    /**
     * Get a Inquiry from database by given customers email, sorted by (latest) date.
     * @param customerEmail String
     * @return Inquiry Object.
     * @throws FogException
     * @throws Exception
     */
    public static Inquiry LatestInquiryByCustomer(String customerEmail) throws FogException, Exception {
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
                        rs.getString(11),
                        rs.getDate(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(15),
                        rs.getTimestamp(16));
                return i;
            } else {
                throw new FogException(" no inquiry found ");
            }

        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
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

    /**
     * Update carport size in database, by given parameters.
     * @param id int
     * @param height int
     * @param length int
     * @param width int
     * @return Inquiry object.
     * @throws SQLException
     * @throws Exception
     */
    public static Inquiry updateCarportSize(int id, int height, int length, int width) throws FogException, Exception {
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
                throw new FogException(" Update error ");
            }

        }
        catch ( SQLException ex ) {
            throw new FogException( ex.getMessage() );
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return inquiry;
    }

    /**
     * Update carport shack size in database, by given parameters.
     * @param id int
     * @param length int
     * @param width int
     * @return Inquiry object.
     * @throws SQLException
     * @throws Exception
     */
    public static Inquiry updateShackSize(int id, int length, int width) throws FogException, Exception {
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
                throw new FogException(" Update error ");
            }

        }
        catch ( SQLException ex ) {
            throw new FogException( ex.getMessage() );
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return inquiry;
    }

    /**
     * Update inquiry in database by given parameters.
     * @param id int
     * @param height int
     * @param length int
     * @param width int
     * @param shackLength int
     * @param shackWidth int
     * @param roofType String
     * @param roofMat String
     * @param angle String
     * @param comment String
     * @param status String
     * @return Inquiry Object
     * @throws SQLException
     * @throws Exception
     */
    public static Inquiry updateInquiry(int id, int height, int length, int width,
            int shackLength, int shackWidth, String roofType,
            String roofMat, String angle, String comment, String status)
            throws FogException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        Inquiry inquiry = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "UPDATE Inquiry SET carportHeight = ?, carportLength = ?, carportWidth = ?, shackLength = ?, shackWidth = ?, roofType = ?, roofMaterial = ?, angle = ?, commentEmployee = ?, status = ? WHERE id = ?";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, height);
            ps.setInt(2, length);
            ps.setInt(3, width);
            ps.setInt(4, shackLength);
            ps.setInt(5, shackWidth);
            ps.setString(6, roofType);
            ps.setString(7, roofMat);
            ps.setString(8, angle);
            ps.setString(9, comment);
            ps.setString(10, status);
            ps.setInt(11, id);

            conn.setAutoCommit(false);
            int res = ps.executeUpdate();

            if (res == 1) {
                conn.commit();
                inquiry = inquiryById(id);
            } else {
                conn.rollback();
                throw new FogException("--- Update error ---");
            }

        }
        catch ( SQLException ex ) {
            throw new FogException( ex.getMessage() );
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return inquiry;
    }

    /**
     * Get list of Inquiries by a given customer.
     * @param customer Customer object
     * @return List of Inquiry objects.
     * @throws FogException
     * @throws Exception
     */
    public static List<Inquiry> getCustomerInquiries(Customer customer) throws FogException, Exception {
        List<Inquiry> inquiries = new ArrayList<>();
        Inquiry i;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * from Inquiry where email= \"" + customer.getEmail() + "\" and status = \"gemt\"";
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
                        rs.getString(11),
                        rs.getDate(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(15),
                        rs.getTimestamp(16));
                inquiries.add(i);
            }

            if (inquiries.isEmpty()) {
                throw new FogException("No Inquiries for " + customer.getEmail());
            }
            return inquiries;

        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
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

    /**
     * Update inquiry in database.
     * @param i Inquiry object.
     * @throws FogException
     * @throws SQLException
     * @throws Exception
     */
    public static void sendSavedInquiry(Inquiry i) throws FogException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "UPDATE Inquiry SET carportHeight = ?, carportLength = ?, carportWidth = ?, shackLength = ?, shackWidth = ?, roofType = ?, roofMaterial = ?, angle = ?, commentEmployee = ?, status = ? WHERE id = ?";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, i.getCarportHeight());
            ps.setInt(2, i.getCarportLength());
            ps.setInt(3, i.getCarportWidth());
            ps.setInt(4, i.getShackLength());
            ps.setInt(5, i.getShackWidth());
            ps.setString(6, i.getRoofType());
            ps.setString(7, i.getRoofMaterial());
            ps.setString(8, i.getAngle());
            ps.setString(9, i.getCommentCustomer());
            ps.setString(10, i.getStatus());
            ps.setInt(11, i.getId());

            conn.setAutoCommit(false);
            int res = ps.executeUpdate();

            if (res == 1) {
                conn.commit();
            } else {
                conn.rollback();
                throw new FogException(" Update error ");
            }

        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
