
import java.util.*;

public class AreaDoQuadrado2 {

	public static void main(String[] args) {

		Scanner d = new Scanner (System.in);
		
		System.out.println("Qual o valor do diagonal ? \n");
		double diagonal = d.nextDouble();
		
		double area = Math.pow(diagonal, 2) / 2;
		
		System.out.println("\nA área é igual a: " + area);
		
	}

}
