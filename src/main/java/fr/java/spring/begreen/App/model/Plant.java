package fr.java.spring.begreen.App.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Plant {

    @Id
    private Long id;

    private String name;

    private String latin;

    private String description;

}
