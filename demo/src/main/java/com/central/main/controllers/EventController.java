package com.central.main.controllers;

import com.central.main.DTOs.EventDTO;
import com.central.main.Model.EventPage;
import com.central.main.advice.ResourceNotFoundException;
import com.central.main.entity.Event;
import com.central.main.entity.User;
import com.central.main.service.EventService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
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
    public ResponseEntity<Page<EventDTO>> findAll(EventPage eventPage) {
        Page<Event> events = this.eventService.findAll(eventPage);
        List<EventDTO> eventList =  events.stream().map(event
                -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList());
        Page<EventDTO> page = new PageImpl<>(eventList);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Event not found"),
            @ApiResponse(code = 200, message = "Event found")})
    public ResponseEntity<Event> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.eventService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("event")) , HttpStatus.OK);
    }

    @GetMapping("level/{level}")
    public ResponseEntity<Page<EventDTO>> findByLevel(@PathVariable("level") String level, EventPage eventPage) {
        Page<Event> events = this.eventService.findByLevel(level, eventPage);
        List<EventDTO> eventList =  events.stream().map(event
                -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList());
        Page<EventDTO> page = new PageImpl<>(eventList);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/log/{log}")
    public ResponseEntity<Page<EventDTO>> findByLog(@PathVariable("log") String log, EventPage eventPage) {
        Page<Event> events = this.eventService.findByLog(log, eventPage);
        List<EventDTO> eventList =  events.stream().map(event
                -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList());
        Page<EventDTO> page = new PageImpl<>(eventList);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/origin/{origin}")
    public ResponseEntity<Page<EventDTO>> findByOrigin(@PathVariable("origin") String origin, EventPage eventPage) {
        Page<Event> events = this.eventService.findByOrigin(origin, eventPage);
        List<EventDTO> eventList =  events.stream().map(event
                -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList());
        Page<EventDTO> page = new PageImpl<>(eventList);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<Page<EventDTO>> findByDate(@PathVariable("date") String date, EventPage eventPage) {
        Page<Event> events = this.eventService.findByEventDateContaining(date, eventPage);
        List<EventDTO> eventList = events.stream().map(event
                -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList());
        Page<EventDTO> page = new PageImpl<>(eventList);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/count/{level}")
    public ResponseEntity<Integer> getByLevelCount(@PathVariable("level") String level) {
        return new ResponseEntity<>(this.eventService.getByLevelCount(level), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Register new event")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "New event successfully registered")})
    public ResponseEntity<Event> create(@Valid @RequestBody Event event) {
        return new ResponseEntity<Event>(this.eventService.save(event), HttpStatus.CREATED);
    }
}
