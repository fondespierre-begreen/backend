package fr.java.spring.begreen.App.repository;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.java.spring.begreen.App.model.Serie;

public interface SerieRepository extends CrudRepository<Serie, Long>{
    
    @Query(value = "select p.id, p.name, q.id as qId, q.description, ph.url , c.description from plant p join question q on p.id = q.plant_id join photo ph on ph.plant_id = p.id right outer join choice c on c.question_id = q.id where q.id in (select q.id from question q inner join serie s on s.id = q.serie_id where s.id = :serie_id); ", nativeQuery = true)
    Serie find(@PathVariable(value = "serie_id") Long serie_id);
}
