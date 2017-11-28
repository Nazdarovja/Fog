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
public class CalcShackCladding {

    //CLADDING = (side)BEKLÆDNINGsbræt
    //bruges monteres vertikalt på Transom/løsholt i 2 lags mønster:
    //--------------------     løsholt
    //  --|--   --|--       cladding, inner
    //      --|--           cladding, outer
    public static OrderLine getCladdingForShackFlatRoof(int shackLength, int shackWidth, int carportHeight, List<Product> claddingList) throws Exception {

        //CM TO MM
        shackWidth = shackWidth * 10;
        shackLength = shackLength * 10;
        carportHeight = carportHeight * 10;

        double lengthToBeCovered = shackLength * 2;  //2 sides
        double widthToBeCovered = shackWidth * 2;    //2 sides
        double bufferBetweenCladding = 60;  //mm

        Product cladding = getCorrectLengthProduct(carportHeight, claddingList);

        double innerCladdingLayerLength = lengthToBeCovered / (cladding.getWidth() + bufferBetweenCladding);
        double innerCladdingLayerWidth = widthToBeCovered / (cladding.getWidth() + bufferBetweenCladding);
        double innerCladdingLayer = innerCladdingLayerLength + innerCladdingLayerWidth;

        double res = (innerCladdingLayer * 2) - 4;  //1 on 2; 1 less each side * 4 = 4;

        int result = (int) Math.ceil(res);
        return new OrderLine(cladding, cladding.getLength(), result, "stk", "til beklædning af skur 1 på 2");

    }

    private static Product getCorrectLengthProduct(int height, List<Product> products) {
        // Sorts list on product.getLength() attribute.
        products.sort(Comparator.comparing(Product::getHeight));
        // We need the list in descending order, so we reverse order it, so we start with the longest length.
        Collections.reverse(products);

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            // if the products is longer than product available, the product is set to the largest in stock
            // else if the product is shorter than the shortest available product, the product is set as the smallest in stock
            // in regular cases it will chose the appropriate size product for the length
            if (height / p.getHeight() >= 1 || i == products.size() - 1) {
                return p;
            }
        }
        return null;
    }
}
