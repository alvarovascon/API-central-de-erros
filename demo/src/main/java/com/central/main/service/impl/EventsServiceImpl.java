package com.central.main.service.impl;

import com.central.main.entity.Events;
import com.central.main.repository.EventsRepository;
import com.central.main.service.EventsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    public EventsRepository eventsRepository;

    public EventsServiceImpl(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<Events> findAll() {
        return eventsRepository.findAll();
    }
}
