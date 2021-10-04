package fr.java.spring.begreen.App.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.java.spring.begreen.App.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    
}
