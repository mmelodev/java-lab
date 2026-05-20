
import java.util.*;

public class MaiorValor {

	public static void main(String[] args) {

		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		
		System.out.println("Digite o primeiro valor: \n");
		double valor1 = v1.nextDouble();
		
		System.out.println("\nDigite o segundo valor: \n");
		double valor2 = v2.nextDouble();
		
		if (valor1 > valor2) {
			System.out.println("\nO maior valor é: \n" + valor1);
		} else {
			System.out.println("\nO maior valor é: \n" + valor2);
		}
	}

}
