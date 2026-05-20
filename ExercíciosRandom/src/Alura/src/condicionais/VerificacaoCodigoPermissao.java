package Alura.condicionais;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class VerificacaoCodigoPermissao {
    static void main() {
        int codigoFixo = 2023;
        List<Integer> nivelPermisao = Stream.of(1, 2, 3).toList();

        Scanner e = new Scanner(System.in);

        System.out.println("Digite o código de acesso: ");
        int codigo = e.nextInt();
        System.out.println("Digite o nível de permissão: ");
        int permissao = e.nextInt();

        if (codigo == codigoFixo && nivelPermisao.contains(permissao)){
            System.out.println("Acesso permitido. Bem-vindo ao sistema!");
        } else{
            System.out.println("Acesso Negado!");
        }
    }
}
