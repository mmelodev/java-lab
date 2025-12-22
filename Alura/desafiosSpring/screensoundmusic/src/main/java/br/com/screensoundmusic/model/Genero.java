package br.com.screensoundmusic.model;

public enum Genero {
	HIPHOP("Hip-Hop", "Rap"), SOUL("Soul", "Soul"), ROCK_ALTERNATIVO("Alternative Rock", "Rock Alternativo"),
	POP("Pop", "Pop"), POP_ROCK("Pop-Rock", "Pop-Rock"), ROCK("Rock", "Rock"), PUNK("Punk", "Punk"),
	CLASSICA("Classical", "Música Clássica"), ELETRONICA("Electronic", "Música Eletrônica"),
	LATINO("Latin", "Brasileiro Diverso"), METAL("Heavy Metal", "Música Metal");

	private String generoMusica;
	private String generoPortugues;

	private Genero(String generoMusica, String generoPortugues) {
		this.generoMusica = generoMusica;
		this.generoPortugues = generoPortugues;
	}

	public static Genero fromString(String text) {
		for (Genero genero : Genero.values()) {
			if (genero.generoMusica.equalsIgnoreCase(text)) {
				return genero;
			}
		}
		throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
	}

	public static Genero fromPortugues(String text) {
		for (Genero genero : Genero.values()) {
			if (genero.generoPortugues.equalsIgnoreCase(text)) {
				return genero;
			}
		}
		throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
	}

}
