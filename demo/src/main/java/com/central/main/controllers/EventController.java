package com.central.main.controllers;

import com.central.main.DTOs.EventDTO;
import com.central.main.entity.Event;
import com.central.main.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/errors")
public class EventController {

    @Autowired
    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> findAll() {
        List<Event> eventList = this.eventService.findAll();
        return new ResponseEntity<>(eventList.stream().map(event -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.eventService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/level/{levelName}")
    public ResponseEntity<List<EventDTO>> findByLevel(@PathVariable("levelName") String level) {
        List<Event> eventList = this.eventService.findByLevel(level);
        return new ResponseEntity<>(eventList.stream().map(event -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    // log origem data
    @GetMapping("/log/{logInfo}")
    public ResponseEntity<List<EventDTO>> findByLog(@PathVariable("logInfo") String log) {
        List<Event> eventList = this.eventService.findByLog(log);
        return new ResponseEntity<>(eventList.stream().map(event -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/origin/{origin}")
    public ResponseEntity<List<EventDTO>> findByOrigin(@PathVariable("origin") String origin) {
        List<Event> eventList = this.eventService.findByOrigin(origin);
        return new ResponseEntity<>(eventList.stream().map(event -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<EventDTO>> findByDate(@PathVariable("date") String date) {
        List<Event> eventList = this.eventService.findByEventDateContaining(date);
        return new ResponseEntity<>(eventList.stream().map(event -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/count/{level}")
    public ResponseEntity<Integer> getByLevelCount(@PathVariable("level") String level) {
        return new ResponseEntity<>(this.eventService.getByLevelCount(level), HttpStatus.OK);
    }
}
