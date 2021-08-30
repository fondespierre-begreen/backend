package fr.java.spring.begreen.App.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.PlantRepository;

@CrossOrigin(origins = "http://localhost:8000", allowedHeaders = "*")
@RestController
public class PlantController {

    @Autowired
    PlantRepository plantRepository;

    @PostMapping(path = "/plants/init")
    public void getInitPlants(@RequestBody Plant[] initPlants) {
        ArrayList<Plant> plants = new ArrayList<Plant>();

        for (int i = 0; i < initPlants.length; ++i) {
            plants.add(initPlants[i]);
        }

        this.plantRepository.saveAll(plants);
    }

    @GetMapping(path = "/plants")
    public Iterable<Plant> getPlants() {
        return this.plantRepository.findAll();
    }

    @GetMapping(path = "/plants/{id}")
    public Plant getPlantById(@PathVariable(value = "id") Long id) {
        return this.plantRepository.findById(id).get();
    }

}
