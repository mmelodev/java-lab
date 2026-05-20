package br.com.listadeobjetosdistintos.modelos;

public class Gato extends Animal{
    private boolean manso;

    public Gato(String nome, int idade, String raca, boolean manso) {
        super(nome, idade, raca);
        this.manso = manso;
    }

    public boolean getManso() {
        return manso;
    }

    @Override
    public String fazersom() {
        return "Miau";
    }

    public String toString() {
        if (getManso() == true){
            return "Nome: " + getNome() + ", raça: " + getRaca() + ", idade: " + getIdade() + ".Além disso, também é manso";
        } else{
            return "Nome: " + getNome() + ", raça: " + getRaca() + ", idade: " + getIdade() + ".Além disso, nãe é manso";
        }
    }
}
