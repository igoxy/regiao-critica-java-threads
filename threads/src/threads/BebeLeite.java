/**
 * A classe implementa a Thread responsável por beber leite ao acordar.
 */
package threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BebeLeite implements Runnable{
    
    private Geladeira geladeira;
    Random gerar = new Random();  //Utilizado para gerar um tempo aleatórios para a Thread beber leite dormir

    /**
     * Construtor
     * 
     * @param geladeira a geladeira
     */
    public BebeLeite(Geladeira geladeira) {
        this.geladeira = geladeira;
    }

    @Override
    public void run() {
        while (true) {
            geladeira.tomou();  //Toma um litro de leite
            System.out.println("BEBE LEITE");  //Sinaliza que bebeu leite
            System.out.println("Quantidade de leites na geladeira: " + geladeira.getQuantidade()); //Exibe a quantidade de leites na geladeira
            try {
                Thread.sleep(gerar.nextInt(500));  //Faz a Thread dormir por um intervalo de tempo
            } catch (InterruptedException ex) {
                Logger.getLogger(BebeLeite.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
    } 
}
