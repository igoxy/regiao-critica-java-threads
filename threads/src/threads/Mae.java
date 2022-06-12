/**
 * Classe responsável por implemntar o comportamento da Thread mãe
 * que monitora a geladeira.
 */
package threads;

public class Mae implements Runnable{

    private Geladeira geladeira; //Refência do objeto geladeira
   
    /**
     * Construtor
     * 
     * @param geladeira a geladeira
     */
    public Mae (Geladeira geladeira){
        this.geladeira = geladeira; 
    }
    
    @Override
    public void run() {
        while (true) {
            /* O for abaixo é utilizado para consumir recurso antes de adicionar o quanto falta para completar a geladeira.
            Isso permite que mais de uma Thread verifique que ao mesmo tempo que falta leite na geladeira.
            Sem isso, devido a pouca complexidade do código, as Threads executam muito rápido.
            */
            int x = 0;
                for (int i = 0; i < 100000; i++ ){
                    x++;
                }
             //Fim do for para gastar recruso
            if (geladeira.getQuantidade() < geladeira.getCapacidade()){  //Verifica se a geladeira está abaixo da capacidade
                geladeira.adicionar(1, "Mae"); //Incrementa de 1 a 1 até chegar na quantidade máxima da geladeira (simula a compra de mais leite)
            }
        }
    }
}
    

