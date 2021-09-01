package fr.java.spring.begreen.App.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/series/{id}")
    public Serie getSerieById(@PathVariable(value = "id") Long id) {
        return this.serieRepository.findById(id).get();
    }
}
