
import java.util.*;

public class AreaDoQuadrado {

	public static void main(String[] args) {

		Scanner a = new Scanner (System.in);
		
		System.out.println("Qual o valor da arresta? \n");
		int arresta = a.nextInt();
		
		double area = Math.pow(arresta, 2);
		
		System.out.println("\nO valor da área é: " + area);
	}

}
