package fr.java.spring.begreen.App.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.java.spring.begreen.App.model.Plant;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {

    @Query(value = "select * from plant where learner_id is NULL", nativeQuery = true)
    public Iterable<Plant> getPublicPlants();
}
