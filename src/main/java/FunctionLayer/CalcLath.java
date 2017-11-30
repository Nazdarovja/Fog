/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import PresentationLayer.Calculate;
import java.util.List;

/**
 *
 * @author Orchi
 */
public class CalcLath {
    
    public static OrderLine calculateRegularLath(int length, int width, List<Product> laths) {
        Product lath = Calculator.getCorrectLengthProduct(length, laths);
        int quantity = 0;
        
        // bredden skal fodres til denne metode fra en anden algoritme metode.
        lath.setLength(length);
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
        quantity *= 2; // for both sides
        quantity++;
        // hvis længden på carport er mindre end 5400 mm, hva så?? bare giv dem en hel 5400mm til hver lægte?? nemmere for savning
        return new OrderLine(lath, length, quantity, "stk", "Til montering på spær");
    }
    
    public static OrderLine calculateTopLath(int length, int width, List<Product> laths) {
        Product lath = Calculator.getCorrectLengthProduct(length, laths);
        int quantity = 1;
        // varierer længden alt efter længden på carport???? Eller er toplægten 420 cm som standard??
        // 2 toplægter til hver side af taget på carport
        // Længden af toplægten er kortere end normallægterne
        lath.setLength(length);
        return new OrderLine(lath, length, quantity, "stk", "Toplægte til montering af rygsten lægges i toplægteholder");
    }
    
    public static OrderLine calculateDoorZLath(int length, int width, List<Product> laths) {
        Product lath = Calculator.getCorrectLengthProduct(length, laths);
        int quantity = 1;
        lath.setLength(length);
        // hvis dør, på skur??
        return new OrderLine(lath, length, quantity, "stk", "til z på bagside af dær");
    }
    
}
