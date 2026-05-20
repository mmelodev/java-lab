package Alura.condicionais;

import java.util.Scanner;

public class ValidacaoSenha {
    static void main() {
        String senhaDefinida = "12345";

        Scanner s = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = s.next();

        if (senha.equalsIgnoreCase(senhaDefinida)){
            System.out.println("Acesso permitido!");
        } else{
            System.out.println("Acesso Negado!");
        }
    }
}
