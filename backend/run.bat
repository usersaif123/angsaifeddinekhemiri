@echo off
echo ========================================
echo Starting EventHub Backend...
echo ========================================
echo.

REM Set JAVA_HOME
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.17.10-hotspot"

REM Add Java and Maven to PATH
set "PATH=%JAVA_HOME%\bin;%USERPROFILE%\apache-maven-3.9.6\bin;%PATH%"

cd /d "%~dp0"

echo Verifying Java installation...
java -version
echo.

echo Verifying Maven installation...
mvn -version
echo.

echo Building the application...
call mvn clean package -DskipTests

if %ERRORLEVEL% NEQ 0 (
    echo Build failed!
    pause
    exit /b 1
)

echo.
echo ========================================
echo Starting Spring Boot application...
echo ========================================
echo.
java -jar target\eventhub-1.0.0.jar

pause

