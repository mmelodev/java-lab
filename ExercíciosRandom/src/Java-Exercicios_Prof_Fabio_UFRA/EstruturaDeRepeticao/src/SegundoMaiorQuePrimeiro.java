
import java.util.*;

public class SegundoMaiorQuePrimeiro {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		
		double valor1;
		double valor2;
		
		System.out.println("\nO segundo valor sempre deve ser maior que o primeiro! \n");
		
		do {
			System.out.println("\nDigite o primeiro valor: \n");
			valor1 = v1.nextDouble();
			
			System.out.println("\nDigite o segundo valor:  \n");
			valor2 = v2.nextDouble();
			
			if (valor1 > valor2) {
				System.out.println("\nTente novamente!  \n");
			} else {
				System.out.println("\nParabéns, tudo de acordo. \n");
			}
			
		} while (valor1 > valor2);


	}

}
