package com.riwi.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.event.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String>{

    public Event findByName(String name); //Buscar por nombre

}
