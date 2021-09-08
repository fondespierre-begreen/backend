package fr.java.spring.begreen.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Question;
import fr.java.spring.begreen.App.repository.QuestionRepository;
import fr.java.spring.begreen.App.service.QuestionService;

@RestController
public class QuestionController {
    
    @Autowired QuestionService questionService;

    @PostMapping(path = "/questions")
    public Question createQuestion(@RequestBody Question question) throws Exception{
        this.questionService.postOne(question);
        return question;
    }
}
