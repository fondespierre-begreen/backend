package fr.java.spring.begreen.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Question;
import fr.java.spring.begreen.App.model.Serie;
import fr.java.spring.begreen.App.repository.SerieRepository;

@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
@RestController
public class SerieController {
    
    @Autowired SerieRepository serieRepository;

    @GetMapping(path = "/series")
    public Iterable<Serie> getSeries() {
        return this.serieRepository.findAll();
    }

    @PostMapping(path = "/series/create")
    public Serie postSerie(@RequestBody Serie serie){
        System.out.print(serie);
        Question q = new Question();
        q.setId(1L);
        this.serieRepository.save(serie);
        return serie;
    }
    
}