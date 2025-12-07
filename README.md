# 🎉 EventHub - Event Management System

A full-stack event management application built with **Angular 18** and **Spring Boot 3.2**, designed to streamline event organization, ticket management, and user feedback collection.

![Angular](https://img.shields.io/badge/Angular-18.2-DD0031?style=flat&logo=angular&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-6DB33F?style=flat&logo=spring&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-5.5-3178C6?style=flat&logo=typescript&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-007396?style=flat&logo=java&logoColor=white)

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Running the Application](#-running-the-application)
- [API Documentation](#-api-documentation)
- [Development](#-development)
- [Testing](#-testing)
- [Contributing](#-contributing)

---

## ✨ Features

### Frontend (Angular)
- 🎫 **Event Management** - Browse, create, and manage events
- 🎟️ **Ticket System** - Purchase and manage event tickets
- 👥 **User Management** - User registration and profile management
- 💬 **Feedback System** - Submit and view event feedback
- 📱 **Responsive Design** - Built with Bootstrap 5 for mobile-first experience
- 🎨 **Modern UI** - Clean and intuitive user interface

### Backend (Spring Boot)
- 🔌 **RESTful API** - Well-structured REST endpoints
- 💾 **H2 Database** - In-memory database for development
- 📝 **Data Validation** - Request validation with Spring Validation
- 📚 **API Documentation** - Interactive Swagger UI
- 🔍 **Exception Handling** - Global exception handling
- 🛠️ **Developer Tools** - H2 Console for database inspection

---

## 🛠️ Tech Stack

### Frontend
| Technology | Version | Purpose |
|------------|---------|---------|
| Angular | 18.2.x | Frontend framework |
| TypeScript | 5.5.x | Programming language |
| Bootstrap | 5.3.x | UI framework |
| RxJS | 7.8.x | Reactive programming |
| Angular Router | 18.2.x | Navigation |

### Backend
| Technology | Version | Purpose |
|------------|---------|---------|
| Spring Boot | 3.2.0 | Backend framework |
| Spring Data JPA | 3.2.0 | Data persistence |
| H2 Database | Runtime | In-memory database |
| Lombok | Latest | Boilerplate reduction |
| SpringDoc OpenAPI | 2.3.0 | API documentation |
| Maven | - | Build tool |

---

## 📁 Project Structure

```
saiftwin/
├── backend/                    # Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/saiftwin/eventhub/
│   │   │   │   ├── controller/      # REST controllers
│   │   │   │   ├── model/           # Entity models
│   │   │   │   ├── repository/      # JPA repositories
│   │   │   │   ├── service/         # Business logic
│   │   │   │   ├── exception/       # Exception handlers
│   │   │   │   └── EventHubApplication.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── data.sql
│   │   └── test/                    # Unit tests
│   ├── pom.xml
│   └── README.md
│
├── src/                        # Angular frontend
│   ├── app/
│   │   ├── features/           # Feature modules
│   │   │   ├── events/         # Event management
│   │   │   ├── tickets/        # Ticket management
│   │   │   ├── users/          # User management
│   │   │   └── feedback/       # Feedback system
│   │   ├── layout/             # Layout components
│   │   ├── shared/             # Shared components
│   │   ├── data-access/        # Services & API calls
│   │   └── models/             # TypeScript interfaces
│   ├── assets/                 # Static assets
│   └── index.html
│
├── package.json
├── angular.json
└── README.md
```

---

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- **Node.js** (v18 or higher) - [Download](https://nodejs.org/)
- **npm** (v9 or higher) - Comes with Node.js
- **Java JDK** (v17 or higher) - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Maven** (v3.6 or higher) - [Download](https://maven.apache.org/download.cgi)
- **Git** - [Download](https://git-scm.com/)

Verify installations:
```bash
node --version
npm --version
java --version
mvn --version
```

---

## 🚀 Installation

### 1. Clone the Repository
```bash
git clone https://github.com/usersaif123/angsaifeddinekhemiri.git
cd angsaifeddinekhemiri
```

### 2. Install Frontend Dependencies
```bash
npm install
```

### 3. Install Backend Dependencies
```bash
cd backend
mvn clean install
cd ..
```

---

## ▶️ Running the Application

### Option 1: Run Both Servers Separately

#### Start the Backend (Terminal 1)
```bash
cd backend
mvn spring-boot:run
```
The backend will start on **http://localhost:3000**

#### Start the Frontend (Terminal 2)
```bash
npm start
# or
ng serve
```
The frontend will start on **http://localhost:4200**

### Option 2: Use Backend Scripts (Windows)

#### PowerShell
```powershell
cd backend
.\run.ps1
```

#### Command Prompt
```cmd
cd backend
run.bat
```

---

## 📚 API Documentation

Once the backend is running, access the interactive API documentation:

- **Swagger UI**: [http://localhost:3000/swagger-ui.html](http://localhost:3000/swagger-ui.html)
- **API Docs (JSON)**: [http://localhost:3000/api-docs](http://localhost:3000/api-docs)
- **H2 Console**: [http://localhost:3000/h2-console](http://localhost:3000/h2-console)
  - JDBC URL: `jdbc:h2:mem:eventhubdb`
  - Username: `sa`
  - Password: *(leave empty)*

### Main API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/events` | GET | Get all events |
| `/api/events/{id}` | GET | Get event by ID |
| `/api/events` | POST | Create new event |
| `/api/events/{id}` | PUT | Update event |
| `/api/events/{id}` | DELETE | Delete event |
| `/api/organizers` | GET | Get all organizers |

---

## 💻 Development

### Frontend Development

#### Generate New Component
```bash
ng generate component features/component-name
```

#### Generate New Service
```bash
ng generate service data-access/service-name
```

#### Build for Production
```bash
ng build
```
Build artifacts will be stored in the `dist/` directory.

#### Watch Mode
```bash
ng build --watch --configuration development
```

### Backend Development

#### Run with Hot Reload
```bash
cd backend
mvn spring-boot:run
```

#### Build JAR
```bash
cd backend
mvn clean package
```

#### Run JAR
```bash
java -jar target/eventhub-1.0.0.jar
```

---

## 🧪 Testing

### Frontend Tests

#### Run Unit Tests
```bash
ng test
```
Tests will execute via [Karma](https://karma-runner.github.io).

#### Run Tests with Coverage
```bash
ng test --code-coverage
```

#### Run End-to-End Tests
```bash
ng e2e
```
*Note: You need to add an e2e testing package first.*

### Backend Tests

#### Run All Tests
```bash
cd backend
mvn test
```

#### Run Specific Test
```bash
mvn test -Dtest=EventControllerTest
```

---

## 🔧 Configuration

### Frontend Configuration
Edit `src/environments/environment.ts` for development settings:
```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:3000/api'
};
```

### Backend Configuration
Edit `backend/src/main/resources/application.properties`:
```properties
# Server port
server.port=3000

# Database configuration
spring.datasource.url=jdbc:h2:mem:eventhubdb
spring.datasource.username=sa
spring.datasource.password=

# Enable H2 Console
spring.h2.console.enabled=true
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📝 License

This project is part of an academic assignment for 4TWIN.

---

## 👨‍💻 Author

**Saif Eddine Khemiri**

- GitHub: [@usersaif123](https://github.com/usersaif123)

---

## 🙏 Acknowledgments

- Angular Team for the amazing framework
- Spring Boot Team for the robust backend framework
- Bootstrap Team for the UI components

---

## 📞 Support

For support, please open an issue in the GitHub repository or contact the development team.

---

**Happy Coding! 🚀**
