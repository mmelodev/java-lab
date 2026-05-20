package br.com.screenmatchspringwebapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "episodios")
public class Episodio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroTemporada;
	private String tituloEpisodio;
	private Integer numeroEpisodio;
	private Double avaliacaoEpisodio;
	private LocalDate dataDeLancamento;

	@ManyToOne
	private Serie serie;

	public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
		this.numeroTemporada = numeroTemporada;
		this.tituloEpisodio = dadosEpisodio.tituloEP();
		this.numeroEpisodio = dadosEpisodio.numeroEP();

		try {
			this.avaliacaoEpisodio = Double.valueOf(dadosEpisodio.avaliacaoEP());
		} catch (NumberFormatException ex) {
			this.avaliacaoEpisodio = 0.0;
		}

		try {
			this.dataDeLancamento = LocalDate.parse(dadosEpisodio.data());
		} catch (Exception ex) {
			this.dataDeLancamento = null;
		}

	}

	public Episodio() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Integer getNumeroTemporada() {
		return numeroTemporada;
	}

	public void setNumeroTemporada(Integer numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}

	public String getTituloEpisodio() {
		return tituloEpisodio;
	}

	public void setTituloEpisodio(String tituloEpisodio) {
		this.tituloEpisodio = tituloEpisodio;
	}

	public Integer getNumeroEpisodio() {
		return numeroEpisodio;
	}

	public void setNumeroEpisodio(Integer numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}

	public Double getAvaliacaoEpisodio() {
		return avaliacaoEpisodio;
	}

	public void setAvaliacaoEpisodio(Double avaliacaoEpisodio) {
		this.avaliacaoEpisodio = avaliacaoEpisodio;
	}

	public LocalDate getDataDeLancamento() {
		return dataDeLancamento;
	}

	public void setDataDeLancamento(LocalDate dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}

	@Override
	public String toString() {
		return "Número da Temporada: " + numeroTemporada + "\n" + "Título do Episódio: " + tituloEpisodio + "\n"
				+ "Número do Episódio: " + numeroEpisodio + "\n" + "Avaliação do Episódio: " + avaliacaoEpisodio + "\n"
				+ "Data de Lançamento: " + dataDeLancamento + "\n";
	}
}
