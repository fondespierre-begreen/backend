package fr.java.spring.begreen.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Photo;
import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.service.PhotoService;

@RestController
public class PhotoController {
    
    @Autowired PhotoService photoService;


    /**
     * Crée une photo de la plante en bdd
     * @param photo
     * @param id = plant_id
     * @return
     * @throws Exception
    */
    @PostMapping(path = "/photos/add/{id}")
    public Plant postPhoto(@RequestBody Photo photo, @PathVariable Long id) throws Exception{ //id plante
        return this.photoService.postPhoto(photo, id);
    
    }
}
