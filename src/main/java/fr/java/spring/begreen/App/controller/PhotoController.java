package fr.java.spring.begreen.App.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.java.spring.begreen.App.service.PhotoService;

@RestController
public class PhotoController {
    
    @Autowired PhotoService photoService;

    @PostMapping(path = "/photo/upload")
    public void uploadFile(@RequestParam("image") MultipartFile file) throws IllegalStateException, IOException{
        this.photoService.uploadFile(file);
    }
}
