package com.saiftwin.eventhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    @Column(nullable = false, length = 500)
    private String description;

    @NotNull(message = "Date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate date;

    @NotBlank(message = "Place is required")
    @Column(nullable = false)
    private String place;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Column(nullable = false)
    private Double price;

    @Column(name = "image_url")
    private String imageUrl;

    @NotNull(message = "Number of places is required")
    @Min(value = 0, message = "Number of places cannot be negative")
    @Column(name = "nb_places", nullable = false)
    private Integer nbPlaces;

    @Min(value = 0, message = "Number of likes cannot be negative")
    @Column(name = "nb_likes", nullable = false)
    private Integer nbLikes = 0;

    @NotNull(message = "Organizer ID is required")
    @Column(name = "organizer_id", nullable = false)
    private Long organizerId;

    @PrePersist
    protected void onCreate() {
        if (nbLikes == null) {
            nbLikes = 0;
        }
    }
}
