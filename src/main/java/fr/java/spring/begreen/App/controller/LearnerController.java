package fr.java.spring.begreen.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Learner;
import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.repository.LearnerRepository;
import fr.java.spring.begreen.App.service.LearnerService;


@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*") //allowed cors request
@RestController
public class LearnerController {

    @Autowired LearnerService learnerService;
    @Autowired LearnerRepository learnerRepository;


    /**
     * Récupère les apprentants
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/learners")
    public Iterable<Learner> getLearners() throws Exception {
        return this.learnerService.findAll();
    }

    /**
     * Récupère apprenant par son id
     * @param id learner
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/learners/{id}")
    public Learner getLearnersById(@PathVariable(value = "id") Long id) throws Exception {
        return this.learnerService.findById(id);
    }

    /**
     * Récupère les plants de l'apprenant par son id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/learners/{id}/plants")
    public List<Plant> getPlantsByLearner(@PathVariable Long id) throws Exception {
        Learner learner = this.learnerService.findById(id);
        return learner.getPlants();
    }
    
}
