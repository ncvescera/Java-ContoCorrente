package contocorrente;

/**
 * Classe di avvio contenente il main
 * @author ncvescera
 */
public class Ese01TIPSID {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        
        Contocorrente conto = new Contocorrente("iiosonoiban",400);
        
        /*
            Due correntisti, uno che preleva e l'altro che versa
            senza errori
        */
        /*
        Correntista uno = new Correntista("UNO","aaa",conto,"prelievo",100);
        Correntista due = new Correntista("DUE","bbb",conto,"versamento",200);
        
        uno.start();
        due.start();
        
        uno.join();
        due.join();
        */
        
        //--------------------------------------------------------//
        
        /*
            Due correntisti, uno che preleva e l'altro che versa
            con errori
        */
        /*
        Correntista uno = new Correntista("UNO","aaa",conto,"prelievo",700);
        Correntista due = new Correntista("DUE","bbb",conto,"versamento",200);
        
        uno.start();
        due.start();
        
        uno.join();
        due.join();
        */
        
        //--------------------------------------------------------//
        
        /*
            Più concorrenti che prelevano e versano anche con saldo inferiore
            per vedere come sono gestiti bene gli eventuali casi di errori
        */
       
        Correntista uno = new Correntista("UNO","aaa",conto,"prelievo",700);
        Correntista due = new Correntista("DUE","bbb",conto,"versamento",200);
        Correntista tre = new Correntista("TRE","ccc",conto,"prelievo",500);
        Correntista quattro = new Correntista("QUATTRO","ddd",conto,"prelievo",100);
        
        uno.start();
        due.start();
        tre.start();
        quattro.start();
        
        uno.join();
        due.join();
        tre.join();
        quattro.join();
        
        
        conto.printMovimenti();
        System.out.println("Totale conto: "+conto.getSaldo());
        
    }
    
}
