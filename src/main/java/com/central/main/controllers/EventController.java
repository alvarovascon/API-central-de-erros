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

    private final String NOT_FOUND = "Não encontrado";
    private final String SUCCESS = "SUCCESS";

    private Page<EventDTO> getDTOsPage (Page<Event> events) {
        List<EventDTO> eventList =  events.stream().map(event
                -> modelMapper.map(event, EventDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(eventList);
    }

    @GetMapping
    @ApiOperation("Lista eventos de erro")
    @ApiResponses(value = {@ApiResponse(code = 404, message = NOT_FOUND),
            @ApiResponse(code = 200, message = SUCCESS)})
    public ResponseEntity<Page<EventDTO>> findAll(EventPage eventPage) {
        Page<Event> events = this.eventService.findAll(eventPage);
        return new ResponseEntity<>(getDTOsPage(events), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca evento de erro por id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = NOT_FOUND),
            @ApiResponse(code = 200, message = SUCCESS)})
    public ResponseEntity<Event> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.eventService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("event")) , HttpStatus.OK);
    }

    @GetMapping("level/{level}")
    @ApiOperation("Busca eventos por nível(level)")
    @ApiResponses(value = {@ApiResponse(code = 404, message = NOT_FOUND),
            @ApiResponse(code = 200, message = SUCCESS)})
    public ResponseEntity<Page<EventDTO>> findByLevel(@PathVariable("level") String level, EventPage eventPage) {
        Page<Event> events = this.eventService.findByLevel(level, eventPage);
        return new ResponseEntity<>(getDTOsPage(events), HttpStatus.OK);
    }

    @GetMapping("/log/{log}")
    @ApiOperation("Busca eventos por log")
    @ApiResponses(value = {@ApiResponse(code = 404, message = NOT_FOUND),
            @ApiResponse(code = 200, message = SUCCESS)})
    public ResponseEntity<Page<EventDTO>> findByLog(@PathVariable("log") String log, EventPage eventPage) {
        Page<Event> events = this.eventService.findByLog(log, eventPage);
        return new ResponseEntity<>(getDTOsPage(events), HttpStatus.OK);
    }

    @GetMapping("/origin/{origin}")
    @ApiOperation("Busca eventos por origem")
    @ApiResponses(value = {@ApiResponse(code = 404, message = NOT_FOUND),
            @ApiResponse(code = 200, message = SUCCESS)})
    public ResponseEntity<Page<EventDTO>> findByOrigin(@PathVariable("origin") String origin, EventPage eventPage) {
        Page<Event> events = this.eventService.findByOrigin(origin, eventPage);
        return new ResponseEntity<>(getDTOsPage(events), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    @ApiOperation("Busca eventos por data")
    @ApiResponses(value = {@ApiResponse(code = 404, message = NOT_FOUND),
            @ApiResponse(code = 200, message = SUCCESS)})
    public ResponseEntity<Page<EventDTO>> findByDate(@PathVariable("date") Timestamp date, EventPage eventPage) {
        Page<Event> events = this.eventService.findByEventDateContaining(date, eventPage);
        return new ResponseEntity<>(getDTOsPage(events), HttpStatus.OK);
    }

    @GetMapping("/count/{level}")
    @ApiOperation("Retorna número de eventos por nível")
    @ApiResponses(value = {@ApiResponse(code = 404, message = NOT_FOUND),
            @ApiResponse(code = 200, message = SUCCESS)})
    public ResponseEntity<Integer> getByLevelCount(@PathVariable("level") String level) {
        return new ResponseEntity<>(this.eventService.getByLevelCount(level), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Registra novo evento de erro")
    @ApiResponses(value = {@ApiResponse(code = 201, message = SUCCESS)})
    public ResponseEntity<Event> create(@Valid @RequestBody Event event) {
        return new ResponseEntity<Event>(this.eventService.save(event), HttpStatus.CREATED);
    }
}
