package br.com.listadeobjetosdistintos.modelos;

public class Cachorro extends Animal{
    private boolean adestrado;

    public boolean getAdestrado() {
        return adestrado;
    }

    public Cachorro (String nome, int idade, String raca, boolean adestrado){
        super(nome, idade, raca);
        this.adestrado = adestrado;
    }

    @Override
    public String fazersom() {
        return "AuAu";
    }

    public String toString() {
        if (getAdestrado() == true){
            return "Nome: " + getNome() + ", raça: " + getRaca() + ", idade: " + getIdade() + ".Além disso, também é adestrado";
        } else{
            return "Nome: " + getNome() + ", raça: " + getRaca() + ", idade: " + getIdade() + ".Além disso, nãe é adestrado";
        }
    }

    public void oqueCachorroFaz(){
        System.out.println("Um cachorro faz: " + fazersom() + " e seu movimento é rapido: " + rapido());
    }
}
