/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 * @author Stanislav
 */
public class PostCalc {

    public static OrderLine getPostsFlatRoof(int length, int width, int height, String postName, List<Product> products) throws Exception {
        Product post = null;
        for (Product p : products) {
            if (p.getName().equals(postName)) {
                post = p;
            }
        }

        //QUANTITY OF END POST FOR ONE ROW
        int quantity = 2;
        int rowsOfPoles = 2;

        //ROOF EAVES FRONT AND BACK (NO POLES UNDER EAVES) FLATROOF = 1000mm
        int roofEaves = 130;
        int roofSideEves = 70;

        //REDUCE THE COMPLETE LENGTHS WITH THE ROOF EVE SIZES
        length -= roofEaves;
        width -= roofSideEves;

        // FIND OUT HOW MANY ROWS OF POLES ARE NECESSARY
        if (width >= 600) {
            rowsOfPoles += (width / 300) - 1;
        }
        // HOW MANY POLES PR. ROW 
        if (length >= 620) {
            // Counts how many there can be between the existing ones and removes one.
            quantity += (length / 310) - 1;
        }

        // TIMES UP THE QUANTITY WITH THE NUMBER OF ROWS
        quantity *= rowsOfPoles;

        // ADD 90CM TO THE HEIGHT, FOR DIG-IN OF POLE
        height += 90;
        post.setLength(height);
        return new OrderLine(post, height, quantity, "stk", "Stolper nedgraves 90 cm. i jord");
    }

    public static OrderLine getPostsPitchedRoof(int length, int width, int height, String postName, List<Product> products) throws Exception {
        Product post = null;
        for (Product p : products) {
            if (p.getName().equals(postName)) {
                post = p;
            }
        }
        //QUANTITY OF END POST FOR ONE ROW
        int quantity = 2;
        int rowsOfPoles = 2;

        //ROOF EAVES FRONT AND BACK (NO POLES UNDER EAVES) FLATROOF = 1000mm
        int roofEaves = 110;
        int roofSideEves = 40;

        //REDUCE THE COMPLETE LENGTHS WITH THE ROOF EVE SIZES
        length -= roofEaves;
        width -= roofSideEves;

        // FIND OUT HOW MANY ROWS OF POLES ARE NECESSARY
        if (width >= 600) {
            rowsOfPoles += (width / 300) - 1;
        }
        // HOW MANY POLES PR. ROW 
        if (length >= 550) {
            // Counts how many there can be between the existing ones and removes one.
            quantity += (length / 275) - 1;
        }

        // TIMES UP THE QUANTITY WITH THE NUMBER OF ROWS
        quantity *= rowsOfPoles;

        // ADD 90CM TO THE HEIGHT, FOR DIG-IN OF POLE
        height += 90;
        post.setLength(height);
        return new OrderLine(post, height, quantity, "stk", "Stolper nedgraves 90 cm. i jord");
    }

    public static void main(String[] args) {
        int quantity = 2;
        int rowsOfPoles = 2;
        int length = 1200;
        int width = 930;

        if (width >= 620) {
            rowsOfPoles += (width / 310) - 1;
        }
        System.out.println(rowsOfPoles);

        //HOW MANY POLES PR. ROW
        System.out.println((length / 300) - 1);

        if (length >= 600) {
            quantity += (length / 300) - 1;
        }

        quantity *= rowsOfPoles;

        System.out.println(quantity);
    }
}
