package main.br.com.primeirospring.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import main.br.com.primeirospring.model.DadosEpisodio;
import main.br.com.primeirospring.model.DadosSerie;
import main.br.com.primeirospring.model.DadosTemporada;
import main.br.com.primeirospring.model.Episodio;
import main.br.com.primeirospring.services.ConsumindoAPI;
import main.br.com.primeirospring.services.ConverteDados;

public class Menu {
	// --- Constantes de Cores ANSI para o Terminal ---
	// (Tornam a interação mais "interessante")
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	// Fundo
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=416d0bfe";

	private String nomeSerie;

	private ConsumindoAPI consumo = new ConsumindoAPI();
	private ConverteDados converte = new ConverteDados();
	private String numeroTemp;
	private String numeroEp;

	List<DadosTemporada> listaDeTemporadas = new ArrayList<>();
	List<Episodio> episodios = new ArrayList<>();

	private DadosSerie serieAtual = null;

	Scanner input = new Scanner(System.in);

	public void exibirMenuPrincipal() {
		System.out.println(
				ANSI_BLUE_BACKGROUND + ANSI_BLACK + "***************************************************" + ANSI_RESET);
		System.out.println(ANSI_YELLOW + "          SÉRIES STREAM!         " + ANSI_RESET);
		System.out.println(
				ANSI_BLUE_BACKGROUND + ANSI_BLACK + "***************************************************" + ANSI_RESET);

		if (serieAtual == null) {
			System.out.println("\n" + ANSI_CYAN + "Escolha uma opção para começar:" + ANSI_RESET);
			System.out.println("1. Buscar nova série (Pela API)");
			System.out.println("9. Sair");
		} else {
			System.out.println("\nSérie em análise: " + ANSI_GREEN + serieAtual.titulo() + " ("
					+ serieAtual.totalTemporada() + " temporadas)" + ANSI_RESET);
			System.out.println(ANSI_CYAN + "---------------------------------------------------" + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Escolha uma opção:" + ANSI_RESET);
			System.out.println("1. Listar todas as temporadas");
			System.out.println("2. Listar episódios por temporada");
			System.out.println("3. Ver Top 5 episódios (Melhores avaliações)");
			System.out.println("4. Ver a Lista Geral de Episódios");
			System.out.println("5. Visualizar A Partir de Uma Data");
			System.out.println("6. Pesquisar um Episódio");
			System.out.println(ANSI_YELLOW + "---------------------------------------------------" + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "8. Buscar OUTRA série" + ANSI_RESET);
			System.out.println(ANSI_RED + "9. Sair" + ANSI_RESET);
		}
		System.out.print(ANSI_GREEN + "\n>> Opção: " + ANSI_RESET);
	}

	public void iniciarLoopDeInteracao() {
		int opcao = -1;

		while (opcao != 9) {
			exibirMenuPrincipal();
			try {
				opcao = input.nextInt();
				input.nextLine(); // Limpa o buffer do scanner

				if (serieAtual == null) {
					// Menu Básico (Sem série carregada)
					switch (opcao) {
					case 1:
						buscarSerie();
						break;
					case 9:
						System.out.println(ANSI_RED + "\nDesligando... Obrigado por usar o Screenmatch!" + ANSI_RESET);
						break;
					default:
						System.out.println(ANSI_RED + "Opção inválida. Tente novamente." + ANSI_RESET);
					}
				} else {
					switch (opcao) {
					case 1:
						listarTemporadas();
						break;
					case 2:
						listarEpisodiosPorTemporada();
						break;
					case 3:
						buscarTopEpisodios();
						break;
					case 4:
						listaGeralEpisodios();
						break;
					case 5:
						visualizarComData();
						break;
					case 6:
						pesquisaDeEpisodio();
						break;
					case 8:
						episodios.clear();
						buscarSerie();
						break;
					case 9:
						System.out
								.println(ANSI_RED + "\nDesligando... Obrigado por usar o Screenmatch!\n" + ANSI_RESET);
						break;
					default:
						System.out.println(ANSI_RED + "Opção inválida. Tente novamente." + ANSI_RESET);
					}
				}
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Erro: Entrada inválida. Por favor, digite apenas números." + ANSI_RESET);
				input.nextLine(); // Limpa o buffer em caso de erro de tipo (ex: digitar 'a')
				opcao = -1; // Reseta a opção
			}
		}
		input.close();
	}

	private void buscarSerie() {
		System.out.println(ANSI_YELLOW + "\n--- BUSCAR SÉRIE ---" + ANSI_RESET);
		System.out.print("Digite o nome da série (ex: The Office): ");
		nomeSerie = input.nextLine();

		System.out.println(ANSI_PURPLE + "Buscando dados de '" + nomeSerie + "' na API..." + ANSI_RESET);

		String json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

		serieAtual = converte.obterDados(json, DadosSerie.class);
	}

	private void listarTemporadas() {
		System.out.println(ANSI_YELLOW + "\n--- LISTANDO TEMPORADAS DE " + serieAtual.titulo().toUpperCase() + " ---"
				+ ANSI_RESET);

		for (int i = 1; i <= serieAtual.totalTemporada(); i++) {
			String jsonTempTotal = consumo
					.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);

			DadosTemporada dadosTemporada = converte.obterDados(jsonTempTotal, DadosTemporada.class);

			System.out.println(dadosTemporada);

			listaDeTemporadas.add(dadosTemporada);
		}
	}

