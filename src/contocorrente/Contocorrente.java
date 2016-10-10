package contocorrente;

import java.util.ArrayList;

public class Contocorrente {

    private String      iban;
    private float       saldo;
    private ArrayList   movimenti;
    private int         n_movimenti;

    public Contocorrente(String iban, float saldo) {
        this.iban           =   iban;
        this.saldo          =   saldo;
        this.movimenti      =   new ArrayList();
        this.n_movimenti    =   0;
    }

    public void prelievo(int prelievo) {
        if(prelievo > 0 && prelievo > this.saldo){
           this. saldo -= prelievo;
           this.movimenti.add(new Movimento(++this.n_movimenti,System.currentTimeMillis(),prelievo,"prelievo"));
        }
        else
            System.err.println("Importo errato !");
    }

    public void versamento(int versamento) {
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void printSaldo() {
        System.out.println(this.saldo);
    }

    public void printMovimenti() {
    }
}
