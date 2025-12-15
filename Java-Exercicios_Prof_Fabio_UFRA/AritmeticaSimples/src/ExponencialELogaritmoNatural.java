
import java.util.*;

public class ExponencialELogaritmoNatural {

	public static void main(String[] args) {
		
		Scanner x = new Scanner (System.in);
		Scanner y = new Scanner (System.in);
		
		System.out.println("Digite o valor de X: \n");
		double valor1 = x.nextDouble();
		
		System.out.println("\nDigite o valor de Y: \n");
		double valor2 = y.nextDouble();
		
		double expo = Math.pow(valor1, valor2);
		
		System.out.println("\nO valor da Exponenciação é de: \n" + expo);

	}

}
