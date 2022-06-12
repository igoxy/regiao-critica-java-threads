/**
 * A classe implementa a Thread responsável por beber leite ao acordar.
 */
package threads2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BebeLeite implements Runnable{
    
    private Geladeira geladeira;
    Random gerar = new Random();  //Utilizado para gerar os números aleatórios para a Thread beber leite dormir

    public BebeLeite(Geladeira geladeira) {  //Construtor 
        this.geladeira = geladeira;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("BEBE LEITE");  //Sinaliza que bebeu leite
            geladeira.tomar();
            System.out.println("Quantidade de leites na geladeira: " + geladeira.getQuantidade()+ "\n");
            try {
                Thread.sleep(gerar.nextInt(500));
            } catch (InterruptedException ex) {
                Logger.getLogger(BebeLeite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
