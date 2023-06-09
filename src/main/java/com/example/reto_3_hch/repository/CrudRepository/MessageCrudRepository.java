package com.example.reto_3_hch.repository.CrudRepository;

import com.example.reto_3_hch.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
