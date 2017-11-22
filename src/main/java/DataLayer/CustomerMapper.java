package DataLayer;

import FunctionLayer.Customer;
import FunctionLayer.FogException;
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
public class CustomerMapper {

    public static Customer login(String email, String password) throws FogException, SQLException, Exception {
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
                throw new FogException("could not validate user");
            }
        
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


    public static boolean isCustomerRegistered(Customer c) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * from Customer WHERE email=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, c.getEmail());
            rs = ps.executeQuery();

            return rs.next();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new Exception( ex.getMessage() );
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
    
    public static String getCity(int zipcode) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT city from Zipcode WHERE zipcode=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, Integer.toString(zipcode));
            rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            } else {
                throw new Exception(" no city with specified zipcode ");
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new Exception( ex.getMessage() );
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
    
    
    // Exception til LoginException??
    public static Customer createCustomer(Customer c) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            
            if (!isCustomerRegistered(c)) {
                con = DBConnector.getConnection();
                String SQL = "INSERT INTO Customer (email, name, surname, phonenumber, address, password, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = con.prepareStatement( SQL );
                ps.setString( 1, c.getEmail() );
                ps.setString( 2, c.getName() );
                ps.setString( 3, c.getSurname() );
                ps.setString( 4, Integer.toString(c.getPhonenumber()) );
                ps.setString( 5, c.getAddress() );
                ps.setString( 6, c.getPassword() );
                ps.setString( 7, Integer.toString(c.getZipcode()) );
                ps.executeUpdate();

                String email = c.getEmail();
                String passwd = c.getPassword();
                String name = c.getName();
                String surname = c.getSurname();
                int phonenumber = c.getPhonenumber();
                String address = c.getAddress();
                int zipcode = c.getZipcode();
                String city = getCity(zipcode);

                return new Customer(email,name,surname,phonenumber,address,zipcode,passwd,city);
            }else {
                throw new Exception(" Specified email already exists ");
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new Exception( ex.getMessage() );
        } finally {
            if (ps != null) {
                ps.close();
            } if (con != null) {
                con.close();
            }
        }
    }
    
    public static List<Customer> customersForInquiries() throws Exception{
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
            while(rs.next()){
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

//    public static String getCity(int zipcode) throws Exception {
//
//    }
