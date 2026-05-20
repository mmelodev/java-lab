package poo.classe;

public class Pessoa {
    String nome;
    int idade;
    Boolean maiorDeIdade;

    public Pessoa (String nome, int idade, Boolean maiorDeIdade){
        this.nome = nome;
        this.idade = idade;
        this.maiorDeIdade = maiorDeIdade;
    }

    @Override
    public String toString() {
        return "nome=" + nome + '\n' +
                ", idade=" + idade + "\n" +
                ", maiorDeIdade=" + maiorDeIdade + "\n";
    }
}
