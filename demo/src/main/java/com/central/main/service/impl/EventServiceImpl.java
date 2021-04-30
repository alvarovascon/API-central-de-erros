package com.central.main.service.impl;

import com.central.main.entity.Event;
import com.central.main.repository.EventRepository;
import com.central.main.service.EventService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    public EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) { return eventRepository.findById(id);}

    public List<Event> findByLevel(String level) { return eventRepository.findByLevel(level); }

    public List<Event> findByLog(String log) {
        return eventRepository.findByLog(log);
    }

    public List<Event> findByOrigin(String origin) {
        return eventRepository.findByOrigin(origin);
    }

    public List<Event> findByEventDateContaining(String date) {
        return eventRepository.findByEventDateContaining(date);
    }

    public Integer getByLevelCount(String level) {
        return eventRepository.getByLevelCount(level);
    }
}
