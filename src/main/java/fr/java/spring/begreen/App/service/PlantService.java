package fr.java.spring.begreen.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.PlantRepository;

@Service
public class PlantService {

    @Autowired PlantRepository plantRepository;

    public Iterable<Plant> findAll() throws Exception {

        Iterable<Plant> plants = this.plantRepository.findAll();
        if(!plants.iterator().hasNext()) throw new Exception();
        return plants;
    }

    public Plant findById(Long id) throws Exception {

        Plant plant = this.plantRepository.findById(id).get();
        if(plant == null || id == null) throw new Exception();
        return plant;
    }

    public Plant postOne(Plant plant) throws Exception {

        if(plant == null) throw new Exception();
        this.plantRepository.save(plant);
        return plant;
    }

    public Plant editOne(Long id) throws Exception {

        Plant plant = this.plantRepository.findById(id).get();
        if(plant == null || id == null) throw new Exception();
        //add your edits to plant object (exemple : plant.setDescription("etc"))
        return plant;
    }

    public Plant deleteOne(Long id) throws Exception {

        Plant plant = this.plantRepository.findById(id).get();
        if(plant == null || id == null) throw new Exception();
        this.plantRepository.delete(plant);
        return plant;
    }


}
