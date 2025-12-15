package br.com.carrosaluraspring.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.carrosaluraspring.model.DadosModelos;
import br.com.carrosaluraspring.model.DadosVeiculos;
import br.com.carrosaluraspring.model.VeiculoFinal;
import br.com.carrosaluraspring.services.ConsumindoAPI;
import br.com.carrosaluraspring.services.ConverteDados;

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

	private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

	private String nomeVeiculo;
	private int numeroMarca;
	private int numeroModelo;
	private String numeroAno;
	private ConsumindoAPI consumo = new ConsumindoAPI();
	private ConverteDados converte = new ConverteDados();

	private List<DadosVeiculos> listaDeResultados = new ArrayList<>();
	//private List<DadosModelos> listaDadosModelos = new ArrayList<>();

	private DadosVeiculos veiculoAtual = null; // -> ainda não está sendo usado
	Scanner input = new Scanner(System.in);

	public void exibirMenuPrincipal() {
		System.out.println(
				ANSI_BLUE_BACKGROUND + ANSI_BLACK + "***************************************************" + ANSI_RESET);
		System.out.println(ANSI_YELLOW + "          BUSCA DE VEÍCULOS         " + ANSI_RESET);
		System.out.println(
				ANSI_BLUE_BACKGROUND + ANSI_BLACK + "***************************************************" + ANSI_RESET);

		if (listaDeResultados.isEmpty()) {
			System.out.println("\n" + ANSI_CYAN + "Escolha uma opção para começar:" + ANSI_RESET);
			System.out.println("1. Buscar Veículo (Pela API)");
			System.out.println("9. Sair");
		} else {
			System.out.println("\nVeículo em análise: " + ANSI_GREEN + nomeVeiculo.toUpperCase() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "---------------------------------------------------" + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Escolha uma opção:" + ANSI_RESET);
			System.out.println("1. Listar todas as Marcas");
			System.out.println(ANSI_YELLOW + "2. Buscar OUTRO veículo" + ANSI_RESET);
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
				input.nextLine();

				if (listaDeResultados.isEmpty()) {
					switch (opcao) {
					case 1:
						buscarVeiculo();
						break;
					case 9:
						System.out
								.println(ANSI_RED + "\nDesligando... Obrigado por usar a API de Veículos" + ANSI_RESET);
						break;
					default:
						System.out.println(ANSI_RED + "Opção inválida. Tente novamente." + ANSI_RESET);
					}
				} else {
					switch (opcao) {
					case 1:
						listarMarcas();
						break;
					case 2:
						buscarVeiculo();
						listaDeResultados.clear();
						break;
					case 9:
						System.out.println(
								ANSI_RED + "\nDesligando... Obrigado por usar a API de Veículos\n" + ANSI_RESET);
						break;
					default:
						System.out.println(ANSI_RED + "Opção inválida. Tente novamente." + ANSI_RESET);
					}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println(
						ANSI_RED + "Erro: Você digitou uma letra ou símbolo. Digite apenas números." + ANSI_RESET);
				input.nextLine();
				opcao = -1;
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Erro técnico aconteceu: " + e.getMessage() + ANSI_RESET);
				e.printStackTrace();
			}
		}
		input.close();

	}

	private void buscarVeiculo() {
		System.out.println(ANSI_YELLOW + "\n--- BUSCAR VEICULO ---" + ANSI_RESET);
		System.out.print("Digite o nome do Veiculo (Digite: carros | motos | caminhoes, sem acento): ");
		nomeVeiculo = input.nextLine();

		String json = consumo.obterDados(ENDERECO + nomeVeiculo + "/marcas");

		this.listaDeResultados = converte.obterLista(json, DadosVeiculos.class);

	}

	private void listarMarcas() {
		System.out.println(ANSI_YELLOW + "\n--- LISTANDO MARCAS DE " + nomeVeiculo.toUpperCase() + " ---" + ANSI_RESET);

		System.out.println("\nMarcas encontradas:");
		listaDeResultados.stream().forEach(System.out::println);

		System.out.println("Deseja seguir fluxo até o valor veículo em análise? (S/N): ");
		String respostaFluxo = input.nextLine();

		if (respostaFluxo.equalsIgnoreCase("S")) {
			fluxoDePreco();
		} else {
			System.out.println("\nComo sua resposta foi diferente de 'S' , retornando ao Menu\n" + ANSI_RESET);
		}
	}

	private void fluxoDePreco() {
		System.out.println(ANSI_YELLOW + "\n--- ESCOLHER MARCA ---" + ANSI_RESET);
		System.out.print("Com base na lista acima, digite a numeração da marca desejada: ");
		numeroMarca = Integer.parseInt(input.nextLine());

		String jsonMarca = consumo.obterDados(ENDERECO + nomeVeiculo + "/marcas/" + numeroMarca + "/modelos");

		var modelosResponse = converte.obterDados(jsonMarca, DadosModelos.class);

		System.out.println(modelosResponse.modelos());

		System.out.println("Para continuar, digite a numeração do modelo desejado (Ex: 5940): ");
		numeroModelo = Integer.parseInt(input.nextLine());

		System.out.println(ANSI_YELLOW + "\n--- ANOS REFERENTES AO MODELO " + numeroModelo + " --- " + ANSI_RESET);

		String jsonModelo = consumo.obterDados(ENDERECO + nomeVeiculo + "/marcas/" + numeroMarca + "/modelos/" + numeroModelo + "/anos");

		listaDeResultados.clear();

		var anosResponse = converte.obterLista(jsonModelo, DadosVeiculos.class);

		anosResponse.stream().forEach(System.out::println);

		System.out.println("Por fim, digite a numeração do ano desejado para informação completa do veículo (Ex: 2014-3): ");
		numeroAno = input.nextLine();

		System.out.println(ANSI_YELLOW + "\n--- Preço Corrente da Tabela FIPE ---" + ANSI_RESET);

		String jsonFinal = consumo.obterDados(ENDERECO + nomeVeiculo + "/marcas/" + numeroMarca + "/modelos/" + numeroModelo + "/anos/" + numeroAno);

		anosResponse.clear();

		VeiculoFinal veiculoFinal = converte.obterDados(jsonFinal, VeiculoFinal.class);

		System.out.println(veiculoFinal);

		System.out.println(ANSI_YELLOW + "\n--- FIM DA APLICAÇÃO ---" + ANSI_RESET + "\n\n\n");

	}
}
