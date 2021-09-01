package fr.java.spring.begreen.App.repository;

import org.springframework.data.repository.CrudRepository;

import fr.java.spring.begreen.App.model.Plant;

public interface PlantRepository extends CrudRepository<Plant, Long> {
}
