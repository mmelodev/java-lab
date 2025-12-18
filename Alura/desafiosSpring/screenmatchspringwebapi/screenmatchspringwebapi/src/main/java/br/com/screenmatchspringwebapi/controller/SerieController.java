package br.com.screenmatchspringwebapi.controller;

import br.com.screenmatchspringwebapi.dto.SerieDTO;
import br.com.screenmatchspringwebapi.model.Serie;
import br.com.screenmatchspringwebapi.repository.SerieRepository;
import br.com.screenmatchspringwebapi.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {


    private SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    //como eu já defini "series" como padrão no requestmapping, então aqui só deixo o getmapping sem parametro mesmo
    @GetMapping
    public List<SerieDTO> obterSeries(){
        return serieService.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5(){
        return serieService.obterTop5Serie();
    }
}
