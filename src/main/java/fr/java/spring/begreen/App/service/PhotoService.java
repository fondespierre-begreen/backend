package fr.java.spring.begreen.App.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Photo;
import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.PlantRepository;

@Service
public class PhotoService {

    @Autowired PlantRepository plantRepository;
    

    public Plant postPhoto(Photo photo, Long id) throws Exception{ //id plante
        if(photo == null || id == null) throw new Exception();
        Plant plant = this.plantRepository.findById(id).get();
        photo.setPlant(plant);
        ArrayList<Photo> arr = new ArrayList<Photo>();
        arr.add(photo);
        plant.setPhotos(arr);

        this.plantRepository.save(plant);

        return this.plantRepository.findById(id).get();
    
    }
}
