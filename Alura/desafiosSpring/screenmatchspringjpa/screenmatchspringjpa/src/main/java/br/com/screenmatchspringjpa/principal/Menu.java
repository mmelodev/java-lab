package br.com.screenmatchspringjpa.principal;

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

import br.com.screenmatchspringjpa.*;
import br.com.screenmatchspringjpa.model.DadosSerie;
import br.com.screenmatchspringjpa.model.DadosTemporada;
import br.com.screenmatchspringjpa.model.Episodio;
import br.com.screenmatchspringjpa.model.Serie;
import br.com.screenmatchspringjpa.repository.SerieRepository;
import br.com.screenmatchspringjpa.services.ConsumindoAPI;
import br.com.screenmatchspringjpa.services.ConverteDados;

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
    private List<DadosSerie> dadosSeries = new ArrayList<>();
    private SerieRepository repositorio;

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
        System.out.println("1. Buscar Série");
        System.out.println("2. Buscar Episódios");
        System.out.println("3. Listar Séries Buscadas");
        System.out.println("9. Sair");

        System.out.print(ANSI_GREEN + "\n>> Opção: " + ANSI_RESET);
    }

    public void iniciarLoopDeInteracao() {
        int opcao = -1;

        while (opcao != 9) {
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
                case 9:
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
        System.out.println(ANSI_YELLOW + "\n--- BUSCAR SÉRIE ---" + ANSI_RESET);
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
        DadosSerie dados = getDadosSerie();
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporada(); i++) {
            var json = consumo.obterDados(ENDERECO + dados.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = converte.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);
    }

    private void seriesBuscadas() {
        System.out.println(ANSI_YELLOW + "\n--- SÉRIES BUSCADAS ---" + ANSI_RESET);

        if (dadosSeries.isEmpty()) {
            System.out.println("\né papai");
        }

        List<Serie> series;

        series = dadosSeries.stream()
                .map(s -> new Serie(s))
                .collect(Collectors.toList());
        series.stream()
                .sorted(Comparator.comparing(Serie::getCategoria))
                .forEach(System.out::println);
    }


}
