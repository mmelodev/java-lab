
import java.util.*;

public class FormulaDeBhaskara {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		Scanner v3 = new Scanner (System.in);
		
		System.out.println("Digite o valor de a: \n");
		double a = v1.nextDouble();
		
		System.out.println("\nDigite o valor de b: \n");
		double b = v2.nextDouble();
		
		System.out.println("\nDigite o valor de c: \n");
		double c = v3.nextDouble();

		
		double delta = Math.pow(b, 2) - 4 * a * c;
		
		double x1 = (-b + Math.sqrt(delta)) / 2 * a;
		
		double x2 = (-b - Math.sqrt(delta)) / 2 * a;
		
		if (delta < 0) {
			System.out.println("\nDelta negativo - Nenhuma raiz \n");
		} else if (x1 == x2) {
			System.out.println("\nDuas raízes iguais, sendo elas: \n" + x1 + " e " + x2);
		} else {
			System.out.println("\nDuas raízes, sendo elas: \n" + x1 + " e " + x2);
		}
	}

}
