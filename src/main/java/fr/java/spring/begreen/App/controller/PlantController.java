package fr.java.spring.begreen.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.PlantRepository;

@CrossOrigin(origins = "http://localhost:8000", allowedHeaders = "*")
@RestController
public class PlantController {

    @Autowired
    PlantRepository plantRepository;

    @GetMapping(path = "/plants/test")
    public Plant getNewPlants() {
        Plant p1 = new Plant();
        p1.setId(1L);
        p1.setName("rose");
        p1.setLatin("rosa");
        p1.setDescription("Some flower that gets you grls !");
        this.plantRepository.save(p1);
        return p1;
    }

    @GetMapping(path = "/plants")
    public Iterable<Plant> getPlants() {
        return this.plantRepository.findAll();
    }

}
