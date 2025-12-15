
import java.util.*;

public class PesoIdealv2 {

	public static void main(String[] args) {
		
		Scanner p = new Scanner (System.in);
		Scanner a = new Scanner (System.in);
		Scanner s = new Scanner (System.in);
		
		System.out.println("Digite o peso: \n");
		double peso = p.nextDouble();
		
		System.out.println("\nDigite a altura: \n");
		double altura = a.nextDouble();
		
		System.out.print("\nDigite o sexo: \n");
		String sexo = s.nextLine();
		
		double r = peso / Math.pow(altura, 2);
		
		if (sexo.equals("feminino") || sexo.equals("Feminino")) {
			if (r < 19) {
				System.out.println("\nAbaixo do Peso \n");
			} else if(r < 24) {
				System.out.println("\nPeso Ideal \n");
			} else {
				System.out.println("\nAcima do Peso \n");
			}
		} else if (sexo.equals("masculino") || sexo.equals("Masculino")) {
			if (r < 20) {
				System.out.println("\nAbaixo do Peso \n");
			} else if(r < 25) {
				System.out.println("\nPeso Ideal \n");
			} else {
				System.out.println("\nAcima do Peso \n");
			}
		}

	}

}
