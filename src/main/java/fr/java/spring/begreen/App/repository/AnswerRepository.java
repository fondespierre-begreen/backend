package fr.java.spring.begreen.App.repository;

import org.springframework.data.repository.CrudRepository;

import fr.java.spring.begreen.App.model.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
    
}
