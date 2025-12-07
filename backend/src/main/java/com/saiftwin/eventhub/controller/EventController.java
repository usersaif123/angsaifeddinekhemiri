package com.saiftwin.eventhub.controller;

import com.saiftwin.eventhub.dto.ExpensiveEventDTO;
import com.saiftwin.eventhub.model.Event;
import com.saiftwin.eventhub.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@Tag(name = "Events", description = "Event management APIs")
public class EventController {

    private final EventService eventService;

    @GetMapping
    @Operation(summary = "Get all events", description = "Retrieve a list of all events")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get event by ID", description = "Retrieve a specific event by its ID")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/expensive")
    @Operation(summary = "Get expensive events", description = "Get events with price > $50 with 20% markup")
    public ResponseEntity<List<ExpensiveEventDTO>> getExpensiveEvents() {
        return ResponseEntity.ok(eventService.getExpensiveEvents());
    }

    @GetMapping("/organizer/{organizerId}")
    @Operation(summary = "Get events by organizer", description = "Retrieve all events for a specific organizer")
    public ResponseEntity<List<Event>> getEventsByOrganizer(@PathVariable Long organizerId) {
        return ResponseEntity.ok(eventService.getEventsByOrganizer(organizerId));
    }

    @GetMapping("/upcoming")
    @Operation(summary = "Get upcoming events", description = "Retrieve all future events")
    public ResponseEntity<List<Event>> getUpcomingEvents() {
        return ResponseEntity.ok(eventService.getUpcomingEvents());
    }

    @GetMapping("/search/title")
    @Operation(summary = "Search events by title", description = "Search events by title (case-insensitive)")
    public ResponseEntity<List<Event>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(eventService.searchEventsByTitle(title));
    }

    @GetMapping("/search/place")
    @Operation(summary = "Search events by place", description = "Search events by place (case-insensitive)")
    public ResponseEntity<List<Event>> searchByPlace(@RequestParam String place) {
        return ResponseEntity.ok(eventService.searchEventsByPlace(place));
    }

    @PostMapping
    @Operation(summary = "Create new event", description = "Create a new event")
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update event", description = "Update an existing event")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long id,
            @Valid @RequestBody Event eventDetails) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete event", description = "Delete an event by ID")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/like")
    @Operation(summary = "Like event", description = "Increment the like count for an event")
    public ResponseEntity<Event> likeEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.incrementLikes(id));
    }

    @PostMapping("/{id}/register")
    @Operation(summary = "Register for event", description = "Register for an event (decrements available places)")
    public ResponseEntity<Event> registerForEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.decrementPlaces(id));
    }
}
