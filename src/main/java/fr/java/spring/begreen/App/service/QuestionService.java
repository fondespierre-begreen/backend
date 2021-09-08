package fr.java.spring.begreen.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Question;
import fr.java.spring.begreen.App.repository.QuestionRepository;

@Service
public class QuestionService {
    
    @Autowired QuestionRepository questionRepository;

    public Question postOne(Question question) throws Exception {
        if(question == null) throw new Exception();
        this.questionRepository.save(question);
        return question;
    }
}
