package com.central.main.controllers;

import com.central.main.DTOs.EventsDTO;
import com.central.main.entity.Events;
import com.central.main.service.EventsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/errors")
public class EventsController {

    private EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping
    public ResponseEntity<List<Events>> findAll() {
//        List<Events> eventsList = this.eventsService.findAll();
//        return new ResponseEntity<List<Events>>(new List<EventsDTO(eventsList.stream().map(event -> {
//            event.get
//        }))>, HttpStatus.OK);
        return new ResponseEntity<>(this.eventsService.findAll(), HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<QuoteDTO> getQuote() {
//        Quote quote = quoteService.getQuote();
//        return new ResponseEntity<QuoteDTO>(new QuoteDTO(quote.getId(), quote.getActor(), quote.getQuote()), HttpStatus.OK);
//    }

}
