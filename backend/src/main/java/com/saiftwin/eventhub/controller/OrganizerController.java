package com.saiftwin.eventhub.controller;

import com.saiftwin.eventhub.model.Organizer;
import com.saiftwin.eventhub.service.OrganizerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizers")
@RequiredArgsConstructor
@Tag(name = "Organizers", description = "Organizer management APIs")
public class OrganizerController {

    private final OrganizerService organizerService;

    @GetMapping
    @Operation(summary = "Get all organizers", description = "Retrieve a list of all organizers")
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get organizer by ID", description = "Retrieve a specific organizer by ID")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        return ResponseEntity.ok(organizerService.getOrganizerById(id));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get organizer by email", description = "Retrieve an organizer by email address")
    public ResponseEntity<Organizer> getOrganizerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(organizerService.getOrganizerByEmail(email));
    }

    @PostMapping
    @Operation(summary = "Create organizer", description = "Create a new organizer")
    public ResponseEntity<Organizer> createOrganizer(@Valid @RequestBody Organizer organizer) {
        Organizer createdOrganizer = organizerService.createOrganizer(organizer);
        return new ResponseEntity<>(createdOrganizer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update organizer", description = "Update an existing organizer")
    public ResponseEntity<Organizer> updateOrganizer(
            @PathVariable Long id,
            @Valid @RequestBody Organizer organizerDetails) {
        return ResponseEntity.ok(organizerService.updateOrganizer(id, organizerDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete organizer", description = "Delete an organizer by ID")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return ResponseEntity.noContent().build();
    }
}
