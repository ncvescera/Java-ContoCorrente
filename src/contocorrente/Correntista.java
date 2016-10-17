package contocorrente;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Correntista extends Thread{
    private String          nome;
    private String          ndg;
    private Contocorrente   conto;
    private float           soldi;
    public Correntista(String nome, String ndg, Contocorrente conto, float soldi){
        super();
        
        this.nome   =   nome;
        this.ndg    =   ndg;
        this.conto  =   conto;
        this.soldi  =   soldi;
    }
    
    @Override
    public void run(){
        
            this.conto.prelievo(this.soldi);
            
            System.out.println("Il thread "+this.nome+" ha prelevato: "+this.soldi);
            System.out.println("Saldo: "+this.conto.getSaldo());
            this.conto.printMovimenti();
           
       

    }
}
