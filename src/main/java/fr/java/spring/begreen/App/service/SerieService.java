package fr.java.spring.begreen.App.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Plant;
import fr.java.spring.begreen.App.model.Serie;
import fr.java.spring.begreen.App.repository.SerieRepository;
import fr.java.spring.begreen.App.repository.PlantRepository;

@Service
public class SerieService {
    
    @Autowired SerieRepository serieRepository;
    @Autowired PlantRepository planteRepository;

    /**
     * Récupère toute les serie de la bdd
     * @return
     * @throws Exception
     */
    public Iterable<Serie> findAll() throws Exception {
        Iterable<Serie> series = this.serieRepository.findAll();
        if(!series.iterator().hasNext()) throw new Exception();
        return series;
    }

    /**
     * Récupère une serie par son id de la bdd
     * @param id
     * @return
     * @throws Exception
     */
    public Serie findById(Long serie_id) throws Exception{
        if(serie_id == null) throw new Exception();
        
        return this.serieRepository.find(serie_id);
    }

    /**
     * Lors qu'on passe une serie en bdd
     * @param serie
     * @return
     * @throws Exception
     */
    public Serie postOne(Serie serie) throws Exception{

        if(serie == null) throw new Exception();
        serie.getQuestions().iterator().forEachRemaining(q -> {
            q.setSerie(serie);
            Long id = q.getPlant().getId();
            Plant plant = this.planteRepository.findById(id).get();

            if(plant.getFile() != null){
                q.getPlant().getPhotos().iterator().forEachRemaining(ph -> {
                    ph.setPlant(q.getPlant());
                });
            }
            q.setPlant(plant);
            q.getChoices().iterator().forEachRemaining(c -> {
                c.setPlant(plant);
                c.setQuestion(q);
                q.getAnswers().iterator().forEachRemaining(a -> { 
                    a.setQuestion(q);
                    a.setLearner(plant.getLearner());
                });
            });
            
        });
        
        this.serieRepository.save(serie);
        return serie;

    }

    /**
     * Modifi la serie par son id
     * @param id
     * @return
     * @throws Exception
     */
    public Serie editOne(Long id) throws Exception{
        Serie serie = this.serieRepository.findById(id).get();
        if(id == null || serie == null) throw new Exception();
        //les modifications a faire ici.
        this.serieRepository.save(serie);

        return serie;
    }

    /**
     * Supprime une serie par son id
     * @param id
     * @return
     * @throws Exception
     */
    public Serie deleteOne(Long id) throws Exception{
        Serie serie = this.serieRepository.findById(id).get();
        if(id == null || serie == null) throw new Exception();
        //your edits for serie object
        this.serieRepository.delete(serie);

        return serie;
    }

    /**
     * Crée une serie en bdd
     * @param serie
     * @return
     * @throws Exception
     */
    public Serie createSerie(Serie serie) throws Exception {
        if(serie == null) throw new Exception();
        serie.getQuestions().iterator().forEachRemaining(q -> {
            q.setSerie(serie);
            Long id = q.getPlant().getId();
            Plant plant = this.planteRepository.findById(id).get();

            if(plant.getFile() != null){
                q.getPlant().getPhotos().iterator().forEachRemaining(ph -> {
                    ph.setPlant(q.getPlant());
                });
            }
            q.setPlant(plant);
            q.getChoices().iterator().forEachRemaining(c -> {
                c.setPlant(plant);
                c.setQuestion(q);
            });
            // serie.setCreatedAt((new Date()));
        });
        
        this.serieRepository.save(serie);
        return serie;
    }
}
