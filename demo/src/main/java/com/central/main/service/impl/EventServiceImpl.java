package com.central.main.service.impl;

import com.central.main.Model.EventPage;
import com.central.main.entity.Event;
import com.central.main.repository.EventRepository;
import com.central.main.service.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    public EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Page<Event> findAll(EventPage eventPage) {
        Sort sort = Sort.by(eventPage.getDirection(), eventPage.getSortBy());
        Pageable pageable = PageRequest.of(eventPage.getPageNumber(), eventPage.getPageSize(), sort);
        return eventRepository.findAll(pageable);
    }

    public Optional<Event> findById(Long id) { return eventRepository.findById(id);}

    public Page<Event> findByLevel(String level, EventPage eventPage) {
        Sort sort = Sort.by(eventPage.getDirection(), eventPage.getSortBy());
        Pageable pageable = PageRequest.of(eventPage.getPageNumber(), eventPage.getPageSize(), sort);
        return eventRepository.findByLevel(level, pageable);
    }

    public Page<Event> findByLog(String log, EventPage eventPage) {
        Sort sort = Sort.by(eventPage.getDirection(), eventPage.getSortBy());
        Pageable pageable = PageRequest.of(eventPage.getPageNumber(), eventPage.getPageSize(), sort);
        return eventRepository.findByLog(log, pageable);
    }

    public Page<Event> findByOrigin(String origin, EventPage eventPage) {
        Sort sort = Sort.by(eventPage.getDirection(), eventPage.getSortBy());
        Pageable pageable = PageRequest.of(eventPage.getPageNumber(), eventPage.getPageSize(), sort);
        return eventRepository.findByOrigin(origin, pageable);
    }

    public Page<Event> findByEventDateContaining(String date, EventPage eventPage) {
        Sort sort = Sort.by(eventPage.getDirection(), eventPage.getSortBy());
        Pageable pageable = PageRequest.of(eventPage.getPageNumber(), eventPage.getPageSize(), sort);
        return eventRepository.findByEventDateContaining(date, pageable);
    }

    public Integer getByLevelCount(String level) {
        return eventRepository.getByLevelCount(level);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }
}
