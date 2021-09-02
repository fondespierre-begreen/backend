package fr.java.spring.begreen.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Learner;
import fr.java.spring.begreen.App.repository.LearnerRepository;
import fr.java.spring.begreen.App.service.LearnerService;


@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
@RestController
public class LearnerController {

    @Autowired LearnerService learnerService;
    @Autowired LearnerRepository learnerRepository;

    @GetMapping(value = "/learners")
    public Iterable<Learner> getLearners() throws Exception {
        return this.learnerService.findAll();
    }

    @GetMapping(value = "/learners/{id}")
    public Learner getLearnersById(@PathVariable(value = "id") Long id) throws Exception {
        return this.learnerService.findById(id);
    }

    @PostMapping(value = "/learners")
    public Learner postLearner(@RequestBody Learner learner) throws Exception {
        return this.learnerService.postOne(learner);
    }
    
}
