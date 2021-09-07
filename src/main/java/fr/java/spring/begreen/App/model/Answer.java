package fr.java.spring.begreen.App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Learner unique answer.
    @JsonIgnore
    @ManyToOne
    private Choice choice;

    @JsonIgnore
    @ManyToOne
    private Learner learner;

    
    @JsonIgnore
    @ManyToOne
    private Question question;



}
