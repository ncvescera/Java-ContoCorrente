package contocorrente;

import java.util.ArrayList;

/**
 * Classe condivisa dove più threads accedono per modificare la variabile condivisa saldo
 * @author ncvescera
 */
public class Contocorrente {

    private String                  iban;
    private float                   saldo;
    private ArrayList<Movimento>    movimenti;
    private int                     n_movimenti;

    private boolean isFree = true;

    /**
     * Metodo costruttore
     * @param iban identificativo del conto
     * @param saldo soldi con cui inizierà il conto
     */
    public Contocorrente(String iban, float saldo) {
        this.iban           =   iban;
        this.saldo          =   saldo;
        this.movimenti      =   new ArrayList();
        this.n_movimenti    =   0;
    }

    /**
     * Preleva i soldi dal conto
     * @param prelievo soldi da prelevare
     */
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

    /**
     * Versa i soldi nel conto
     * @param versamento soldi da versare
     */
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

    /**
     * Restituisce il saldo attuale
     * @return saldo del conto
     */
    public float getSaldo() {
        return this.saldo;
    }

    /**
     *  Stampa il saldo
     */
    public void printSaldo() {
        System.out.println(this.saldo);
    }

    /**
     *  Stampa la lista movimenti
     * @see Movimento
     */
    public void printMovimenti() {
        for(Movimento elem:this.movimenti){
            System.out.println("Codice: "+elem.getCodice()+"\nData: "+elem.getData()+"\nImporto: "+elem.getImporto()+"\nCausale: "+elem.getCausale()+"\n");
        }
    }
}
