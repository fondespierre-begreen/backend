package fr.java.spring.begreen.App.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Photo;
import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.PlantRepository;
import fr.java.spring.begreen.App.service.PlantService;

@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
@RestController
public class PlantController {

    @Autowired PlantService plantService;
    @Autowired PlantRepository plantRepository;

    @Autowired EntityManager em;

    /**
     * Crée un toute les plantes JSON
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
     * Récupère toute les plantes
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/plants")
    public Iterable<Plant> getPlants() throws Exception {
        return this.plantService.findAll();
    }

    /**
     * Récupère une plante par son id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/plants/{id}")
    public Plant getPlantById(@PathVariable(value = "id") Long id) throws Exception {
        return this.plantService.findById(id);
    }

    /**
     * Modifier une plante par son id
     * @param id
     * @return
     * @throws Exception
     */
    @PutMapping(path = "/plants/edit/{id}")
    public Plant editPlant(@PathVariable Long id) throws Exception {
        return this.plantService.editOne(id);
    }

    /**
     * Crée une plante a l'apprenant
     * @param id = learner id
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/plants/add/{id}")
    public Plant createPlant(@RequestBody Plant plant, @PathVariable Long id) throws Exception {
        return this.plantService.postOne(plant, id);
    }


}
