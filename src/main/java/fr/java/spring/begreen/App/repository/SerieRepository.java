package fr.java.spring.begreen.App.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.java.spring.begreen.App.model.Serie;

public interface SerieRepository extends CrudRepository<Serie, Long>{
    
    @Query(value = "select * from serie ", nativeQuery = true)
    Serie findSerieByPlantId();
}
