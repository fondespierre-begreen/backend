package fr.java.spring.begreen.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.java.spring.begreen.App.model.Serie;
import fr.java.spring.begreen.App.repository.SerieRepository;

@Service
public class SerieService {
    
    @Autowired SerieRepository serieRepository;

    /**
     * Find list of serie
     * @return
     * @throws Exception
     */
    public Iterable<Serie> findAll() throws Exception {
        Iterable<Serie> series = this.serieRepository.findAll();
        if(!series.iterator().hasNext()) throw new Exception();
        return series;
    }

    /**
     * Find a serie by id
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
     * Create a serie
     * @param serie
     * @return
     * @throws Exception
     */
    public Serie postOne(Serie serie) throws Exception{
        if(serie == null) throw new Exception();
        serie.getQuestions().iterator().forEachRemaining(question -> {
            question.setSerie(serie);
        });

        this.serieRepository.save(serie);
        return serie;

    }

    /**
     * Edit a serie
     * @param id
     * @return
     * @throws Exception
     */
    public Serie editOne(Long id) throws Exception{
        Serie serie = this.serieRepository.findById(id).get();
        if(id == null || serie == null) throw new Exception();
        //your edits for serie object
        this.serieRepository.save(serie);

        return serie;
    }

    /**
     * Delete a serie
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
