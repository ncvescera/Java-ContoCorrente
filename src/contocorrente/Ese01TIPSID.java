/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contocorrente;

/**
 *
 * @author informatica
 */
public class Ese01TIPSID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Contocorrente conto = new Contocorrente("iiosonoiban",100);
        
        conto.prelievo(20);
        conto.versamento(500);
        
        conto.printMovimenti();
    }
    
}
