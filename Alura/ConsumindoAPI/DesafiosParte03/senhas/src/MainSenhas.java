import java.util.Scanner;

public class MainSenhas {
    public static void main(String[] args) {
        System.out.println("\nValidação de Senhas\n");

        try {
            Scanner s = new Scanner(System.in);

            System.out.println("Digite sua senha: " +
                    "\n(Pelo menos 8 caracteres)\n>>");
            String senha = s.nextLine();

            if (senha.length() > 8) {
                throw new ErroCasoSenhaOito("\nA senha não pode ter mais que oito caracteres");
            } else{
                System.out.println("\nSenha Salva com Sucesso!");
            }
        } catch (ErroCasoSenhaOito e){
            System.out.println(e.getMessage());
        }
    }
}
