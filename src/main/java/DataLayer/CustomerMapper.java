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
    
    
    public static void main(String[] args) throws Exception {
        login("test", "test");
    }

    public static Customer login(String email, String password) throws Exception {
        Connection con = DBConnector.getConnection();
        String SQL = "SELECT email,navn, efternavn, telefonNummer, adresse, postnummer, password FROM Customer "
                + "WHERE email=? AND password=?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            String mail = rs.getString("email");
            String name = rs.getString("navn");
            String surname = rs.getString("efternavn");
            int phonenumber = rs.getInt("telefonNummer");
            int address = rs.getInt("adresse");
            int zipcode = rs.getInt("postnummer");
//            String city = //methode til at hente fra anden table

            Customer customer = new Customer(email, name, surname, phonenumber, surname, phonenumber, null);
            return customer;
        } else {
            throw new Exception("could not validate user");
        }

    }
}
