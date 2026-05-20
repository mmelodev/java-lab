package contabancaria;

import java.util.ArrayList;

public class ListasDeContas {
    public static void main(String[] args) {
        var conta1 = new ContaBancaria(200);

        var conta2 = new ContaBancaria(560);

        var conta3 = new ContaBancaria(600);

        var conta4 = new ContaBancaria(470);

        var conta5 = new ContaBancaria(800);

        ArrayList<ContaBancaria> listaDeContasBancarias = new ArrayList<>();

        listaDeContasBancarias.add(conta1);
        listaDeContasBancarias.add(conta2);
        listaDeContasBancarias.add(conta3);
        listaDeContasBancarias.add(conta4);
        listaDeContasBancarias.add(conta5);

        double valorAtual = 0;

        for (ContaBancaria conta : listaDeContasBancarias){

            if (conta.getSaldo() > valorAtual){
                valorAtual = conta.getSaldo();
            }
        }

        System.out.println("O maior valor é: R$ " + valorAtual);
    }
}
