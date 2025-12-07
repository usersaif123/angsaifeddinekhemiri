# EventHub Backend - Quick Start Guide

## ✅ Installation Complete!

Java 17 and Maven 3.9.6 have been successfully installed on your system.

## 🚀 Running the Backend

### Option 1: Using the Batch File (Easiest)

Simply double-click `run.bat` in the backend folder, or run from PowerShell:

```powershell
cd c:\Users\Admin\Desktop\4twin\angular\saiftwinEventHub\backend
.\run.bat
```

### Option 2: Manual Commands

Open PowerShell and run:

```powershell
cd c:\Users\Admin\Desktop\4twin\angular\saiftwinEventHub\backend

# Set environment variables
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-17.0.17.10-hotspot"
$env:Path = "$env:JAVA_HOME\bin;$env:USERPROFILE\apache-maven-3.9.6\bin;$env:Path"

# Build and run
mvn clean package -DskipTests
java -jar target\eventhub-1.0.0.jar
```

## 🌐 Access the Backend

Once running, access:

- **API Endpoints**: http://localhost:3000/events
- **Swagger UI**: http://localhost:3000/swagger-ui.html
- **H2 Console**: http://localhost:3000/h2-console

## 🧪 Test the API

Open a new PowerShell window and test:

```powershell
# Get all events
Invoke-RestMethod -Uri http://localhost:3000/events -Method GET

# Get expensive events
Invoke-RestMethod -Uri http://localhost:3000/events/expensive -Method GET

# Create a new event
$event = @{
    title = "Test Event"
    description = "This is a test event"
    date = "2026-12-31"
    place = "Tunis"
    price = 25.0
    imageUrl = "test.png"
    nbPlaces = 50
    organizerId = 1
} | ConvertTo-Json

Invoke-RestMethod -Uri http://localhost:3000/events -Method POST `
    -Body $event -ContentType "application/json"
```

## 📝 Notes

- The backend runs on port 3000
- Sample data includes 5 events and 2 organizers
- All dates are set to 2026 to pass validation
- CORS is configured for Angular frontend on port 4200

## ❓ Troubleshooting

If you encounter issues:

1. Make sure no other application is using port 3000
2. Check that Java and Maven are in your PATH
3. Verify JAVA_HOME is set correctly
4. Try rebuilding: `mvn clean install`

## 🔗 Integration with Angular

Your Angular frontend is already configured to use this backend:
- Frontend URL: http://localhost:4200
- Backend URL: http://localhost:3000/events

Just start both applications and they will work together!
