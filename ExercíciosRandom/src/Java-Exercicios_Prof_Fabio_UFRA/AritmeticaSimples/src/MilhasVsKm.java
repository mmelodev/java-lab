
import java.util.*;

public class MilhasVsKm {

	public static void main(String[] args) {
		
		Scanner km = new Scanner (System.in);

		System.out.println("Vamos converter KM para Milhas Marítimas! \n");
		
		System.out.println("Digite a quantidade de KM: \n");
		double kilomt = km.nextDouble();
		
		double milhamt = kilomt / 1.852;
		
		System.out.println("\nO valor convertido de km para milha maritima é de: \n" + milhamt);
	}

}
