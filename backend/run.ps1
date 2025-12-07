Write-Host "========================================" -ForegroundColor Cyan
Write-Host "EventHub Backend Starter" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Set environment variables
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-17.0.17.10-hotspot"
$env:Path = "$env:JAVA_HOME\bin;$env:USERPROFILE\apache-maven-3.9.6\bin;$env:Path"

# Navigate to backend directory
Set-Location -Path $PSScriptRoot

Write-Host "Verifying Java..." -ForegroundColor Yellow
java -version
Write-Host ""

Write-Host "Verifying Maven..." -ForegroundColor Yellow
mvn -version
Write-Host ""

Write-Host "Building application..." -ForegroundColor Yellow
mvn clean package -DskipTests

if ($LASTEXITCODE -ne 0) {
    Write-Host "Build failed!" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "========================================" -ForegroundColor Green
Write-Host "Starting Spring Boot Application..." -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""
Write-Host "API will be available at:" -ForegroundColor Cyan
Write-Host "  - http://localhost:3000/events" -ForegroundColor White
Write-Host "  - http://localhost:3000/swagger-ui.html" -ForegroundColor White
Write-Host "  - http://localhost:3000/h2-console" -ForegroundColor White
Write-Host ""
Write-Host "Press Ctrl+C to stop the server" -ForegroundColor Yellow
Write-Host ""

java -jar target\eventhub-1.0.0.jar
