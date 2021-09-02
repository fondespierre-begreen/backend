package fr.java.spring.begreen.App.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String description;

    @ManyToOne()
    private Serie serie;


}
