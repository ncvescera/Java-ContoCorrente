package contocorrente;

import java.util.ArrayList;

public class Contocorrente {

    private String                  iban;
    private float                   saldo;
    private ArrayList<Movimento>    movimenti;
    private int                     n_movimenti;

    private boolean isFree = true;
    public Contocorrente(String iban, float saldo) {
        this.iban           =   iban;
        this.saldo          =   saldo;
        this.movimenti      =   new ArrayList();
        this.n_movimenti    =   0;
    }

    public synchronized void prelievo(float prelievo) {
        while(!this.isFree){
            try{
                wait();
            } catch(InterruptedException e){
                System.err.println(e);
            }
        }
        this.isFree = false;
        if(prelievo > 0 && prelievo <= this.saldo){
           this. saldo -= prelievo;
           this.movimenti.add(new Movimento(++this.n_movimenti,System.currentTimeMillis(),prelievo,"prelievo"));
        }
        else
            System.err.println("Importo errato !");
        this.isFree = true;
        notify();
    }

    public synchronized void versamento(float versamento) {
        while(!this.isFree){
            try{
                wait();
            } catch(InterruptedException e){
                System.err.println(e);
            }
        }
        this.isFree = false;
        if(versamento > 0){
            this.saldo += versamento;
            this.movimenti.add(new Movimento(++this.n_movimenti,System.currentTimeMillis(),versamento,"versamento"));
        }
        else
            System.err.println("Importo errato !");
        this.isFree = true;
        notify();
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void printSaldo() {
        System.out.println(this.saldo);
    }

    public void printMovimenti() {
        for(Movimento elem:this.movimenti){
            System.out.println("Codice: "+elem.getCodice()+"\nData: "+elem.getData()+"\nImporto: "+elem.getImporto()+"\nCausale: "+elem.getCausale()+"\n");
        }
    }
}
