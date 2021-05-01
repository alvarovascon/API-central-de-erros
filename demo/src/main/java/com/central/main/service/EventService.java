package com.central.main.service;


import com.central.main.Model.EventPage;
import com.central.main.entity.Event;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EventService {
    Page<Event> findAll(EventPage eventPage);

    Optional<Event> findById(Long id);

    Page<Event> findByLevel(String level, EventPage eventPage);

    Page<Event> findByLog(String log, EventPage eventPage);

    Page<Event> findByOrigin(String origin, EventPage eventPage);

    Page<Event> findByEventDateContaining(String date, EventPage eventPage);

    Integer getByLevelCount(String level);

    Event save(Event event);
}
