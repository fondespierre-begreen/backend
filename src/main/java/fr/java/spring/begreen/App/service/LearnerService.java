package fr.java.spring.begreen.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Learner;
import fr.java.spring.begreen.App.repository.LearnerRepository;

@Service
public class LearnerService {
    
    @Autowired LearnerRepository learnerRepository;

    /**
     * Récupère la listes des apprenants en bdd
     * @return
     * @throws Exception
     */
    public Iterable<Learner> findAll() throws Exception {
        Iterable<Learner> learners = this.learnerRepository.findAll();
        // if(!learners.iterator().hasNext()) throw new Exception();

        return learners;
    }

    /**
     * Récupère un apprenant par son id en bdd
     * @return
     * @throws Exception
     */
    public Learner findById(Long id) throws Exception {
        Learner learner = this.learnerRepository.findById(id).get();
        if(id == null || learner == null) throw new Exception();
        
        return learner;
    }

    /**
     * Crée un nouvelle utilisateur
     * @param learner
     * @return
     * @throws Exception
     */
    public Learner postOne(Learner learner) throws Exception {
        // learner.getPlants().iterator().forEachRemaining(plant -> {
            //     plant.setLearner(learner);
            // });
            
        if(learner == null) throw new Exception();
        //ici faire les modifications sur l'apprenant
        this.learnerRepository.save(learner);
        
        return learner;
    }
}
