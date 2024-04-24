package com.riwi.event.services.service_abstract;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.event.entities.Event;

public interface IEventService {
    public Event save(Event event);

    public List<Event> getAll();

    public Event findById(String id);

    public void delete(String id);

    public Event update(String id, Event event);
    
    public Event findByName(String name);

    public Page<Event> getAll(Pageable pageable);
}
