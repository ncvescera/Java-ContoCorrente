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
