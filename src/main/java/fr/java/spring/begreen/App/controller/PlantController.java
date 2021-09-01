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
import fr.java.spring.begreen.App.service.PlantService;

@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
@RestController
public class PlantController {

    @Autowired PlantService plantService;
    @Autowired PlantRepository plantRepository;

    /**
     * Posting all datas in bdd
     * @param initPlants
     */
    @PostMapping(path = "/plants/init")
    public void getInitPlants(@RequestBody Plant[] initPlants) {
        ArrayList<Plant> plants = new ArrayList<Plant>();

        for (int i = 0; i < initPlants.length; ++i) {
            plants.add(initPlants[i]);
        }

        this.plantRepository.saveAll(plants);
    }

    /**
     * Get plants[] data
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/plants")
    public Iterable<Plant> getPlants() throws Exception {
        return this.plantService.findAll();
    }

    /**
     * Get plant by id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/plants/{id}")
    public Plant getPlantById(@PathVariable(value = "id") Long id) throws Exception {
        return this.plantService.findById(id);
    }

}
