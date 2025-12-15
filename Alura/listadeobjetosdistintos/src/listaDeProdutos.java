import java.util.ArrayList;

public class listaDeProdutos {
    public static void main(String[] args) {
        var rexona = new Produto("Rexona", 13.10);
        var sabao = new Produto("Sabão", 4.50);
        var banana = new Produto("Banana", 3);

        ArrayList<Produto> listadeprodutos = new ArrayList<>();

        listadeprodutos.add(rexona);
        listadeprodutos.add(sabao);
        listadeprodutos.add(banana);

        System.out.println(listadeprodutos);

        double somaprecos = 0;
        for (Produto produto : listadeprodutos){
            somaprecos += produto.getPreco();
        }

        double media = somaprecos/listadeprodutos.size();
        System.out.println("A média dos preços dos produtos: R$ " + media);
    }
}
