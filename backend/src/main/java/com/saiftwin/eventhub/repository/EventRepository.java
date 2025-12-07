package com.saiftwin.eventhub.repository;

import com.saiftwin.eventhub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    List<Event> findByPriceGreaterThan(Double price);
    
    List<Event> findByOrganizerId(Long organizerId);
    
    List<Event> findByDateAfter(LocalDate date);
    
    List<Event> findByDateBefore(LocalDate date);
    
    List<Event> findByPlaceContainingIgnoreCase(String place);
    
    List<Event> findByTitleContainingIgnoreCase(String title);
}
