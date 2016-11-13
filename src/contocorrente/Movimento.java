package contocorrente;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ncvescera
 */
public class Movimento {

    private int     codice;
    private long    data;
    private float   importo;
    private String  causale;

    /**
     *
     * @param codice
     * @param data
     * @param importo
     * @param causale
     */
    public Movimento(int codice, long data, float importo, String causale) {
        this.codice     = codice;
        this.data       = data;
        this.importo    = importo;
        this.causale    = causale;
    }

    /**
     *
     * @return
     */
    public int getCodice() {
        return this.codice;
    }

    /**
     *
     * @return
     */
    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String date = sdf.format(new Date(data));
        return date;
    }

    /**
     *
     * @return
     */
    public float getImporto() {
        return this.importo;
    }

    /**
     *
     * @return
     */
    public String getCausale() {
        return this.causale;
    }

    /**
     *
     * @param codice
     */
    public void setCodice(int codice) {
        this.codice = codice;
    }

    /**
     *
     * @param importo
     */
    public void setImporto(float importo) {
        if(importo > 0)
            this.importo = importo;
        else
            System.err.println("Importo errato !");
    }

    /**
     *
     * @param causale
     */
    public void setCausale(String causale) {
        if(causale.equals("prelievo") || causale.equals("versamento"))
            this.causale = causale;
        else
            System.err.println("Causale errata !");
    }
}
