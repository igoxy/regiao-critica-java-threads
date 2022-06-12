/**
 * Classe responsável por implemntar o comportamento da Thread pai
 * que monitora a geladeira.
 */
package threads2;

/**
 *
 * @author ifs54
 */
public class Pai implements Runnable{

    private Geladeira geladeira; //Refência do objeto geladeira
    
    public Pai (Geladeira geladeira){
        this.geladeira = geladeira; //Refência do objeto geladeira
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
            geladeira.olhaGeladeira("Pai");  //olha a geladeira
        }
    }
}

