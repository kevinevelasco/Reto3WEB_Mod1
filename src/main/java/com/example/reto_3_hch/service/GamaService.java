package com.example.reto_3_hch.service;


import com.example.reto_3_hch.entities.Gama;
import com.example.reto_3_hch.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GamaService {

    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll(){return gamaRepository.getAll();
    }
    public Optional<Gama> getGama(int id){return gamaRepository.getGama(id);}
    public Gama save(Gama p){
        if (p.getIdGama()==null){
            return  gamaRepository.save(p);
        }else {
            Optional<Gama> e= gamaRepository.getGama(p.getIdGama());
            if (e.isPresent()){
                return p;
            }else{
                return gamaRepository.save(p);
            }
        }
    }
    public Gama update(Gama p){
        if (p.getIdGama()!=null){
            Optional<Gama> q = gamaRepository.getGama(p.getIdGama());
            if (q.isPresent()){
                if (p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if (p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if (p.getCars()!=null){
                    q.get().setCars(p.getCars());
                }
                gamaRepository.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Gama>p= gamaRepository.getGama(id);
        if (p.isPresent()){
            gamaRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
