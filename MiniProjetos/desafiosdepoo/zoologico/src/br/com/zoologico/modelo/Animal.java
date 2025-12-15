package br.com.zoologico.modelo;

public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private double peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String fazersom(){
        return "Som do Animal";
    }

    public String movimentacao(){
        return "Movimento do animal";
    }

    public String habitat(){
        return "Habitat do animal";
    }

}
