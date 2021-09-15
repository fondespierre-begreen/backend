package fr.java.spring.begreen.App.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.servlet.annotation.HttpConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    @JsonIgnore
    private Serie serie;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Plant plant;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL, CascadeType.MERGE})
    private List<Choice> choices = new ArrayList<Choice>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<Answer>();

    private void setChoices(List<Choice> choices){
        for(int i = 0; i < 4; i++) {
            choices.add(this.choices.get(i));
        }
    }

}
