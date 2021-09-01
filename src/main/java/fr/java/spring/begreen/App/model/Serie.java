package fr.java.spring.begreen.App.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "serie")
public class Serie {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer total;

    // private Date date;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Question> questionsList;
}