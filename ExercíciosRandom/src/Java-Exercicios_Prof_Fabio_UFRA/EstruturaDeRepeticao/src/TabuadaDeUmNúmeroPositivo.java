
import java.util.*;

public class TabuadaDeUmNúmeroPositivo {

	public static void main(String[] args) {
		
		Scanner v = new Scanner (System.in);
		
		System.out.println("\nDigite o valor:  \n");
		int valor = v.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("\n" + valor + " X " + i + " = " + valor * i);
		}

	}

}
