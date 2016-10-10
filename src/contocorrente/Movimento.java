package contocorrente;

import java.util.Date;

public class Movimento {

    private int     codice;
    private Date    data;
    private float   importo;
    private String  causale;

    public Movimento(int codice, Date data, float importo, String causale) {
        this.codice     = codice;
        this.data       = data;
        this.importo    = importo;
        this.causale    = causale;
    }

    public int getCodice() {
        return this.codice;
    }

    public Date getData() {
        return this.data;
    }

    public float getImporto() {
        return this.importo;
    }

    public String getCausale() {
        return this.causale;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setImporto(float importo) {
        if(importo > 0)
            this.importo = importo;
        else
            System.err.println("Importo errato !");
    }

    public void setCausale(String causale) {
        if(causale.equals("prelievo") || causale.equals("versamento"))
            this.causale = causale;
        else
            System.err.println("Causale errata !");
    }
}
