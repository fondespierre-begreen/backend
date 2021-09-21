package fr.java.spring.begreen.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.java.spring.begreen.App.model.Answer;
import fr.java.spring.begreen.App.service.AnswerService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class AnswerController {
 
    
    @Autowired AnswerService answerService;

    @PostMapping(path = "/answers")
    public List<Answer> post(@RequestBody List<Answer> answers){
        return this.answerService.postAnswers(answers);
    }

    // @PostMapping(path = "/answers2")
    // public Answer post2(@RequestBody Answer answer){
    //     return this.answerService.postAnswers(answer);
    // }
}
