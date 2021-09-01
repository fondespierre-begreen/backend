package fr.java.spring.begreen.App.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
@RestController
public class LearnerController {

    @GetMapping(value = "/learners")
    public String getLearners() {
        return "learners";
    }

    @GetMapping(value = "/learners/{id}")
    public String getLearnersById(@PathVariable(value = "id") Long id){
        return "learners"+id;
    }
    
}
