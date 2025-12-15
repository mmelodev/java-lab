
import java.util.*;

public class VolumeDoCone {

	public static void main(String[] args) {
		
		Scanner a = new Scanner (System.in);
		Scanner r = new Scanner (System.in);
		
		System.out.println("Qual é a altura do Cone? \n");
		double altura = a.nextDouble();
		
		System.out.println("\nQual é o raio do Cone? \n");
		double raio = r.nextDouble();
		
		double volume = (altura * Math.PI * Math.pow(raio, 2)) / 3;
		
		System.out.println("\nO volume do cone é de: " + volume);

	}

}
