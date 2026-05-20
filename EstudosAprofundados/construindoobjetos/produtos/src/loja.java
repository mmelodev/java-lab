import br.com.construindoobjetos.modelos.*;
import br.com.construindoobjetos.modelos.Produto;

import java.util.ArrayList;

public class loja {
    public static void main(String[] args) {
        var imperio = new Cerveja("Império", 11.90, 2);

        var rexona = new Desodorante("Rexona", 14.90, 1);

        var negresco = new Biscoito("Negresco", 2.50, 4);

        var colgate = new CremeDental("Colgate", 5.65, 2);

        var bono =  new Biscoito("Bono", 3, 5);

        var arroz = new ProdutoPerecivel("Fazenda", 5, 1, "30/09/2025");

        ArrayList<Produto> listadeprodutos = new ArrayList<>();

        listadeprodutos.add(imperio);
        listadeprodutos.add(rexona);
        listadeprodutos.add(negresco);
        listadeprodutos.add(colgate);
        listadeprodutos.add(bono);
        listadeprodutos.add(arroz);

        System.out.println("\nO total de produtos adicionados foi de: " + listadeprodutos.size() + "\n");

//        Scanner i = new Scanner(System.in);
//
//        System.out.println("\nDigite o indice do produto que deseja ver as informações: \n");
//        int indice = i.nextInt();
//
//        if (indice){
//
//        } //-> como puxar o indice do array através do input de um usuário?

        System.out.println("\nO produto no indice zero é: " + listadeprodutos.get(0).getNome() + "\n");
        System.out.println("\nO produto no indice um é: " + listadeprodutos.get(1).getNome() + "\n");
        System.out.println("\nO produto no indice dois é: " + listadeprodutos.get(2).getNome() + "\n");
        System.out.println("\nO produto no indice três é: " + listadeprodutos.get(3).getNome() + "\n");
        System.out.println("\nO produto no indice quatro é: " + listadeprodutos.get(4).getNome() + "\n");
        System.out.println("\nO produto no indice cinco é: " + listadeprodutos.get(5).getNome() + "\n");

        System.out.println("\nA lista completa de Produto: " + listadeprodutos.toString() + "\n");

        System.out.println("Nome do Perecível: " + arroz.getNome() + ", Preço: " + arroz.getPreco() + ", Quantidade: " + arroz.getQuantidade() + ", Data de Validade: " + arroz.getDataValidade());

    }
}