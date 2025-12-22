package br.com.screensoundmusic.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.screensoundmusic.model.Artista;
import br.com.screensoundmusic.model.ArtistaResponse;
import br.com.screensoundmusic.repository.ArtistaRepository;
import br.com.screensoundmusic.services.ConsumindoAPI;
import br.com.screensoundmusic.services.ConverteDados;

public class Menu {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

	Scanner input = new Scanner(System.in);

	private ConsumindoAPI consumo = new ConsumindoAPI();
	private ConverteDados converte = new ConverteDados();

	private String nomeArtista;
	private List<ArtistaResponse> dadosArtistas = new ArrayList<>();

	private ArtistaRepository repositorio;

	private final String ENDERECO = "https://www.theaudiodb.com/api/v1/json/123/search.php?s=";
	// private final String API_KEY = "...";

	public Menu(ArtistaRepository repositorio) {
		this.repositorio = repositorio;
	}

	public void exibirMenuPrincipal() {
		MenuAnimado animacao = new MenuAnimado();
		animacao.exibirIntro();

		System.out.println("\n" + ANSI_CYAN + "Escolha uma opção para começar:" + ANSI_RESET);
		System.out.println("1. Cadastrar artistas");
		System.out.println("2. Cadastrar músicas");
		System.out.println("3. Listar músicas");
		System.out.println("4. Pesquisar dados sobre um artista (IA)");
		System.out.println("5. Visualizar Artistas Cadastrados");
		System.out.println("0. Sair");

		System.out.print(ANSI_GREEN + "\n>> Opção: " + ANSI_RESET);
	}

	public void iniciarLoopDeInteracao() {
		int opcao = -1;

		while (opcao != 0) {
			exibirMenuPrincipal();
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
			case 1:
				CadastrarArtista();
				break;
			case 2:
				CadastrarMusica();
			case 0:
				System.out.println(ANSI_RED + "\nDesligando... Obrigado por usar o Screen Sound Music!" + ANSI_RESET);
				break;
			default:
				System.out.println(ANSI_RED + "Opção inválida. Tente novamente." + ANSI_RESET);
			}
		}
		input.close();
	}

	public void CadastrarArtista() {
		ArtistaResponse dadosArtista = getDadosArtista();
		Artista artista = new Artista(dadosArtista);
		repositorio.save(artista);

		System.out.println("\nCadastrar outro artista? (S/N)");
		String resposta = input.nextLine();

		while (!resposta.equalsIgnoreCase("n")) {
			CadastrarArtista();
		}
	}

	public ArtistaResponse getDadosArtista() {
		System.out.println(ANSI_YELLOW + "\n--- ARMAZENAR ARTISTA ---" + ANSI_RESET);
		System.out.print("Digite o nome do artista (ex: Eminem): ");
		nomeArtista = input.nextLine();

		System.out.println(ANSI_PURPLE + "Buscando dados de '" + nomeArtista + "' na API..." + ANSI_RESET);

		var json = consumo.obterDados(ENDERECO + nomeArtista.replace(" ", "+"));

		ArtistaResponse dados = converte.obterDados(json, ArtistaResponse.class);
		dadosArtistas.add(dados);
		return dados;

	}

	public void CadastrarMusica() {

	}

}
