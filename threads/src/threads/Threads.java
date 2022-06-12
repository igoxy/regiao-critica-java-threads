/**
 * Classe main
 */
package threads;

public class Threads {

    public static void main(String[] args) {
        
        Geladeira geladeira1 = new Geladeira ();
        
        //Cria as Threads 
        Thread pai = new Thread (new Pai(geladeira1));
        Thread mae = new Thread (new Mae(geladeira1));
        Thread tio = new Thread (new Tio(geladeira1));
        Thread bebeLeite = new Thread (new BebeLeite (geladeira1));
        
        //Inicia as Threads
        pai.start();
        mae.start();
        tio.start();
        bebeLeite.start(); 
    }
    
}
