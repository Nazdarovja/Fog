/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CalcShackPost {
//samme logik som calcpost..husk at se samlevejledning igennem...
    //evt se på Mathias "tegning" branch logic
    //skur hæfter på pæle, der skal sidde på [sidelangedelene]...
    //løsholter = horisontale "murindmad" til alle 4 vægge. 

    public static OrderLine getPostsShackFlatRoof(int carportLength, int carportWidth, int height, int shackLength, int shackWidth, List<Product> products) {

        //post to use
        Product post = getCorrectLengthProduct(height, products);

        //shack initially connected to existing carport corner pole, so need 1 more, and one extra for door.
        int numberOfPost = 2;

        //if shack does not take up full width of carport width; use an extra pole for each corner. 
        if (carportWidth < shackWidth) {
            numberOfPost += 2;

            
        }
    }

    private static Product getCorrectLengthProduct(int height, List<Product> products) {
        // Sorts list on product.getLength() attribute.
        products.sort(Comparator.comparing(Product::getLength));
        // We need the list in descending order, so we reverse order it, so we start with the longest length.
        Collections.reverse(products);

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            // if the products is longer than product available, the product is set to the largest in stock
            // else if the product is shorter than the shortest available product, the product is set as the smallest in stock
            // in regular cases it will chose the appropriate size product for the length
            if (height / p.getLength() >= 1 || i == products.size() - 1) {
                return p;
            }
        }
        return null;
    }

}
