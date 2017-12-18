/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import PresentationLayer.Calculate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Orchi
 */
public class CalcLath {
    
    public static OrderLine calculateRegularLath(int length, int width, List<Product> products) {
        int quantity = 0;
        
        // bredden skal fodres til denne metode fra en anden algoritme metode.
        Product p = getCorrectLengthProduct(length, products);
        // this is the length for each row of lath
        // lægtelængden
        //øverste taglægte placeres 30mm fra spidsen af spæret og herefter skal der væres 307mm til næste lægte.
        width -= 30;
        //int teglafstand
        // get lægte product from db
        //nederste taglægte placeres nederst på spærhoved og næste lægte placeres 350 mm fra den.
        width -= 350;
        quantity += 2;
        //resterende lægter tilføjes
        quantity += width / 307;
        //1 tilføjes til tilpasning
        // hvis længden på carport er mindre end 5400 mm, hva så?? bare giv dem en hel 5400mm til hver lægte?? nemmere for savning
        
        //if more than one lath is required for each row -> we calculate how many is required per row except the 'rest' which we deal with next 
        if(length / p.getLength() >= 2)
            quantity *= length / p.getLength();
        
        if (length % p.getLength() > 0 && length > p.getLength()) {
            // finds the full length of the remaining pieces, and then how many of the product there is need for to cover that length
            int extraPostsIfInsuficcientLength = ((length % p.getLength()) * quantity) / p.getLength();
            // checks if there still is a piece remaining after, and adds one additional product
            if (((length % p.getLength()) * quantity) % p.getLength() > 0) {
                extraPostsIfInsuficcientLength++;
            }
            quantity += extraPostsIfInsuficcientLength;
        }
        
        quantity *= 2; // for both sides
        
        return new OrderLine(p, length, quantity, "stk", "Til montering på spær");
    }
    

    public static OrderLine calculateTopLath(int length, int width, List<Product> products) {
        int quantity = 1;
        Product p = getCorrectLengthProduct(length, products);
        // varierer længden alt efter længden på carport???? Eller er toplægten 420 cm som standard??
        // 2 toplægter til hver side af taget på carport
        // Længden af toplægten er kortere end normallægterne
        
        if(length / p.getLength() >= 2)
            quantity *= length / p.getLength();
        
        if (length % p.getLength() > 0 && length > p.getLength()) {
            // finds the full length of the remaining pieces, and then how many of the product there is need for to cover that length
            int extraPostsIfInsuficcientLength = ((length % p.getLength()) * quantity) / p.getLength();
            // checks if there still is a piece remaining after, and adds one additional product
            if (((length % p.getLength()) * quantity) % p.getLength() > 0) {
                extraPostsIfInsuficcientLength++;
            }
            quantity += extraPostsIfInsuficcientLength;
        }
        
        return new OrderLine(p, length, quantity, "stk", "Toplægte til montering af rygsten lægges i toplægteholder");
    }
    

    public static OrderLine calculateDoorZLath(int length, int width, List<Product> products) {
        int quantity = 1;
        
        Product p = getCorrectLengthProduct(length, products);
        
        if(length / p.getLength() >= 2)
            quantity *= length / p.getLength();
        
        if (length % p.getLength() > 0 && length > p.getLength()) {
            // finds the full length of the remaining pieces, and then how many of the product there is need for to cover that length
            int extraPostsIfInsuficcientLength = ((length % p.getLength()) * quantity) / p.getLength();
            // checks if there still is a piece remaining after, and adds one additional product
            if (((length % p.getLength()) * quantity) % p.getLength() > 0) {
                extraPostsIfInsuficcientLength++;
            }
            quantity += extraPostsIfInsuficcientLength;
        } //TODO FIX THIS SHIT
        
        // hvis dør, på skur??
        return new OrderLine(p, length, quantity, "stk", "til z på bagside af dær");
    }
    
    private static Product getCorrectLengthProduct(int length, List<Product> products) {
        // Sorts list on product.getLength() attribute.
        products.sort(Comparator.comparing(Product::getLength));
        // We need the list in descending order, so we reverse order it, so we start with the longest length.
        Collections.reverse(products);

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            // if the products is longer than product available, the product is set to the largest in stock
            // else if the product is shorter than the shortest available product, the product is set as the smallest in stock
            // in regular cases it will chose the appropriate size product for the length
            if (length / p.getLength() >= 1 || i == products.size() - 1) {
                return p;
            }
        }
        return null;
    }
    
}
