package DataLayer;

import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.LoginException;
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
public class CustomerMapper {

    /**
     * Checks if user with given credentials exist in database.
     *
     * @param email String with user email
     * @param password String with user password
     * @param ipAddress String with ipAddress
     * @return Customer object if exist.
     * @throws LoginException with ipAddress info if not.
     * @throws Exception
     */
    public static Customer login(String email, String password, String ipAddress) throws LoginException, Exception {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * from Customer INNER JOIN Zipcode ON Customer.zipcode = Zipcode.zipcode WHERE email=? AND password=?;";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {

                String mail = rs.getString("email");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int phonenumber = rs.getInt("phonenumber");
                String address = rs.getString("address");
                int zipcode = rs.getInt("zipcode");
                String pass = rs.getString("password");
                String city = rs.getString("city");

//            String city = //methode til at hente fra anden table
                Customer customer = new Customer(mail, name, surname, phonenumber, address, zipcode, pass, city);
                return customer;
            } else {
                // TODO INSERT LOG OF FAIL (EMAIL PRESENT IN LOG) login failure
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                throw new LoginException("Login attempt on user with email: " + email + ", pwd: " + password + ", IP Address: " + ipAddress);
            }
        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
        } finally {
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
    }

    /**
     * Get corresponding city from database to given zipcode.
     *
     * @param zipcode
     * @return City as String.
     * @throws FogException
     * @throws Exception
     */
    public static String getCity(int zipcode) throws FogException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT city from Zipcode WHERE zipcode=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, Integer.toString(zipcode));
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            } else {
                throw new FogException(" no city with specified zipcode ");
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
     * Insert a customer in database.
     * @param c Customer object
     * @return Customer object
     * @throws FogException
     * @throws Exception
     */
    public static Customer createCustomer(Customer c) throws FogException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = DBConnector.getConnection();
            String SQL = "INSERT INTO Customer (email, name, surname, phonenumber, address, password, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(SQL);
            ps.setString(1, c.getEmail());
            ps.setString(2, c.getName());
            ps.setString(3, c.getSurname());
            ps.setString(4, Integer.toString(c.getPhonenumber()));
            ps.setString(5, c.getAddress());
            ps.setString(6, c.getPassword());
            ps.setString(7, Integer.toString(c.getZipcode()));
            ps.executeUpdate();

            String email = c.getEmail();
            String passwd = c.getPassword();
            String name = c.getName();
            String surname = c.getSurname();
            int phonenumber = c.getPhonenumber();
            String address = c.getAddress();
            int zipcode = c.getZipcode();
            String city = getCity(zipcode);

            return new Customer(email, name, surname, phonenumber, address, zipcode, passwd, city);

        } catch (SQLException | ClassNotFoundException ex) {
            if (ex.getMessage().contains("Duplicate")) {
                throw new FogException("Specified email already exists");
            } else {
                throw new FogException(ex.getMessage());
            }

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * Get list of customer objects with inquiry from database.
     *
     * @return list of Customer objects.
     * @throws FogException
     * @throws Exception
     */
    public static List<Customer> customersWithInquiry() throws FogException, Exception {
        List<Customer> customers = new ArrayList<>();
        Customer c;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * FROM Customer c INNER JOIN Inquiry i ON c.email = i.email INNER JOIN Zipcode z ON c.zipcode = z.zipcode";
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(23));
                customers.add(c);
            }
            return customers;

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
     * Get list of customers from database with inquiries of a given status.
     *
     * @param status String ogject
     * @return List of Customer Objects
     * @throws FogException
     * @throws Exception
     */
    public static List<Customer> customersByInquiryStatus(String status) throws FogException, Exception {
        List<Customer> customers = new ArrayList<>();
        Customer c;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT DISTINCT(c.email), c.name, c.surname, c.phonenumber, c.address, c.zipcode, c.password, z.city FROM Customer c INNER JOIN Zipcode z ON c.zipcode = z.zipcode INNER JOIN Inquiry i on c.email = i.email WHERE i.status = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
                customers.add(c);
            }
            return customers;

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
     * Get lst of all customers from database.
     *
     * @return list of Customer Objects.
     * @throws FogException
     * @throws Exception
     */
    public static List<Customer> allCustomers() throws FogException, Exception {
        List<Customer> customers = new ArrayList<>();
        Customer c;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * FROM Customer c INNER JOIN Zipcode z ON c.zipcode = z.zipcode";
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
                customers.add(c);
            }
            return customers;

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
     * Get customer from database with a given email adress.
     *
     * @param email String object
     * @return Customer Object.
     * @throws FogException
     * @throws Exception
     */
    public static Customer customerByEmail(String email) throws FogException, Exception {
        Customer customer;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * FROM Customer c INNER JOIN Zipcode z ON c.zipcode = z.zipcode WHERE c.email = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));

                return customer;
            } else {
                throw new FogException(" no customer with specified email ");
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
}
