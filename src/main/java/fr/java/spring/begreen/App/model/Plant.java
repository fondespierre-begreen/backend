package fr.java.spring.begreen.App.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String latin;

    private String description;

    @JsonIgnore
    @OneToOne(mappedBy = "plant", optional = true)
    private Question question;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Learner learner;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "plant")
    private List<Photo> photos = new ArrayList<Photo>();

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "plant")
    private List<Choice> choices = new ArrayList<Choice>();


}
