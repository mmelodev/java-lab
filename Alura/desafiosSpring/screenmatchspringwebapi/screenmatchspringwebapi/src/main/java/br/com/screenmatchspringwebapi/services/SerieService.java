package br.com.screenmatchspringwebapi.services;

import br.com.screenmatchspringwebapi.dto.EpisodioDTO;
import br.com.screenmatchspringwebapi.dto.SerieDTO;
import br.com.screenmatchspringwebapi.model.Serie;
import br.com.screenmatchspringwebapi.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//anotação definindo que se trata de um serviço -> tirando responsabilidades do controller e separando as coisas adequadamente (boas práticas)
@Service
public class SerieService {

    @Autowired
    private SerieRepository repositorio;

    private List<SerieDTO> converteDados(List<Serie> series){
        return series.stream()
                .map(s -> new SerieDTO(s.getId(),s.getTitulo(), s.getAvaliacaoImdb(), s.getTotalTemporada(), s.getCategoria(), s.getDescricao(), s.getAtores(), s.getPoster()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obterTodasAsSeries(){
        return converteDados(repositorio.findAll());
    }

    public List<SerieDTO> obterTop5Serie() {
        return converteDados(repositorio.findTop5ByOrderByAvaliacaoImdbDesc());
    }

    public List<SerieDTO> obterLancamentos() {
        return converteDados(repositorio.listarLancamentos());
    }

    public SerieDTO obterPorId(Long id) {
        Optional<Serie> serie = repositorio.findById(id);

        if (serie.isPresent()){
            Serie s = serie.get();
            return new SerieDTO(s.getId(),s.getTitulo(), s.getAvaliacaoImdb(), s.getTotalTemporada(), s.getCategoria(), s.getDescricao(), s.getAtores(), s.getPoster());
        }

        return null;
    }

    public List<EpisodioDTO> obterTodasTemporadas(Long id) {
        Optional<Serie> serie = repositorio.findById(id);

        if (serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodioDTO(e.getNumeroTemporada(), e.getNumeroEpisodio(), e.getTituloEpisodio()))
                    .collect(Collectors.toList());
        }

        return null;
    }
}
