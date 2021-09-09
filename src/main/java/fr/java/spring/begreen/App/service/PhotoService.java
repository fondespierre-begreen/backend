package fr.java.spring.begreen.App.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoService {
    
    public void uploadFile(MultipartFile file) throws IllegalStateException, IOException{
        file.transferTo(new File("/root/app/app/src/main/java/fr/java/spring/begreen/App/Assets/"+file.getOriginalFilename()));
    }
}
