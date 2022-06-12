/**
 * Classe main
 */
package threads2;

public class Threads2 {

    public static void main(String[] args) {
        
        Geladeira geladeira2 = new Geladeira ();
        
        //Cria as Threads 
        Thread pai = new Thread (new Pai(geladeira2));
        Thread mae = new Thread (new Mae(geladeira2));
        Thread tio = new Thread (new Tio(geladeira2));
        Thread bebeLeite = new Thread (new BebeLeite (geladeira2));
        
        //Inicia as Threads
        pai.start();
        mae.start();
        tio.start();
        bebeLeite.start(); 
    }
    
}
