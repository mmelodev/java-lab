
import java.util.*;

public class LeiDeOhm {

	public static void main(String[] args) {

		Scanner r = new Scanner (System.in);
		Scanner e = new Scanner (System.in);
		
		System.out.println("Digite o valor da resistência: \n");
		double resistencia = r.nextDouble();
		
		System.out.println("Digite o valor da corrente eletrica: \n");
		double celetrica = e.nextDouble();
		
		double volts = resistencia * celetrica;
		
		System.out.println("\nO valor da tesnão de volts (V) é de: \n" + volts);

	}

}
