package com.saiftwin.eventhub.service;

import com.saiftwin.eventhub.dto.ExpensiveEventDTO;
import com.saiftwin.eventhub.exception.ResourceNotFoundException;
import com.saiftwin.eventhub.model.Event;
import com.saiftwin.eventhub.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));
    }

    public List<ExpensiveEventDTO> getExpensiveEvents() {
        return eventRepository.findByPriceGreaterThan(50.0)
                .stream()
                .map(event -> new ExpensiveEventDTO(
                        event.getTitle(),
                        event.getPrice() * 1.2  // 20% markup
                ))
                .collect(Collectors.toList());
    }

    public List<Event> getEventsByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    public List<Event> getUpcomingEvents() {
        return eventRepository.findByDateAfter(LocalDate.now());
    }

    public List<Event> searchEventsByTitle(String title) {
        return eventRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Event> searchEventsByPlace(String place) {
        return eventRepository.findByPlaceContainingIgnoreCase(place);
    }

    @Transactional
    public Event createEvent(Event event) {
        // Validate that the event date is in the future
        if (event.getDate() != null && event.getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Event date must be in the future");
        }
        
        // Initialize nbLikes if null
        if (event.getNbLikes() == null) {
            event.setNbLikes(0);
        }
        
        return eventRepository.save(event);
    }

    @Transactional
    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        
        // Update fields
        if (eventDetails.getTitle() != null) {
            event.setTitle(eventDetails.getTitle());
        }
        if (eventDetails.getDescription() != null) {
            event.setDescription(eventDetails.getDescription());
        }
        if (eventDetails.getDate() != null) {
            if (eventDetails.getDate().isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Event date must be in the future");
            }
            event.setDate(eventDetails.getDate());
        }
        if (eventDetails.getPlace() != null) {
            event.setPlace(eventDetails.getPlace());
        }
        if (eventDetails.getPrice() != null) {
            event.setPrice(eventDetails.getPrice());
        }
        if (eventDetails.getImageUrl() != null) {
            event.setImageUrl(eventDetails.getImageUrl());
        }
        if (eventDetails.getNbPlaces() != null) {
            event.setNbPlaces(eventDetails.getNbPlaces());
        }
        if (eventDetails.getOrganizerId() != null) {
            event.setOrganizerId(eventDetails.getOrganizerId());
        }
        
        return eventRepository.save(event);
    }

    @Transactional
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    @Transactional
    public Event incrementLikes(Long id) {
        Event event = getEventById(id);
        event.setNbLikes(event.getNbLikes() + 1);
        return eventRepository.save(event);
    }

    @Transactional
    public Event decrementPlaces(Long id) {
        Event event = getEventById(id);
        if (event.getNbPlaces() <= 0) {
            throw new IllegalArgumentException("No places available for this event");
        }
        event.setNbPlaces(event.getNbPlaces() - 1);
        return eventRepository.save(event);
    }
}
