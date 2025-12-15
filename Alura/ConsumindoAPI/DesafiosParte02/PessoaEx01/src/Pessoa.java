public record Pessoa(String nome, int idade, String cidade) {

    public Pessoa(String nome, int idade, String cidade) {
        this.nome = (nome == null || nome.isBlank()) ? "Nome Desconhecido" : nome;

        if (idade < 18 || idade > 100){
            this.idade = 18;
        } else{
            this.idade = idade;
        }

        this.cidade = (cidade == null || cidade.isBlank()) ? "Cidade Desconhecida" : cidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Cidade: " + cidade;
    }

}
