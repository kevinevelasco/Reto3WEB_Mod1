package com.example.reto_3_hch.service;


import com.example.reto_3_hch.entities.Car;
import com.example.reto_3_hch.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.getAll();
    }
    public Optional<Car> getCar(int id){return carRepository.getCar(id);
    }
    public Car save(Car p){
        if (p.getIdCar()==null){
            return  carRepository.save(p);
        }else {
            Optional<Car> e= carRepository.getCar(p.getIdCar());
            if (e.isPresent()){
                return p;
            }else{
                return carRepository.save(p);
            }
        }
    }
    public Car update(Car p){
        if (p.getIdCar()!=null){
            Optional<Car> q = carRepository.getCar(p.getIdCar());
            if (q.isPresent()){
                if (p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if (p.getBrand()!=null){
                    q.get().setBrand(p.getBrand());
                }
                if (p.getYear()!=null){
                    q.get().setYear(p.getYear());
                }
                if (p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if (p.getGama()!=null){
                    q.get().setGama(p.getGama());
                }
                if (p.getMessages()!=null){
                    q.get().setMessages(p.getMessages());
                }
                if (p.getReservations()!=null){
                    q.get().setReservations(p.getReservations());
                }
                carRepository.save(q.get());
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
        Optional<Car>p= carRepository.getCar(id);
        if (p.isPresent()){
            carRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

