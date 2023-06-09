package com.example.reto_3_hch.repository;


import com.example.reto_3_hch.entities.Gama;
import com.example.reto_3_hch.repository.CrudRepository.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {


        @Autowired
        private GamaCrudRepository gamaCrudRepository;

        public List<Gama> getAll(){
            return (List<Gama>) gamaCrudRepository.findAll();
        }
        public Optional<Gama> getGama(int id){return gamaCrudRepository.findById(id);}
        public Gama save(Gama p){
            return gamaCrudRepository.save(p);
        }
        public void delete(Gama p){
            gamaCrudRepository.delete(p);
        }


}
