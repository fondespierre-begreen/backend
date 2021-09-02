package fr.java.spring.begreen.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Learner;
import fr.java.spring.begreen.App.repository.LearnerRepository;

@Service
public class LearnerService {
    
    @Autowired LearnerRepository learnerRepository;

    /**
     * Get all learners from bdd
     * @return
     * @throws Exception
     */
    public Iterable<Learner> findAll() throws Exception {
        Iterable<Learner> learners = this.learnerRepository.findAll();
        if(!learners.iterator().hasNext()) throw new Exception();

        return learners;
    }

    /**
     * Find learner by id in bdd
     * @return
     * @throws Exception
     */
    public Learner findById(Long id) throws Exception {
        Learner learner = this.learnerRepository.findById(id).get();
        if(id == null || learner == null) throw new Exception();
        
        return learner;
    }

    public Learner postOne(Learner learner) throws Exception {
        if(learner == null) throw new Exception();
        
        
        //To service then
        learner.getPlants().iterator().forEachRemaining(plant -> {
            plant.setLearner(learner);
        });
        
        this.learnerRepository.save(learner);
        
        return learner;
    }
}
