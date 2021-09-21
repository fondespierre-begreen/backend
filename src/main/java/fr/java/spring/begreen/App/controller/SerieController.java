package fr.java.spring.begreen.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Serie;
import fr.java.spring.begreen.App.service.SerieService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SerieController {
    
    @Autowired SerieService serieService;

    /**
     * Récupère les series
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/series")
    public Iterable<Serie> getSeries() throws Exception {
        return this.serieService.findAll();
    }

    /**
     * Crée une serie
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/series/{id}")
    public Serie getOneSerie(@PathVariable Long id) throws Exception{
        return this.serieService.findById(id);
    }

    /**
     * Passer une serie 
     * @param serie
     * @return
     * @throws Exception
     */
    @PutMapping(path = "/series/{serieId}/take/{userId}")
    public Serie postSerie(@PathVariable Long serieId, @PathVariable Long userId) throws Exception{
        return this.serieService.takeSerie(serieId, userId);
    }

    /**
     * Crée une serie
     * @param serie
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/createSerie")
    public Serie createSerie(@RequestBody Serie serie) throws Exception{
        return this.serieService.createSerie(serie);
    }


    @PutMapping(path = "/reinit/{id}")
    public Serie reInit(@PathVariable Long id) throws Exception{
        return this.serieService.reInit(id);
    }


    
    
}