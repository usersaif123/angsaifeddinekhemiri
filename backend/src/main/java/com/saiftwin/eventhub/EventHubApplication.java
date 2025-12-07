package com.saiftwin.eventhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventHubApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("EventHub Backend is running!");
        System.out.println("API: http://localhost:3000/events");
        System.out.println("Swagger UI: http://localhost:3000/swagger-ui.html");
        System.out.println("H2 Console: http://localhost:3000/h2-console");
        System.out.println("========================================\n");
    }
}
