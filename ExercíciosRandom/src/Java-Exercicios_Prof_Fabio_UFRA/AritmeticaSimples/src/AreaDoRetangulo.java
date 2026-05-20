
import java.util.*;

public class AreaDoRetangulo {

	public static void main(String[] args) {
		Scanner b = new Scanner (System.in);
		Scanner a = new Scanner (System.in);

		System.out.println("Qual é o valor da base \n");
		int base = b.nextInt();
		
		System.out.println("\nQual é o valor da altura \n");
		int altura =  a.nextInt();
		
		int area = base * altura;
		
		System.out.println("\nO valor da área é de: " + area);
	}

}
