package fr.java.spring.begreen.App.controller;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.SequenceGenerators;
import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.PlantRepository;
import fr.java.spring.begreen.App.service.PlantService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @PatchMapping(path = "/plants/edit", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public Plant editPlant(@ModelAttribute Plant plant, @RequestPart(required = false) MultipartFile file) throws Exception {
        return this.plantService.editOne(plant);
    }

    /**
     * Crée une plante a l'apprenant avec photo
     * @param id = learner id
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/plants/add/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_PLAIN_VALUE})
    public Plant createPlant(@ModelAttribute Plant plant, @RequestPart(required = false) MultipartFile file, @PathVariable Long id) throws Exception {
        return this.plantService.postOne(plant, id);
    }

    /**
     * Récupère le derniere id de mes plantes
     * @return
     */
    @GetMapping(path = "/lastPlant")
    public Integer getLastId(){
        return this.plantService.getLastPlant();
    }
    
}
