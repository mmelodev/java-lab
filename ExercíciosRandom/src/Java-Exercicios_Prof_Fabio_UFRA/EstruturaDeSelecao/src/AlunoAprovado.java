
import java.util.*;

public class AlunoAprovado {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		
		System.out.println("Digite o valor da primeira nota: \n");
		double p1 = v1.nextDouble();
		
		System.out.println("\nDigite o valor da segunda nota: \n");
		double p2 = v2.nextDouble();
		
		double media = (p1 + (2 * p2)) / 3;
		
		if (media >= 5) {
			System.out.println("\nAprovado \n");
		} else {
			System.out.println("\nReprovado \n");
		}
	}

}
