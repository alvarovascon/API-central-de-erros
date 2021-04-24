package com.central.main.repository;

import com.central.main.entity.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends CrudRepository<Events, Long> {

    List<Events> findAll();

}
