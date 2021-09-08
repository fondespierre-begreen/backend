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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @JsonIgnore
    @ManyToOne
    private Plant plant;
    
    @ManyToOne
    @JsonIgnore
    private Question question;

    @JsonIgnore
    @OneToMany(mappedBy = "choice", cascade = CascadeType.ALL) //fk_answer
    private List<Answer> answers = new ArrayList<Answer>();


    

}
