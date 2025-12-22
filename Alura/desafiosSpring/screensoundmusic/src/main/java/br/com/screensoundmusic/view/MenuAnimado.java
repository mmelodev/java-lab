package br.com.screensoundmusic.view;

import java.util.concurrent.TimeUnit;

public class MenuAnimado {
	// --- Cores ANSI para deixar o terminal bonito ---
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BOLD = "\u001B[1m";

	// Método principal para chamar a animação
	public static void exibirIntro() {
		limparConsole();
		animarCifras(4); // Roda a animação por 4 segundos (aprox)
		exibirLogoAscii();
		System.out.println(ANSI_CYAN + "\n       BEM-VINDO AO SCREEN SOUND MÚSICAS!" + ANSI_RESET);
		pausar(1000);
	}

	private static void animarCifras(int segundos) {
		// Cifras para o letreiro digital
		String cifrasBase = "  C  |  Am7  |  Fmaj7  |  G7  |  Em  |  Dm7  |  🎵 Screen Sound 🎵  |  Bb9  |  A7  |  ";
		int tamanhoJanela = 40; // Quantos caracteres mostramos por vez
		long tempoFinal = System.currentTimeMillis() + (segundos * 1000L);

		System.out.println(ANSI_PURPLE + ANSI_BOLD); // Define a cor do letreiro

		// Loop de animação
		while (System.currentTimeMillis() < tempoFinal) {
			// Pega uma "fatia" do texto para mostrar (simula a janela deslizante)
			String textoVisivel = cifrasBase.substring(0, tamanhoJanela);

			// \r = Carriage Return (Volta o cursor para o início da linha sem pular linha)
			// Isso permite sobrescrever o texto anterior, criando o efeito de animação
			System.out.print("\r" + "🎹 [ " + textoVisivel + " ] 🎹");

			// "Gira" a string: Pega o primeiro caractere e joga para o final
			cifrasBase = cifrasBase.substring(1) + cifrasBase.charAt(0);

			pausar(100); // Velocidade da animação (quanto menor, mais rápido)
		}
		System.out.println(ANSI_RESET); // Reseta a cor e pula linha
	}

	private static void exibirLogoAscii() {
		System.out.println(ANSI_YELLOW + ANSI_BOLD);
		System.out.println("   _____                                 _____                       _ ");
		System.out.println("  / ____|                               / ____|                     | |");
		System.out.println(" | (___   ___ _ __ ___  ___ _ __ ______| (___   ___  _   _ _ __   __| |");
		System.out.println("  \\___ \\ / __| '__/ _ \\/ _ \\ '_ \\______|\\___ \\ / _ \\| | | | '_ \\ / _` |");
		System.out.println("  ____) | (__| | |  __/  __/ | | |      ____) | (_) | |_| | | | | (_| |");
		System.out.println(" |_____/ \\___|_|  \\___|\\___|_| |_|     |_____/ \\___/ \\__,_|_| |_|\\__,_|");
		System.out.println(ANSI_RESET);
	}

	public static void limparConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static void pausar(int milissegundos) {
		try {
			TimeUnit.MILLISECONDS.sleep(milissegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
