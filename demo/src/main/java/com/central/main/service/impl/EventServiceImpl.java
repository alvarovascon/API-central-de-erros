package com.central.main.service.impl;

import com.central.main.entity.Event;
import com.central.main.repository.EventRepository;
import com.central.main.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    public EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
