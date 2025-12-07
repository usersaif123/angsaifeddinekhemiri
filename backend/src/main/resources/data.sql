-- Insert Organizers
INSERT INTO organizers (id, name, email, phone) VALUES 
(1, 'Tech Events Tunisia', 'contact@techevents.tn', '21612345678'),
(2, 'Innovation Hub', 'info@innovationhub.tn', '21698765432');

-- Insert Events
INSERT INTO events (id, title, description, date, place, price, image_url, nb_places, nb_likes, organizer_id) VALUES 
(1, 'Angular Summit', 'Conférence sur Angular et l''écosystème front-end', '2026-11-10', 'Tunis', 50.0, 'images/event1.PNG', 25, 0, 1),
(2, 'Web Dev Days', 'Journée dédiée aux frameworks web modernes.', '2026-01-05', 'Ariana', 30.0, 'images/event2.PNG', 50, 0, 1),
(3, 'Spring Boot Workshop', 'Atelier pratique sur Spring Boot et microservices', '2026-02-15', 'Sousse', 75.0, 'images/event3.PNG', 50, 5, 2),
(4, 'DevOps Conference', 'Conférence sur les pratiques DevOps et CI/CD', '2026-03-20', 'Sfax', 60.0, 'images/event4.PNG', 100, 12, 2),
(5, 'React Meetup', 'Rencontre mensuelle des développeurs React', '2026-01-25', 'Tunis', 0.0, 'images/event5.PNG', 30, 8, 1);
