package fr.java.spring.begreen.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Serie;
import fr.java.spring.begreen.App.service.SerieService;

@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
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
     * Crée une serie
     * @param serie
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/series")
    public Serie postSerie(@RequestBody Serie serie) throws Exception{
        return this.serieService.postOne(serie);
    }
    
    
}