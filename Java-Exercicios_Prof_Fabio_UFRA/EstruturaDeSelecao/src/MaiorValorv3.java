
import java.util.*;

public class MaiorValorv3 {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		Scanner v3 = new Scanner (System.in);
		
		System.out.println("Digite o primeiro valor: \n");
		double valor1 = v1.nextDouble();
		System.out.println("\nDigite o segundo valor: \n");
		double valor2 = v2.nextDouble();
		System.out.println("\nDigite o terceiro valor: \n");
		double valor3 = v3.nextDouble();
		
		if (valor1 > valor2 && valor1 > valor3) {
			System.out.println("\nO maior valor é valor é: \n" + valor1);
		} else if (valor2 > valor1 && valor2 > valor3){
			System.out.println("\nO maior valor é valor é: \n" + valor2);
		} else {
			System.out.println("\nO maior valor é valor é: \n" + valor3);
		}


	}

}
