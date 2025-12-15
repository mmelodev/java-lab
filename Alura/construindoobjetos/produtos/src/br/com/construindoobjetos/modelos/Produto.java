package br.com.construindoobjetos.modelos;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /* posso ter diferentes atributos em uma classe e a atributos esses atributos para diferentes construtores, por exemplo, eu posso ter um construtor apenas para o nome e apenas para o preço, não sei se faz sentido, mas posso fazer isso se eu quiser. */

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }


    public int getQuantidade() {
        return quantidade;
    }


    @Override
    public String toString() {
        return "\nNome: " + getNome() + ", Preço: R$ " + getPreco() + ", Quantidade: " + getQuantidade() + ", Valor final: R$ " + "new calculoPrecoTotal().precoTotal()" + "Em Manutenção\n"; // problema nesse precototal
    }
}
