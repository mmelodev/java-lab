package br.com.desafiolistadecompras.modelos;

public class Produtos implements Comparable <Produtos>{
    private String nomeProduto;
    private double valorProduto;
    private String categoriaProduto;

    //criar lógica para funcionar essa parte de categoriaProduto

    public Produtos (String nomeProduto, double valorProduto){
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    @Override
    public String toString() {
        return "Nome: " + getNomeProduto() + ", Valor do Produto: R$ " + getValorProduto() + "\n";
    }

    @Override
    public int compareTo(Produtos o) {
        return Double.valueOf(this.valorProduto).compareTo(Double.valueOf(o.valorProduto));
    }
}
