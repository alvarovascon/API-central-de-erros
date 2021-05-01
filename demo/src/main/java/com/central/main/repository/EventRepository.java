package com.central.main.repository;


import com.central.main.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    Optional<Event> findById(Long id);

    Page<Event> findByLevel(String level, Pageable pageable);

    Page<Event> findByLog(String log, Pageable pageable);

    Page<Event> findByOrigin(String origin, Pageable pageable);

    Page<Event> findByEventDateContaining(String date, Pageable pageable);

    @Query(value = "SELECT count(*) FROM event WHERE level = :level",
            nativeQuery = true)
    Integer getByLevelCount(@Param("level") String level);
}
