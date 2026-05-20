
import java.util.*;

public class TesteMsgp2 {

	public static void main(String[] args) {
		
		Scanner n = new Scanner (System.in);
		
		TesteMsgp1 novaSaudacao = new TesteMsgp1();
		
		System.out.println("Digite seu nome: \n");
		String seunome = n.nextLine();
		
		novaSaudacao.Saudacao(seunome);
	}

}