	private void listarEpisodiosPorTemporada() {
		System.out.println(ANSI_YELLOW + "\n--- LISTAR EPISÓDIOS POR TEMPORADA ---" + ANSI_RESET);
		System.out.print("Qual temporada você quer ver? (1 a " + serieAtual.totalTemporada() + "): ");
		numeroTemp = input.nextLine();

		System.out.println(ANSI_PURPLE + "Buscando episódios da temporada " + numeroTemp + "..." + ANSI_RESET);

		String jsonTemp = consumo
				.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + numeroTemp + API_KEY);

		DadosTemporada dadosTemporadaEscolhida = converte.obterDados(jsonTemp, DadosTemporada.class);

		System.out.println(dadosTemporadaEscolhida);
	}

	private void buscarTopEpisodios() {

		System.out.println(
				ANSI_YELLOW + "\n--- TOP 5 EPISÓDIOS DE " + serieAtual.titulo().toUpperCase() + " ---" + ANSI_RESET);
		System.out.println(ANSI_PURPLE + "Analisando avaliações..." + ANSI_RESET);

		List<DadosEpisodio> listaEpisodiosGeral = listaDeTemporadas.stream().flatMap(t -> t.episodios().stream())
				.collect(Collectors.toList());

		listaEpisodiosGeral.stream().filter(e -> !e.avaliacaoEP().equalsIgnoreCase("N/A"))
				.sorted(Comparator.comparing(DadosEpisodio::avaliacaoEP).reversed()).limit(5)
				.forEach(System.out::println);

		System.out.println("\nBÔNUS - AVALIAÇÕES POR TEMPORADA ----" + ANSI_RESET);

		Map<Integer, Double> avaliacoesPorTemporada = episodios.stream().filter(e -> e.getAvaliacaoEpisodio() > 0.0)
				.collect(Collectors.groupingBy(Episodio::getNumeroTemporada,
						Collectors.averagingDouble(Episodio::getAvaliacaoEpisodio)));
		System.out.println(avaliacoesPorTemporada);

		System.out.println("\nBÔNUS - AVALIAÇÕES EXTRAS ----" + ANSI_RESET);

		DoubleSummaryStatistics est = episodios.stream().filter(e -> e.getAvaliacaoEpisodio() > 0.0)
				.collect(Collectors.summarizingDouble(Episodio::getAvaliacaoEpisodio));
		System.out.println("Média: " + est.getAverage());
		System.out.println("Melhor episódio: " + est.getMax());
		System.out.println("Pior episódio: " + est.getMin());
		System.out.println("Quantidade: " + est.getCount());
	}

	private void listaGeralEpisodios() {

		episodios.clear();
		episodios = listaDeTemporadas.stream()
				.flatMap(t -> t.episodios().stream().map(d -> new Episodio(t.numeroTemp(), d)))
				.collect(Collectors.toList());

		episodios.forEach(System.out::println);
	}

	private void visualizarComData() {

		episodios.clear();

		// apenas quando eu adiciono na lista na execução geral de eps que esse metodo
		// vai funcionar, acredito que para resolver isso preciso de um banco de dados
		// idependente de código

		System.out.println("\nA partir de qual ano deseja ver a lista?");
		var ano = input.nextInt();
		input.nextLine();

		LocalDate dataBusca = LocalDate.of(ano, 1, 1);

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd, MM, YYYY");

		episodios.stream().filter(e -> e.getDataDeLancamento() != null && e.getDataDeLancamento().isAfter(dataBusca))
				.forEach(e -> System.out.println("\nTemporada: " + e.getNumeroTemporada() + "\n" + "Nome do Episódio: "
						+ e.getTituloEpisodio() + "\n" + "Episódio: " + e.getNumeroEpisodio() + "\n"
						+ "Data de Lançamento: " + e.getDataDeLancamento().format(formatador) + "\n"));
	}

	private void pesquisaDeEpisodio() {
		System.out.println("\nDigite o nome do episódio ou palavra chave: ");
		String trechoTitulo = input.nextLine();

		Optional<Episodio> episodioBuscado = episodios.stream()
				.filter(e -> e.getTituloEpisodio().toUpperCase().contains(trechoTitulo.toUpperCase())).findFirst();

		if (episodioBuscado.isPresent()) {
			System.out.println("\nEpisódio encontrado!\n");
			System.out.println("Nome do episódio: " + episodioBuscado.get().getTituloEpisodio());
			System.out.println("\nTemporada: " + episodioBuscado.get().getNumeroTemporada() + "\n");
		} else {
			System.out.println("\nEpisódio não encontrado!");
		}
	}

	// o desafio é limpar o array toda vez que eu buscar uma nova série

}
