package br.com.desafioum;

import br.com.desafioum.services.Avaliacao;
import br.com.desafioum.services.ConsumindoJson;
import br.com.desafioum.services.Tarefa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.DataInput;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DesafioumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioumApplication.class, args);
	}

	class Livro {
		String titulo;

		public Livro(String titulo) {
			this.titulo = titulo;
		}

		@Override
		public String toString() {
			return "Livro: " + titulo;
		}
	}

	class Filme {
		String nome;

		public Filme(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "Nome: " + nome;
		}
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);

		System.out.println("\n=== APLICAÇÃO ===\n");

//		System.out.println("Digite até qual número deseja contar: \n");
//		int numero = input.nextInt();
//
//		for (int i = 1; i <= numero; i++){
//			System.out.println(i);
//		}

		Tarefa tarefa = new Tarefa("Nova Tarefa 2", true, "Carlos Eduardo");

		File arquivo = new File ("tarefa.json");
		FileWriter escrever = new FileWriter(arquivo);

		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(tarefa);

			escrever.write(json);

			escrever.close();

			System.out.println("=== Objeto -> JSON com Sucesso ===\n");

			//agora ler o json e converter para um novo Objeto Tarefa

			Tarefa dadosLidos = mapper.readValue(arquivo, Tarefa.class);
			System.out.println(dadosLidos);

			System.out.println("=== JSON -> Objeto com Sucesso ===\n");

		} catch (Exception e) {
			e.printStackTrace();
		}

		Livro livro = new Livro("O Hobbit!");
		Livro livro2 = new Livro("Senhor dos Anéis");

		Avaliacao<Livro> avaliacaoLivro = new Avaliacao<>(livro, 10, "Melhor livro de todos os tempos");

		Avaliacao<Livro> avaliacaoLivro2 = new Avaliacao<>(livro, 8, "Melhor livro de todos os tempos mais uma vez");

		List<Avaliacao<Livro>> listaAvaliacoes = new ArrayList<>();

		listaAvaliacoes.add(avaliacaoLivro);
		listaAvaliacoes.add(avaliacaoLivro2);

		double media = Avaliacao.calcularMediaNotas(listaAvaliacoes);
		System.out.println(media);
	}
}
