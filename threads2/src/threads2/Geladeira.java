/**
 * Classe responável por implementar o comportamento da geladeira e os métodos para
 * retirar e colocar leite na geladeira.
 */
package threads2;

public class Geladeira {
    private int capacidade = 10;
    private int quantidade = 10; //Inicia em 10 leites
    
    
    /**
     * Retorna a quantidade de leites na geladeira
     * @return um int indicando a quantidade de leites na geladeira
     */
    public synchronized int getQuantidade(){  //retorna a quantidade de leites presentes na geladeira
        return quantidade;
    }
    
    /**
     * Retorna a capacidade da geladeira
     * @return um int indicando a capacidade da geladeira
     */
    public synchronized int getCapacidade(){  //Retorna a capacidade da geladeira
        return capacidade;
    }
    
    /**
     * O método é reponsável por adicionar leites a geladeira
     * @param add a quantiade de leites
     * @param nome o nome de quem adicionou os leites
     */
    private synchronized void adicionar(int add, String nome){
        this.quantidade = quantidade + add; //Adiciona o quantidade de leites passados por parâmetro a quantidade presente na geladeira
        System.out.println(nome + " COMPROU LEITE");  //Sinaliza que os leites da geladeira foram repostos
        alertaQuantidade();  //Chama o método responsável por alertar que foram comprados leites acima do limite
    }
    
    
    /**
     * O método é responsável por retirar um leite da geladeira, sinalizando que foi
     * tomado um litro de leite.
     */
    public synchronized void tomar(){
        quantidade--;  //Diminui 1 da quantidade
    }
    
    /**
     * O método é reponsável por alertar caso a quantidade de itens na geladeira exceda o limite de 10
     */
    private synchronized void alertaQuantidade(){
        if (quantidade > 10) { 
            System.out.println("Quantidade de leites na geladeira: " + quantidade);
            System.out.println("ALERTA! GELADEIRA EXCEDEU O LIMITE DE LEITES!"); //Sinaliza que foram comprados mais leites do que a geladeira comporta
            System.exit(0);  //Finaliza o programa
        }
    }
    
    
    /**
     * O método é responsável por permitir que os monitores da geladeira visualizem q
     * a quantidade de leites da geladeira e possam tomar a decisão de adicionar 
     * mais leites, se estiver abaixo da capacidade da geladeira.
     * 
     * @param nome o nome do monitor que está visualizando a geladeira.
     */
    public synchronized void olhaGeladeira(String nome) {  //Esse método permite que os monitores da geladeira verifiquem a quantide de leite e comprem mais
        if (quantidade < 10){
            adicionar(capacidade - quantidade, nome);
            alertaQuantidade();  //Verifica se excedeu 
        }
    }
}
