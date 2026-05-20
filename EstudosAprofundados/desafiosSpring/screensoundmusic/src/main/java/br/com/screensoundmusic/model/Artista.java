package br.com.screensoundmusic.model;

import java.util.Optional;

import br.com.screensoundmusic.services.ConsultaMyMemory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nomeArtista;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private int dataNascimento;
	@Column(length = 8000)
	private String descricaoEN;
	@Column(length = 8000)
	private String descricaoPT;
	private String nacionalidade;
	private int membrosGrupo;

	public Artista(ArtistaResponse dados) {
		DadosArtista dadosArtista = dados.artists().get(0);
		this.nomeArtista = dadosArtista.nomeArtista();
		this.genero = Genero.fromString(dadosArtista.genero());
		this.dataNascimento = dadosArtista.dataNascimento();
		this.descricaoEN = ConsultaMyMemory.obterTraducao(dadosArtista.descricaoEN());
		this.descricaoPT = Optional.ofNullable(dadosArtista.descricaoPT()).orElse("Sem Descrição");
		this.nacionalidade = dadosArtista.nacionalidade();
		this.membrosGrupo = dadosArtista.membrosGrupo();
	}

	public Artista() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDescricaoEN() {
		return descricaoEN;
	}

	public void setDescricaoEN(String descricaoEN) {
		this.descricaoEN = descricaoEN;
	}

	public String getDescricaoPT() {
		return descricaoPT;
	}

	public void setDescricaoPT(String descricaoPT) {
		this.descricaoPT = descricaoPT;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public int getMembrosGrupo() {
		return membrosGrupo;
	}

	public void setMembrosGrupo(int membrosGrupo) {
		this.membrosGrupo = membrosGrupo;
	}

	@Override
	public final String toString() {
		return "\nNome do Artista (ou Grupo): " + nomeArtista + "\nGênero Musical: " + genero
				+ "\nAno de Inicio (ou Nascimento): " + dataNascimento + "\nBiografia(EN): " + descricaoEN
				+ "Biografia(PT): " + descricaoPT + "\nNacionalidade: " + nacionalidade + "\nMembros do Grupo: "
				+ membrosGrupo;
	}

}
