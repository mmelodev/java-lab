
import java.util.*;

public class ApenasPositivos {

	public static void main(String[] args) {
		
		Scanner v = new Scanner (System.in);
		
		int valor;
		
		do {
			System.out.println("\nDigite um valor positivo: \n");
			valor = v.nextInt();
			
			if (valor <= 0) {
				System.out.println("Tente novamente! \n");
			} else {
				System.out.println("\nO valor digitado foi: " + valor);
			}
		} while (valor <= 0);
		
		
		
		//demorei para fazer pq não entendendo a diferença entre o while e do/while
		
		/* Explicação:
		 * Imagine que você quer pedir ao usuário para inserir um número e continuar 
		 * pedindo até que ele insira um número positivo. Usando while, você precisaria de 
		 * uma variável inicializada com um valor negativo para garantir que o loop seja 
		 * executado ao menos uma vez. Com do-while, isso não é necessário, 
		 * pois o bloco é executado primeiro e a condição é avaliada depois. 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
	}

}
