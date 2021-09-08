package fr.java.spring.begreen.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Serie;
import fr.java.spring.begreen.App.repository.SerieRepository;

@Service
public class SerieService {
    
    @Autowired SerieRepository serieRepository;

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
    public Serie findById(Long id) throws Exception{
        if(id == null) throw new Exception();
        Serie serie = this.serieRepository.findById(id).get();
        
        return serie;
    }

    /**
     * Crée une serie en bdd
     * @param serie
     * @return
     * @throws Exception
     */
    public Serie postOne(Serie serie) throws Exception{
        // serie.getQuestions().iterator().forEachRemaining(question -> {
        //     question.setSerie(serie);
        // });

        if(serie == null) throw new Exception();
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
}
