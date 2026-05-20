
import java.util.*;

public class SexoMOuF {

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		
		String sexo;
				
		do {
			System.out.println("\nDigite o seu sexo: \n");
			sexo = s.next();
			
			if (sexo.equals("M") || sexo.equals("F")) {
				System.out.println("\nRegistrado \n");
			} else {
				System.out.println("\nTente Novamente \n");
			}
			
		} while(!sexo.equals("M") && !sexo.equals("F"));

	}

}
