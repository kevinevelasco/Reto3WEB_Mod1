package com.example.reto_3_hch.repository.CrudRepository;


import com.example.reto_3_hch.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
