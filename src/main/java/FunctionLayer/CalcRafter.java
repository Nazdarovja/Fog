/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Mellem
 */
public class CalcRafter {
    public static OrderLine getRafterFlatRoof(int length, int width, Product raft) {
        
        int qty = length / 60;
        if (qty % 60 != 0) qty++;
        raft.setLength(width);
        
        return new OrderLine(raft, length, qty, "stk.", "Spærtræ");
    }


    
    public static OrderLine getRafterPitchedRoof(int length, int width, Product raft) {

        int qty = length / 60;
        if (qty % 60 != 0) qty++;
        raft.setLength(width);
        
        return new OrderLine(raft, length, qty, "stk.", "Spær sæt");
    }
    
    
    
    public static void main(String[] args) {
        
        System.out.println(270/30);
        System.out.println(270/60);
        System.out.println(270/90);
        System.out.println(270/120);
        
        
        
    }
    
}
