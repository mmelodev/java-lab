
import java.util.*;

public class Fibonacci {

	public static void main(String[] args) {
		
		int numero = 0;
		int numero2 = 1;
		int proximo;
		
		
		for (int i = 1; i <= 30; i++) {
			proximo = numero + numero2;
			numero = numero2;
			numero2 = proximo;
			System.out.print(proximo + " ");
		}

		//esse foi dificil
	}

}
