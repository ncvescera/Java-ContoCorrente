package contocorrente;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe per simulare un movimento bancario
 * @author ncvescera
 */
public class Movimento {

    private int     codice;
    private long    data;
    private float   importo;
    private String  causale;

    /**
     * Metodo costruttore
     * @param codice codice identificativo univoco del movimento
     * @param data data in cui è stato effettuato il movimento
     * @param importo somma che è stata versata o prelevata
     * @param causale può essere "prelievo" o "versamento"
     */
    public Movimento(int codice, long data, float importo, String causale) {
        this.codice     = codice;
        this.data       = data;
        this.importo    = importo;
        this.causale    = causale;
    }

    /**
     * Ritorna il codice del movimento
     * @return codice del movimento
     */
    public int getCodice() {
        return this.codice;
    }

    /**
     * Ritorna la data del movimento sotto forma di stringa
     * @return data
     */
    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String date = sdf.format(new Date(data));
        return date;
    }

    /**
     * Ritorna l'importo del movimento
     * @return importo
     */
    public float getImporto() {
        return this.importo;
    }

    /**
     * Ritorna la causale del movimento
     * @return causale
     */
    public String getCausale() {
        return this.causale;
    }

    /**
     * Modifica il codice univoco del movimento
     * @param codice codice univoco del movimento
     */
    public void setCodice(int codice) {
        this.codice = codice;
    }

    /**
     * Modifica l'importo del movimento
     * @param importo soldi prelevati o versati
     */
    public void setImporto(float importo) {
        if(importo > 0)
            this.importo = importo;
        else
            System.err.println("Importo errato !");
    }

    /**
     * Modifica la causale del movimento
     * @param causale causale del movimento
     */
    public void setCausale(String causale) {
        if(causale.equals("prelievo") || causale.equals("versamento"))
            this.causale = causale;
        else
            System.err.println("Causale errata !");
    }
}
