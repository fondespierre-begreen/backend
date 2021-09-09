package fr.java.spring.begreen.App.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.sound.sampled.Line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

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
    @PatchMapping(path = "/plants/edit")
    public Plant editPlant(@RequestBody Plant plant) throws Exception {
        return this.plantService.editOne(plant);
    }

    /**
     * Crée une plante a l'apprenant
     * @param id = learner id
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/plants/add/{id}", consumes =  {MediaType.MULTIPART_FORM_DATA_VALUE })
    public Plant createPlant(@ModelAttribute Plant plant, @PathVariable Long id) throws Exception {
        return this.plantService.postOne(plant, id);
    }

    // @GetMapping(path = "/assets/{fileName}" ,produces = MediaType.IMAGE_JPEG_VALUE)
    // public ResponseEntity<byte[]> getImages(@PathVariable String fileName) throws Exception {

    //     var imgFile = new ClassPathResource("/root/app/app/src/main/java/fr/java/spring/begreen/App/Assets/cc.jpg");
    //     byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

    //     return ResponseEntity
    //             .ok()
    //             .contentType(MediaType.IMAGE_JPEG)
    //             .body(bytes);
    // }
    
}
