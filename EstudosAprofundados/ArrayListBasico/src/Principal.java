import br.com.arraylist.modelo.Pessoa;

import java.util.ArrayList;

import java.util.*;

public class Principal {

    public static void main(String[] args) {

        var pessoa1 = new Pessoa();

        pessoa1.setNome("Carlos");
        pessoa1.setIdade(21);
        pessoa1.setAltura(180);

        var pessoa2 = new Pessoa();

        pessoa2.setNome("André");
        pessoa2.setIdade(32);
        pessoa2.setAltura(176);

        var pessoa3 = new Pessoa();

        pessoa3.setNome("João");
        pessoa3.setIdade(44);
        pessoa3.setAltura(192);

        var pessoa4 = new Pessoa();

        pessoa4.setNome("Maria");
        pessoa4.setIdade(55);
        pessoa4.setAltura(165);


        ArrayList<Pessoa> listaDePessoas = new ArrayList<Pessoa>();

        listaDePessoas.add(pessoa1);
        listaDePessoas.add(pessoa2);
        listaDePessoas.add(pessoa3);
        listaDePessoas.add(pessoa4);

        System.out.println("Lista total de pessoas é de: " + listaDePessoas.size() + " pessoas\n");

        System.out.println("A primeira pessoa da lista é: " + listaDePessoas.get(0).getNome() + "\n");

        System.out.println("A lista completa de pessoas: " + listaDePessoas.toString());

    }
}
