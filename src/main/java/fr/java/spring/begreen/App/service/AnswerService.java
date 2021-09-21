package fr.java.spring.begreen.App.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Answer;
import fr.java.spring.begreen.App.repository.AnswerRepository;

@Service
public class AnswerService {
    
    @Autowired AnswerRepository answerRepository;


    public List<Answer> postAnswers(List<Answer> answers){

        answers.iterator().forEachRemaining(a -> {
            this.answerRepository.save(a);
        });
        return answers;
    }
}
