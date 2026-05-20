
import java.util.*;

public class CurriculoExe {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		Scanner novonome = new Scanner (System.in);
		
		Curriculo novoCurriculo = new Curriculo();
		
		String continuar = "s";
		
		System.out.printf("\nDigite seu nome: \n");
		String meunome = novonome.nextLine();
		
		while(continuar.equalsIgnoreCase("s")) {
			
			System.out.printf("\nDigite sua experiência (Para finalizar digite ´fim´)\n");
			String meuXp = input.nextLine();
			
			if(meuXp.equalsIgnoreCase("fim")) {
				break;
			}
			
			novoCurriculo.setNome(meunome);
			
			novoCurriculo.setXp(meuXp);
			
			System.out.printf("\nDeseja adicionar outra experiência? Digite s ou n\n");
			continuar = input.nextLine();
		}
			
		novoCurriculo.Mensagem();
	}

}
