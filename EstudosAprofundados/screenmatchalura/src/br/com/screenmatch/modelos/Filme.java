package br.com.screenmatch.modelos;

import java.util.*;

import static java.lang.System.out;

public class Filme {
    private String nome;
    private int anoDeLancamento;
    private int avaliacao;
    private int avalicaoTotal = 0;
    private int duracaoEmMinutos;
    private String saldoFinal;
    //na alura, eles criram um boolean para incluidoNoPlano

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public String getSaldoFinal() {
        return saldoFinal;
    }

    public int getAvalicaoTotal(){
        return avalicaoTotal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeNome(){
        out.println("Nome do filme: " + nome);
    }

    public void exibeAnoDeLancamento(){
        out.println("Ano de lancamento: " + anoDeLancamento);
    }

    public void exibeDuracaoEmMinutos(){
        out.println("Duracao em minutos: " + duracaoEmMinutos);
    }

    Scanner maisAv = new Scanner(System.in);
    Scanner QntdAv = new Scanner(System.in);

    public boolean novasAvaliacoes(){
        while(true){
            out.println("Deseja avaliar o filme? (y/n) ");
            String maisAvaliacoes = maisAv.next();
            if (maisAvaliacoes.equals("y")) {
                out.println("Quanto de estrelas deseja colocar para esse filme? (Máx 5): ");
                int quantidadeAvaliacoes = QntdAv.nextInt();
                avaliacao += quantidadeAvaliacoes;
                out.println("Sua avaliação foi de: " + avaliacao + " estrelas");
                avalicaoTotal++;
                System.out.println("\nO total de suas avaliações para esse filme é de: " + avalicaoTotal);
            } else {
                System.out.println("\nSem avaliação, entendi\n");
                return false;
            }
        }
    }

    public void exibeSaldoFinal(){
        out.println("|*********************************|\n" +
                "O nome do filme é: " +  nome + "\n" +
                "O ano de Lançamento é: " + anoDeLancamento + "\n" +
                "A duração em Minutos é: " + duracaoEmMinutos + "\n" +
                "A sua quantidade de estrelas para esse filme foi de: " + avaliacao + " estrelas" + "\n" +
                "O total de vezes que você colocou estrelas foi de: " + avalicaoTotal + " vezes" + "\n" +
                "|*********************************|\n");

    }
}