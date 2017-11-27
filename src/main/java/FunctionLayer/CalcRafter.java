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
    
    private static int RAFTERSPACEFLAT = 60;
    private static int RAFTERSPACEPITCHED = 60;

    
    public static OrderLine getRafterFlatRoof(int length, int width, Product raft) {
        
        int qty = length / RAFTERSPACEFLAT;
        if (qty % RAFTERSPACEFLAT != 0) qty++;
        raft.setLength(width);

        return new OrderLine(raft, length, qty, "stk.", "Spærtræ");
    }

    public static OrderLine getRafterPitchedRoof(int length, int width, Product raft) {

        int qty = length / RAFTERSPACEPITCHED;
        if (qty % RAFTERSPACEPITCHED != 0) qty++;
        raft.setLength(width);
        
        return new OrderLine(raft, length, qty, "stk.", "Spær sæt");
    }
    
    public static void setRAFTERSPACEFLAT(int RAFTERSPACEFLAT) {
        CalcRafter.RAFTERSPACEFLAT = RAFTERSPACEFLAT;
    }

    public static void setRAFTERSPACEPITCHED(int RAFTERSPACEPITCHED) {
        CalcRafter.RAFTERSPACEPITCHED = RAFTERSPACEPITCHED;
    }
    
}
