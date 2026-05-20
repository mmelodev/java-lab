package br.com.screenmatchspringwebapi.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.screenmatchspringwebapi.model.*;
import br.com.screenmatchspringwebapi.repository.SerieRepository;
import br.com.screenmatchspringwebapi.services.ConsumindoAPI;
import br.com.screenmatchspringwebapi.services.ConverteDados;

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

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=416d0bfe";

    private String nomeSerie;

    private ConsumindoAPI consumo = new ConsumindoAPI();
    private ConverteDados converte = new ConverteDados();
    private String numeroTemp;
    private String numeroEp;

    private List<DadosTemporada> listaDeTemporadas = new ArrayList<>();
    private List<Episodio> episodios = new ArrayList<>();
    List<Serie> series = new ArrayList<>();
    private List<DadosSerie> dadosSeries = new ArrayList<>();
    private SerieRepository repositorio;

    Optional<Serie> serieBuscada;

    Scanner input = new Scanner(System.in);

    public Menu(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibirMenuPrincipal() {
        System.out.println(
                ANSI_BLUE_BACKGROUND + ANSI_BLACK + "***************************************************" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "          SÉRIES STREAM!         " + ANSI_RESET);
        System.out.println(
                ANSI_BLUE_BACKGROUND + ANSI_BLACK + "***************************************************" + ANSI_RESET);

        System.out.println("\n" + ANSI_CYAN + "Escolha uma opção para começar:" + ANSI_RESET);
        System.out.println("1. Armazenar Uma Série");
        System.out.println("2. Buscar Episódios");
        System.out.println("3. Listar Séries Buscadas");
        System.out.println("4. Buscar Série Cadastrada Pelo Nome");
        System.out.println("5. Buscar Série Pelo Nome do Ator e Avaliação");
        System.out.println("6. Ver as Top 5 Séries Cadastradas");
        System.out.println("7. Buscar Pelo Genêro");
        System.out.println("8. Buscar Série Pela Total de Temporadas e Avaliação");
        System.out.println("9. Buscar Episódio Por Trecho / Palavra-Chave");
        System.out.println("10. Buscar Top 5 Episódios por Série");
        System.out.println("11. Buscar Episódios A Partir De Uma Data");
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
                    buscarSerie();
                    break;
                case 2:
                    buscarEpsPorSerie();
                    break;
                case 3:
                    seriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriesPorAtor();
                    break;
                case 6:
                    buscarTop5();
                    break;
                case 7:
                    buscarPeloGenero();
                    break;
                case 8:
                    buscarPelaQntdTempEAvaliacao();
                    break;
                case 9:
                    buscarEpisodioPorTrecho();
                    break;
                case 10:
                    buscarTop5Episodios();
                    break;
                case 11:
                    buscarEpisodioPorSerieEData();
                    break;
                case 0:
                    System.out.println(ANSI_RED + "\nDesligando... Obrigado por usar o Screenmatch!" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Opção inválida. Tente novamente." + ANSI_RESET);
            }
        }
        input.close();
    }

    private void buscarSerie() {
        DadosSerie dados = getDadosSerie();
        //System.out.println(dados);
        Serie serie = new Serie(dados);
        repositorio.save(serie);
    }

    private DadosSerie getDadosSerie() {
        System.out.println(ANSI_YELLOW + "\n--- ARMAZENAR SÉRIE ---" + ANSI_RESET);
        System.out.print("Digite o nome da série (ex: The Office): ");
        nomeSerie = input.nextLine();

        System.out.println(ANSI_PURPLE + "Buscando dados de '" + nomeSerie + "' na API..." + ANSI_RESET);

        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = converte.obterDados(json, DadosSerie.class);
        //como estou tratando o json para objeto não posso usar o metodo formatarObjetoComoJson() aqui
        dadosSeries.add(dados);
        return dados;

        //posso transformar os dados que estão em lista aqui para objeto do tipo série, dai não teriamos mais dados printados vindo de uma lista mas sim do objeto com tradução e organização correta
    }

    private void buscarEpsPorSerie() {
        seriesBuscadas();
        System.out.println("\nDigite o nome da série que deseja ver os eps: ");
        var nomeSerie = input.nextLine();

        Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

        if (serie.isPresent()) {

            var serieEncontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporada(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = converte.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numeroTemp(), e)))
                    .collect(Collectors.toList());

            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);
        } else {
            System.out.println("\nSérie não encontrada!");
        }
    }

    private void seriesBuscadas() {
        System.out.println(ANSI_YELLOW + "\n--- SÉRIES BUSCADAS ---" + ANSI_RESET);

        if (dadosSeries.isEmpty()) {
            System.out.println("\nA Lista Esta Vazia!");
        }

        series = repositorio.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getCategoria))
                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo() {
        System.out.println("\nDigite o nome da série: ");
        var nomeSerie = input.nextLine();

        serieBuscada = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

        if (serieBuscada.isPresent()){
            System.out.println("\nSérie Encontrada!\n");
            serieBuscada.get();
            System.out.println(serieBuscada);
        } else{
            System.out.println("\nSérie Não Encontrada...\n");
        }
    }

    private void buscarSeriesPorAtor(){
        System.out.println("\nDigite o nome do(a) ator(a): ");
        var nomeAtor = input.nextLine();

        System.out.println("\nA partir de qual número gostaria (avaliação): ");
        var avaliacao = input.nextDouble();

        List<Serie> seriesEncontradas = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoImdbGreaterThanEqual(nomeAtor, avaliacao);
        System.out.println("\nSéries em que " + nomeAtor + " trabalhou: ");
        seriesEncontradas.forEach(s ->
                System.out.println(s.getTitulo() + " - Avaliação: " + s.getAvaliacaoImdb())); //corrigir isso aq
    }

    private void buscarTop5(){
        List<Serie> seriesTop5 = repositorio.findTop5ByOrderByAvaliacaoImdbDesc(); //esse sistema de consultas derivadas (derived queries) é simplesmente maluco, parece bruxaria
        seriesTop5.forEach(s -> System.out.println(s.getTitulo() + " - Avaliação: " + s.getAvaliacaoImdb()));
    }

    private void buscarPeloGenero(){
        System.out.println("\nDigite o Genêro: ");
        var genero = input.nextLine();

        System.out.println("\nSéries encontradas no genêro de " + genero);

        Categoria generoEncontrado = Categoria.fromPortugues(genero);

        List<Serie> seriesPorGenero = repositorio.findByCategoria(generoEncontrado);

        seriesPorGenero.forEach(System.out::println);
    }

    private void buscarPelaQntdTempEAvaliacao(){
        System.out.println("\nAté quantas temporadas a(s) serie(s) vai ter: ");
        var qntdTemporadas = input.nextInt();

        System.out.println("\nA partir de qual número gostaria (avaliação): ");
        var avaliacao = input.nextDouble();

        List<Serie> seriesEncontradasTempAvalia = repositorio.consultaTemporadaAvaliacao(qntdTemporadas, avaliacao);

        System.out.println("\nSéries Encontradas: ");

        seriesEncontradasTempAvalia.forEach(s -> System.out.println(s.getTitulo() + " com total de " + s.getTotalTemporada() + " temporadas" + " - Avaliação: " + s.getAvaliacaoImdb()));
    }

    private void buscarEpisodioPorTrecho(){
        System.out.println("\nDigite o trecho / palavra-chave do episódio: ");
        var trechoEpisodio = input.nextLine();

        List<Episodio> episodiosDoTrecho = repositorio.consultaEpisodioPorTrecho(trechoEpisodio);
        episodiosDoTrecho.forEach(e -> System.out.println("\nTitulo do episódio: " + e.getTituloEpisodio() + " - Temporada Nº " + e.getNumeroTemporada() + " - Série: " + e.getSerie().getTitulo()));
    }

    private void buscarTop5Episodios(){
        buscarSeriePorTitulo();
        if(serieBuscada.isPresent()){
            Serie serie = serieBuscada.get();
            List<Episodio> episodiosTops = repositorio.consultaTopEpisodios(serie);
            episodiosTops.forEach(e -> System.out.println("\nTitulo do episódio: " + e.getTituloEpisodio() + " - Temporada Nº " + e.getNumeroTemporada() + " - Série: " + e.getSerie().getTitulo() + " - Avaliação: " + e.getAvaliacaoEpisodio()));
        }
    }

    private void buscarEpisodioPorSerieEData(){
        buscarSeriePorTitulo();
        if (serieBuscada.isPresent()){
            System.out.println("\nGostaria de ver episódios disponíveis a partir de qual ano? ");
            var anoLancamento = input.nextInt();

            Serie serie = serieBuscada.get();

            List<Episodio> episodiosPorData = repositorio.consultaEpisodiosPorSerieEData(serie, anoLancamento);
            episodiosPorData.forEach(System.out::println);
        }
    }

}
