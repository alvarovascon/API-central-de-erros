package com.central.main.repository;

import com.central.main.entity.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    List<Event> findByLevel(String level);

    List<Event> findByLog(String log);

    List<Event> findByOrigin(String origin);

    List<Event> findByEventDateContaining(String date);

    @Query(value = "SELECT count(*) FROM event WHERE level = :level",
            nativeQuery = true)
    Integer getByLevelCount(@Param("level") String level);
}
