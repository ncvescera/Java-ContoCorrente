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
    synchronized public void run(){
        //while(this.conto.getSaldo() > 0)
        //this.conto.versamento(20);
        //if(this.conto.getSaldo()>20)
        //for(int i = 0; i < this.conto.getSaldo();i++)
        if(this.conto.getSaldo() >= this.soldi){
            this.conto.prelievo(this.soldi);
            System.out.println("Il thread "+this.nome+" ha prelevato: "+this.soldi);
            System.out.println("Saldo: "+this.conto.getSaldo());
            this.conto.printMovimenti();
            this.notify();
        }
        //else if(this.conto.getSaldo()-this.soldi <= 0){
        //    this.
        //}
        else{
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Correntista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
