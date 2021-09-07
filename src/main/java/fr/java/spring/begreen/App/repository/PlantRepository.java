package fr.java.spring.begreen.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.java.spring.begreen.App.model.Plant;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
