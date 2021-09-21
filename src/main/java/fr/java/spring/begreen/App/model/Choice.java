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

    // @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE})
    private Plant plant;
    
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JsonIgnore
    private Question question;
    

}
