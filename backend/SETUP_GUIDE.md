# Quick Setup Guide - Running the Spring Boot Backend

## Current Status
❌ Java is not installed on your system  
❌ Maven is not installed on your system  

## Option 1: Quick Install with Chocolatey (Recommended - 5 minutes)

If you have Chocolatey installed, run these commands in PowerShell (as Administrator):

```powershell
# Install Java 17
choco install openjdk17 -y

# Install Maven
choco install maven -y

# Refresh environment variables
refreshenv

# Verify installations
java -version
mvn -version
```

## Option 2: Manual Installation (15 minutes)

### Step 1: Install Java 17

1. **Download Java 17**:
   - Go to: https://adoptium.net/temurin/releases/
   - Select: Version 17 (LTS), Windows, x64
   - Download the `.msi` installer

2. **Install Java**:
   - Run the downloaded `.msi` file
   - Follow the installation wizard
   - ✅ Check "Add to PATH" option
   - Complete installation

3. **Verify Java**:
   ```powershell
   java -version
   ```
   Should show: `openjdk version "17.x.x"`

### Step 2: Install Maven

1. **Download Maven**:
   - Go to: https://maven.apache.org/download.cgi
   - Download: `apache-maven-3.9.x-bin.zip`

2. **Extract Maven**:
   - Extract to: `C:\Program Files\Maven`
   - Final path should be: `C:\Program Files\Maven\apache-maven-3.9.x`

3. **Add Maven to PATH**:
   - Open: System Properties → Environment Variables
   - Under "System variables", find "Path"
   - Click "Edit" → "New"
   - Add: `C:\Program Files\Maven\apache-maven-3.9.x\bin`
   - Click "OK" on all dialogs

4. **Verify Maven** (open NEW PowerShell window):
   ```powershell
   mvn -version
   ```
   Should show Maven version info

## Step 3: Run the Backend

Once Java and Maven are installed:

```powershell
# Navigate to backend directory
cd c:\Users\Admin\Desktop\4twin\angular\saiftwinEventHub\backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

## Step 4: Verify It's Running

Once started, you should see:
```
========================================
EventHub Backend is running!
API: http://localhost:3000/events
Swagger UI: http://localhost:3000/swagger-ui.html
H2 Console: http://localhost:3000/h2-console
========================================
```

## Step 5: Test the API

Open a new PowerShell window and test:

```powershell
# Get all events
Invoke-RestMethod -Uri http://localhost:3000/events -Method GET

# Get expensive events
Invoke-RestMethod -Uri http://localhost:3000/events/expensive -Method GET
```

Or open in browser:
- **Swagger UI**: http://localhost:3000/swagger-ui.html
- **Get Events**: http://localhost:3000/events

## Alternative: Use Spring Boot Maven Wrapper (No Maven Install Needed)

If you only want to install Java (not Maven), I can create a Maven wrapper for you that will download Maven automatically.

---

## Need Help?

If you encounter any issues during installation, let me know and I'll help troubleshoot!
