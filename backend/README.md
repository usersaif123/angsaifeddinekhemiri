# EventHub Backend

A comprehensive Spring Boot REST API for event management, providing full CRUD operations for events and organizers.

## 🚀 Features

- **Event Management**: Create, read, update, and delete events
- **Organizer Management**: Manage event organizers
- **Advanced Queries**: Search events by title, place, organizer, and date
- **Expensive Events**: Get events over $50 with 20% markup calculation
- **Like System**: Increment event likes
- **Registration**: Track available places and registrations
- **Validation**: Comprehensive input validation
- **Error Handling**: Standardized error responses
- **CORS Support**: Configured for Angular frontend
- **API Documentation**: Interactive Swagger UI
- **H2 Database**: In-memory database with console access

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+

## 🛠️ Installation & Setup

1. **Navigate to backend directory**:
   ```bash
   cd c:\Users\Admin\Desktop\4twin\angular\saiftwinEventHub\backend
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

The application will start on **http://localhost:3000**

## 📚 API Endpoints

### Events API (`/events`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/events` | Get all events |
| GET | `/events/{id}` | Get event by ID |
| GET | `/events/expensive` | Get expensive events (price > $50) with 20% markup |
| GET | `/events/organizer/{organizerId}` | Get events by organizer |
| GET | `/events/upcoming` | Get upcoming events |
| GET | `/events/search/title?title={title}` | Search events by title |
| GET | `/events/search/place?place={place}` | Search events by place |
| POST | `/events` | Create new event |
| PUT | `/events/{id}` | Update event |
| DELETE | `/events/{id}` | Delete event |
| POST | `/events/{id}/like` | Increment event likes |
| POST | `/events/{id}/register` | Register for event (decrement places) |

### Organizers API (`/organizers`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/organizers` | Get all organizers |
| GET | `/organizers/{id}` | Get organizer by ID |
| GET | `/organizers/email/{email}` | Get organizer by email |
| POST | `/organizers` | Create new organizer |
| PUT | `/organizers/{id}` | Update organizer |
| DELETE | `/organizers/{id}` | Delete organizer |

## 🔍 Testing the API

### Using PowerShell

```powershell
# Get all events
Invoke-RestMethod -Uri http://localhost:3000/events -Method GET

# Get expensive events
Invoke-RestMethod -Uri http://localhost:3000/events/expensive -Method GET

# Create a new event
$event = @{
    title = "New Tech Conference"
    description = "A conference about new technologies"
    date = "2025-06-15"
    place = "Tunis"
    price = 45.0
    imageUrl = "images/event.png"
    nbPlaces = 100
    organizerId = 1
} | ConvertTo-Json

Invoke-RestMethod -Uri http://localhost:3000/events -Method POST -Body $event -ContentType "application/json"
```

### Using Swagger UI

Navigate to **http://localhost:3000/swagger-ui.html** for interactive API documentation and testing.

## 🗄️ Database Access

Access the H2 database console at **http://localhost:3000/h2-console**

**Connection Details**:
- JDBC URL: `jdbc:h2:mem:eventhubdb`
- Username: `sa`
- Password: *(leave empty)*

## 🏗️ Project Structure

```
backend/
├── src/main/java/com/twin7/eventhub/
│   ├── EventHubApplication.java          # Main application class
│   ├── config/
│   │   ├── CorsConfig.java               # CORS configuration
│   │   └── OpenApiConfig.java            # Swagger configuration
│   ├── controller/
│   │   ├── EventController.java          # Event REST endpoints
│   │   └── OrganizerController.java      # Organizer REST endpoints
│   ├── dto/
│   │   ├── ErrorResponse.java            # Error response DTO
│   │   └── ExpensiveEventDTO.java        # Expensive event DTO
│   ├── exception/
│   │   ├── GlobalExceptionHandler.java   # Global exception handling
│   │   └── ResourceNotFoundException.java # Custom exception
│   ├── model/
│   │   ├── Event.java                    # Event entity
│   │   └── Organizer.java                # Organizer entity
│   ├── repository/
│   │   ├── EventRepository.java          # Event data access
│   │   └── OrganizerRepository.java      # Organizer data access
│   └── service/
│       ├── EventService.java             # Event business logic
│       └── OrganizerService.java         # Organizer business logic
├── src/main/resources/
│   ├── application.properties            # Application configuration
│   └── data.sql                          # Initial data
└── pom.xml                               # Maven dependencies
```

## 🔧 Configuration

Edit `src/main/resources/application.properties` to customize:
- Server port (default: 3000)
- Database settings
- Logging levels
- CORS origins

## 🧪 Sample Data

The application comes with pre-loaded sample data:
- 2 Organizers
- 5 Events (including the ones from your Angular frontend)

## 🌐 Frontend Integration

The backend is configured to work with your Angular frontend running on `http://localhost:4200`.

Make sure both applications are running:
1. Start the backend: `mvn spring-boot:run` (port 3000)
2. Start the frontend: `ng serve` (port 4200)

## 📝 Event Model

```json
{
  "id": 1,
  "title": "Angular Summit",
  "description": "Conférence sur Angular et l'écosystème front-end",
  "date": "2025-11-10",
  "place": "Tunis",
  "price": 50.0,
  "imageUrl": "images/event1.PNG",
  "nbPlaces": 25,
  "nbLikes": 0,
  "organizerId": 1
}
```

## 🛡️ Validation

All endpoints include comprehensive validation:
- Required fields
- String length constraints
- Email format validation
- Future date validation for events
- Positive price validation
- Non-negative values for places and likes

## ⚠️ Error Handling

The API returns standardized error responses:

```json
{
  "timestamp": "2025-12-05T18:50:00",
  "status": 404,
  "error": "Not Found",
  "message": "Event not found with id : '999'",
  "path": "/events/999"
}
```

## 📄 License

Apache 2.0

## 👥 Author

Twin7 EventHub Team
