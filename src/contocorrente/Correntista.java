package contocorrente;

public class Correntista extends Thread{
    private String          nome;
    private String          ndg;
    private Contocorrente   conto;
    
    public Correntista(String nome, String ndg, Contocorrente conto){
        super();
        
        this.nome   =   nome;
        this.ndg    =   ndg;
        this.conto  =   conto;
    }
    
    @Override
    public void run(){
        //while(this.conto.getSaldo() > 0)
        //this.conto.versamento(20);
        //if(this.conto.getSaldo()>20)
        for(int i = 0; i < this.conto.getSaldo();i++)
            if(this.conto.getSaldo() >= 20)
                this.conto.prelievo(20);
    }
}
