package fr.java.spring.begreen.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.PlantRepository;

@Service
public class PlantService {

    @Autowired PlantRepository plantRepository;

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
     * Crée une plante en bdd
     * @param plant
     * @return
     * @throws Exception
     */
    public Plant postOne(Plant plant) throws Exception {
        // plant.getPhotos().iterator().forEachRemaining(photo -> {
        //     photo.setPlant(plant);
        // });

        if(plant == null) throw new Exception();
        this.plantRepository.save(plant);
        return plant;
    }


    /**
     * Modifie une plante en bdd par son id
     * @param id
     * @return
     * @throws Exception
     */
    public Plant editOne(Long id) throws Exception {

        Plant plant = this.plantRepository.findById(id).get();
        if(plant == null || id == null) throw new Exception();
        //add your edits to plant object (exemple : plant.setDescription("etc"))
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


}
