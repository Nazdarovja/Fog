/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 * @author Stanislav
 */
public class PostCalc {

    public static OrderLine getPosts(int length, int width, Product post, String tagtype) {
        //SET POST LENGTH TO STANDARD POST LENGTH
        post.setLength(270);

        //ADD ONE POST FOR EACH CORNER
        int quantity = 4;
        int roofEaves = 0;

        //ROOF EAVES FRONT AND BACK (NO POLES UNDER EAVES) FLATROOF = 1000mm PITCHED ROOF = 800mm
        if (tagtype.equals("fladt")) {
            roofEaves = 1300;
        } else {
            roofEaves = 1100;
        }

        length += -roofEaves;

        // PLACE POLE IN MIDDLE OF EXISTING POLES IF MORE THAN 6M LONG CARPORT 
        if (length >= 6000) {
            quantity += +2;
        }

        return new OrderLine(post, quantity);
    }
}
