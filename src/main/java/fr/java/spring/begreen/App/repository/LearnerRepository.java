package fr.java.spring.begreen.App.repository;

import org.springframework.data.repository.CrudRepository;

import fr.java.spring.begreen.App.model.Learner;

public interface LearnerRepository extends CrudRepository<Learner, Long> {
    
}
