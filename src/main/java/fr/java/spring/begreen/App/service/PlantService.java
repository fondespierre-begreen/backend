package fr.java.spring.begreen.App.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Learner;
import fr.java.spring.begreen.App.model.Photo;
import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.LearnerRepository;
import fr.java.spring.begreen.App.repository.PlantRepository;

@Service
public class PlantService {

    @Autowired PlantRepository plantRepository;
    @Autowired LearnerRepository learnerRepository;

    private String uri = "http://localhost:9090";
    private String folder = "src/main/resources/static/images/";

    /**
     * Récupère la liste de plantes en bdd
     * @return
     * @throws Exception
     */
    public Iterable<Plant> findAll() throws Exception {

        Iterable<Plant> plants = this.plantRepository.findAll();
        if(!plants.iterator().hasNext()) throw new Exception();
        return plants;
    }

    /**
     * Récupère une plante par son id de la bdd
     * @param id
     * @return
     * @throws Exception
     */
    public Plant findById(Long id) throws Exception {

        Plant plant = this.plantRepository.findById(id).get();
        if(plant == null || id == null) throw new Exception();
        return plant;
    }

    /**
     * Crée une plante en bdd avec photo
     * @param plant, id = user_id
     * @return
     * @throws Exception
     */
    public Plant postOne(Plant plant, Long id) throws Exception {
        if(plant == null || id == null) throw new Exception();

        if(plant.getFile() != null){
            
            Path path = Paths.get(this.folder + plant.getFile().getOriginalFilename());
            plant.getFile().transferTo(path);
            
            Photo p = new Photo();
            p.setPlant(plant);
            p.setUrl(this.uri + "/images/" + plant.getFile().getOriginalFilename());
            ArrayList<Photo> arr = new ArrayList<Photo>();
            arr.add(p);
            plant.setPhotos(arr);
        }
        
        Learner learner = this.learnerRepository.findById(id).get();
        plant.setLearner(learner);
        this.plantRepository.save(plant);

        return plant;
    }

    /**
     * Modifie une plante en bdd par son id
     * @param id
     * @return
     * @throws Exception
     */
    public Plant editOne(Plant plant) throws Exception {
        if(plant == null) throw new Exception();
        if(plant.getFile() != null){
            Path path = Paths.get(this.folder + plant.getFile().getOriginalFilename());
            plant.getFile().transferTo(path);
            Photo p = new Photo();
            p.setPlant(plant);
            p.setUrl(this.uri + "/images/" + plant.getFile().getOriginalFilename());
            ArrayList<Photo> arr = new ArrayList<Photo>();
            arr.add(p);
            plant.setPhotos(arr);
        }
        this.plantRepository.save(plant);

        return plant;
    }

    /**
     * Supprime une plante par son id
     * @param id
     * @return
     * @throws Exception
     */
    public Plant deleteOne(Long id) throws Exception {

        Plant plant = this.plantRepository.findById(id).get();
        if(plant == null || id == null) throw new Exception();
        this.plantRepository.delete(plant);
        return plant;
    }


    /**
     * Recherche la derniere plante dans la bdd
     */
    public Integer getLastPlant(){
       Iterable<Plant> plants = this.plantRepository.findAll();
       
       ArrayList arr = new ArrayList<>();
       plants.spliterator().forEachRemaining(plant -> {
            arr.add(plant);
        });
        return arr.size();
    }
}
