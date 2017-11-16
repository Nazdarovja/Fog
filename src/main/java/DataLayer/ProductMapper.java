/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stanislav
 */
public class ProductMapper {

    /**
     * Input a category name to recieve a list from the database with Product objects.
     * @param category
     * @return List of Product objects form the chosen category
     * @throws java.sql.SQLException
     */
    public static List<Product> getCategory(String category) throws SQLException, Exception {
        List<Product> productList;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * FROM Product WHERE category=?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            productList = new ArrayList<>();
            while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String cat = rs.getString("category");
            long price = rs.getLong("price");
            int length = rs.getInt("length");
            int width = rs.getInt("width");
            int height = rs.getInt("height");
            productList.add(new Product(id,name,cat,price,length,width,height));
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
        return productList;
    }

}
