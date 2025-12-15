
import java.util.*;

public class GrausVsFahrenheit {

	public static void main(String[] args) {
		
		Scanner c = new Scanner (System.in);
		
		System.out.println("Digite o valor em Celsius (C°): \n");
		double celsius = c.nextDouble();
		
		double fahr = (celsius * 1.8) + 32;
		
		System.out.println("O valor equivalente em Fahrenheit é de: \n" + fahr);
		
		//a
	}

}
