package DataLayer;

import FunctionLayer.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CustomerMapper {

    public static Customer login(String email, String password) throws Exception {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * from Customer JOIN Zipcode ON Customer.zipcode = Zipcode.zipcode WHERE email=? AND password=?;";
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
                Customer customer = new Customer(email, name, surname, phonenumber, address, zipcode, pass, city);
                return customer;
            } else {
                throw new Exception("could not validate user");
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
}

//    public static String getCity(int zipcode) throws Exception {
//
//    }
