package fr.java.spring.begreen.App.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String total;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serie")
    private Set<Question> question = new HashSet<>();

}
