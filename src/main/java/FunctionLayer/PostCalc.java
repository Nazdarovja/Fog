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

    public static OrderLine getPosts(int length, int width, Product post, String roofType) {
        //SET POST LENGTH TO STANDARD POST LENGTH
        post.setLength(270);

        //ADD ONE POST FOR EACH CORNER
        int quantity = 4;
        int roofEaves = 0;
        int roofSideEves = 0;

        //ROOF EAVES FRONT AND BACK (NO POLES UNDER EAVES) FLATROOF = 1000mm PITCHED ROOF = 800mm
        if (roofType.equals("fladt")) {
            //FLAT ROOF
            roofEaves = 1300;
            roofSideEves = 700;
        } else {
            //PITCHED ROOF
            roofEaves = 1100;
            roofSideEves = 400;
        }
        
        //REDUCE THE COMPLETE LENGTHS WITH THE ROOF EVE SIZES
        length += -roofEaves;
        width += -roofSideEves;

        // PLACE POLE IN MIDDLE OF EXISTING POLES IF MORE THAN 6M LONG CARPORT 
        if (length >= 6000) {
            quantity += 2;
        }
        
        // PLACE POLE IN MIDDLE IF WIDTH IS MORE THAN 6M
        
        if (width >= 6000) {
            quantity += +2;
        }

        return new OrderLine(post, quantity);
    }
}
