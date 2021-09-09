package fr.java.spring.begreen.App.model;

import java.util.List;
import java.sql.Array;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.transaction.TransactionScoped;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.web.multipart.MultipartFile;

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
    private List<Photo> photos;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "plant")
    private List<Choice> choices = new ArrayList<Choice>();

    @Transient
    private MultipartFile file;

    // public void setFile(List<MultipartFile> files){
    //     files.iterator().forEachRemaining(img ->{
    //         Photo photo = new Photo();
    //         photo.setUrl(img.getOriginalFilename());
    //     });
    // }

}
