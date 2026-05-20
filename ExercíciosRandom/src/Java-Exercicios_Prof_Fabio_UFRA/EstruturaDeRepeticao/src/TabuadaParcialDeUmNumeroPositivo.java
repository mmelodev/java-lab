
import java.util.*;

public class TabuadaParcialDeUmNumeroPositivo {

	public static void main(String[] args) {
	
		Scanner x = new Scanner (System.in);
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		
		System.out.println("\nDigite o valor (X) qualquer: \n");
		int valorgeral = x.nextInt();
		
		System.out.println("\nDigite o primeiro valor: \n");
		int valor1 = v1.nextInt();
		
		System.out.println("\nDigite o segundo valor:  \n");
		int valor2 = v2.nextInt();
		
		
		if (valorgeral >= 0 && valor2 > valor1) {
			for (int i = valor2; i >= valor1; i--) {
				System.out.println(valorgeral + " X " + i + " = " + valorgeral * i );
			}
		}
		//esse demorei um pouco mais, pois a lógica dentro do for me confundiu
	}

}
