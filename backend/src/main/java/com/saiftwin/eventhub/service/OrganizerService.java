package com.saiftwin.eventhub.service;

import com.saiftwin.eventhub.exception.ResourceNotFoundException;
import com.saiftwin.eventhub.model.Organizer;
import com.saiftwin.eventhub.repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer", "id", id));
    }

    public Organizer getOrganizerByEmail(String email) {
        return organizerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer", "email", email));
    }

    @Transactional
    public Organizer createOrganizer(Organizer organizer) {
        // Check if email already exists
        if (organizerRepository.existsByEmail(organizer.getEmail())) {
            throw new IllegalArgumentException("Organizer with email " + organizer.getEmail() + " already exists");
        }
        return organizerRepository.save(organizer);
    }

    @Transactional
    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Organizer organizer = getOrganizerById(id);
        
        if (organizerDetails.getName() != null) {
            organizer.setName(organizerDetails.getName());
        }
        if (organizerDetails.getEmail() != null) {
            // Check if new email is already taken by another organizer
            if (!organizer.getEmail().equals(organizerDetails.getEmail()) 
                    && organizerRepository.existsByEmail(organizerDetails.getEmail())) {
                throw new IllegalArgumentException("Email already in use");
            }
            organizer.setEmail(organizerDetails.getEmail());
        }
        if (organizerDetails.getPhone() != null) {
            organizer.setPhone(organizerDetails.getPhone());
        }
        
        return organizerRepository.save(organizer);
    }

    @Transactional
    public void deleteOrganizer(Long id) {
        Organizer organizer = getOrganizerById(id);
        organizerRepository.delete(organizer);
    }
}
