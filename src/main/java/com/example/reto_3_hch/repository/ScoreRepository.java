package com.example.reto_3_hch.repository;

import com.example.reto_3_hch.entities.Score;
import com.example.reto_3_hch.repository.CrudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score p){
        return scoreCrudRepository.save(p);
    }
    public void delete(Score p){
        scoreCrudRepository.delete(p);
    }
}
