package contocorrente;

/**
 * Classe che simula un utente del conto corrente abilitato a prelevare e versare soldi in un conto
 * @author ncvescera
 */
public class Correntista extends Thread{
    private String          nome;
    private String          ndg;
    private Contocorrente   conto;
    private float           soldi;
    private String          azione;
    
    /**
     * Metodo costruttore
     * @param nome nome del correntista
     * @param ndg numero identificativo
     * @param conto conto sul quale deve operare 
     * @param azione può essere "preleva" o "versa"
     * @param soldi quantià di soldi da prelevare o versare
     */
    public Correntista(String nome, String ndg, Contocorrente conto, String azione, float soldi){
        super();
        
        this.nome   =   nome;
        this.ndg    =   ndg;
        this.conto  =   conto;
        this.soldi  =   soldi;
        this.azione =   azione;
    }
    
    @Override
    public void run(){
        if(this.azione.equals("prelievo")){
            this.conto.prelievo(this.soldi);
            System.out.println("Il thread "+this.nome+" ha prelevato: "+this.soldi);
        }
        else if(this.azione.equals("versamento")){
            this.conto.versamento(this.soldi);
            System.out.println("Il thread "+this.nome+" ha versato: "+this.soldi);
        }
       

    }
}
