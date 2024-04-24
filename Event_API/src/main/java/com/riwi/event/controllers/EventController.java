package com.riwi.event.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.event.entities.Event;
import com.riwi.event.services.service_abstract.IEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventController {
    @Autowired
    private final IEventService eventService;

    @PostMapping
    public ResponseEntity<Event> insert(@RequestBody Event event){
        return ResponseEntity.ok(this.eventService.save(event));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(this.eventService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> findById(@PathVariable String id){
        return ResponseEntity.ok(this.eventService.findById(id));
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event event){
        return ResponseEntity.ok(this.eventService.update(id, event));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        this.eventService.delete(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Event> findByName(@PathVariable String name){
        return ResponseEntity.ok(this.eventService.findByName(name));
    }

    @GetMapping(path = "/page/{page}")
    public ResponseEntity<Page<Event>> getAll(@PathVariable Integer page){
        return ResponseEntity.ok(this.eventService.getAll(PageRequest.of(page, 4)));
    }
}
