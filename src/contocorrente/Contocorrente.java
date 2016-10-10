package contocorrente;

import java.util.ArrayList;

public class Contocorrente {

    private String iban;

    private float saldo;

    private ArrayList movimenti;

    private int n_movimenti;

    public Contocorrente(String iban, float saldo) {
    }

    public void prelievo(int prelievo) {
    }

    public void versamento(int versamento) {
    }

    public int getSaldo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void printSaldo() {
    }

    public void printMovimenti() {
    }
}
