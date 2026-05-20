
import java.util.*;

public class TerrenoGrandeVsTerrenoPequeno {

	public static void main(String[] args) {
		
		Scanner b = new Scanner (System.in);
		Scanner a = new Scanner (System.in);
		
		System.out.println("Digite o valor da base: \n");
		double base = b.nextDouble();
		
		System.out.println("\nDigite o valor da altura: \n");
		double altura = a.nextDouble();
		
		double area = base * altura;
		
		if (area >= 100) {
			System.out.println("\nTerreno Grande\n");
		} else {
			System.out.println("\nTerreno Pequeno \n");
		}
	}
}