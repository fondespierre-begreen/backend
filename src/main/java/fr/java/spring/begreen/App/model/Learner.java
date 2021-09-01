package fr.java.spring.begreen.App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Learner {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String firstname;

    String lastname;

    String email;
    
    Boolean role;
}
