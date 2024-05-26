
package ViewNovo;

import ModelNovo.Servico;

/**
 *
 * @author lucca
 */
public class Main {
    
    public static void main(String[] args){
        String nome = "tiago";
        System.out.println(nome);
        
        Servico servico = new Servico(1, "barba", 30);
        System.out.println(servico.getDescricao());
    }
    
}
