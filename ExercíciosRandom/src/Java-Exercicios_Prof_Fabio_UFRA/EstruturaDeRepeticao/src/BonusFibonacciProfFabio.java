
import java.util.*;

public class BonusFibonacciProfFabio {

	public static void main(String[] args) {
		
		//Neste exercicio, foi desfiado um programa que o usuário digitasse um número até onde iria a sequencia fibonacci
		//pelo o que eu lembro
		
		Scanner v = new Scanner (System.in);
		
		System.out.println ("Digite um número: \n");
		int valor = v.nextInt();
		
		int numero = 0;
		int numero2 = 1;
		int proximo;
		
		
		for (int i = 1; i <= valor; i++) {
			proximo = numero + numero2;
			numero = numero2;
			numero2 = proximo;
			System.out.print(proximo + " ");
		}

	}

}
