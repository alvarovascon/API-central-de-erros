package com.central.main.service;


import com.central.main.entity.Event;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAll();

    Optional<Event> findById(Long id);

    List<Event> findByLevel(String level);

    List<Event> findByLog(String log);

    List<Event> findByOrigin(String origin);

    List<Event> findByEventDateContaining(String date);

    Integer getByLevelCount(String level);
}
