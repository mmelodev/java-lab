package Alura.repeticoes;

import java.util.Scanner;

public class TentativasDeLogin {
    static void main() {
        Scanner s = new Scanner(System.in);
        String senha = "0420"; //a desgraça do java não trabalho direito com zero a esquerda, pqp!

            for (int i = 3; i >= 1; i--){
                System.out.println("Digite sua senha: ");
                String tentativa = s.next();
                if (senha.equals(tentativa)){
                    System.out.println("Senha Correta! Acesso concedido!");
                    break;
                } else {
                    System.out.println("Senha incorreta. Você tem " + (i - 1) + " tentativas restantes");
                }
                if (i == 1) {
                    System.out.println("Conta bloqueada temporariamente.");
                }
            }

    }
}
