package contocorrente;

/**
 *
 * @author informatica
 */
public class Ese01TIPSID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Contocorrente conto = new Contocorrente("iiosonoiban",500);
        /*
        conto.prelievo(20);
        conto.versamento(500);
        
        conto.printMovimenti();
        */
        Correntista uno = new Correntista("UNO","aaa",conto,100);
        Correntista due = new Correntista("DUE","bbb",conto,200);
        
        uno.start();
        due.start();
        
        uno.join();
        due.join();
        
        conto.printMovimenti();
        System.out.println("Totale conto: "+conto.getSaldo());
        
    }
    
}
