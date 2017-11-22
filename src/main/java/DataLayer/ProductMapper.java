/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Product;
import FunctionLayer.ProductPerMeterPrice;
import FunctionLayer.ProductPerPrice;
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
     * Input a category name to recieve a list from the database with
     * ProductPerMeterPrice objects.
     *
     * @param category
     * @return List of ProductPerMeterPrice objects form the chosen category
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

                if (cat.equals("værktøj")) {
                    productList.add(new ProductPerPrice(id, name, cat, price));
                } else {
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int height = rs.getInt("height");
                    productList.add(new ProductPerMeterPrice(id, name, category, price, length, width, height));
                }

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

    public static Product getSingleProduct(String category, String productName) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Product product = null;

        try {
            conn = DBConnector.getConnection();
            String SQL = "SELECT * FROM Product WHERE category=? AND Product.name=?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, category);
            pstmt.setString(2, productName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String cat = rs.getString("category");
                long price = rs.getLong("price");

                if (cat.equals("værktøj")) {
                    product = new ProductPerPrice(id, name, cat, price);
                } else {
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int height = rs.getInt("height");
                    product = new ProductPerMeterPrice(id, name, category, price, length, width, height);
                }
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

        return product;
    }
}
