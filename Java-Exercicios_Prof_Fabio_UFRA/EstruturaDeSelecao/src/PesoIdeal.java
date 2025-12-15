
import java.util.*;

public class PesoIdeal {

	public static void main(String[] args) {
		
		Scanner p = new Scanner (System.in);
		Scanner a = new Scanner (System.in);
		
		System.out.println("Digite o peso: \n");
		double peso = p.nextDouble();
		
		System.out.println("\nDigite a altura: \n");
		double altura = a.nextDouble();
		
		double pesoreal = peso / Math.pow(altura, 2);
		
		if (pesoreal < 20) {
			System.out.println("\nAbaixo do Peso \n" + pesoreal);
		} else if(pesoreal == 20 || pesoreal < 25) {
			System.out.println("\nPeso Ideal \n" + pesoreal);
		} else {
			System.out.println("\nAcima do Peso \n" + pesoreal);
		}

	}

}
