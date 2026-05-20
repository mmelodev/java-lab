
import java.util.*;

public class MaiorValorv2 {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		
		System.out.println("Digite o primeiro valor: \n");
		double valor1 = v1.nextDouble();
		
		System.out.println("\nDigite o segundo valor: \n");
		double valor2 = v2.nextDouble();
		
		if (valor1 > valor2) {
			System.out.println("\nO maior valor é: \n" + valor1);
		} else if(valor1 == valor2) {
			System.out.println("\nOs valores são iguais. \n");
		} else if(valor2 > valor1) {
			System.out.println("\nO menor valor é: \n" + valor1);
		}

	}

}
