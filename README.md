<<<<<<< HEAD
# Smart Attendance System on Cloud

A Spring Boot based Smart Attendance System created for the Cloud Computing Internship project.

## Features
- Admin and Student role-based login
- Secure password encryption using BCrypt
- Student registration
- QR-based attendance session
- Attendance auto-recording
- Attendance history
- Admin dashboard
- Attendance reports
- MySQL database support
- Ready for cloud deployment

## Technology Stack
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven
- ZXing QR Code

## Setup

### 1. Configure MySQL
Update `src/main/resources/application.properties`:

```properties
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

The database will be created automatically because of `createDatabaseIfNotExist=true`.

### 2. Run the application
Import as an Existing Maven Project in Eclipse/STS.

Run:
`SmartAttendanceSystemApplication.java`

Open:
`http://localhost:8081`

## Default Admin Login
Email: `admin@attendance.com`
Password: `admin123`

## Cloud Deployment
For internship submission, the application can be deployed with:
- Render
- Railway
- AWS EC2
- Azure App Service

For production, use environment variables for database credentials.
=======
# Cloud-Based Online Examination System

## Features
- Role-based authentication: ADMIN and STUDENT
- Timed examination (30 minutes) with automatic submission
- Question bank CRUD for administrators
- Automatic scoring, percentage and PASS/FAIL result generation
- Result history for administrators
- Cloud-ready configuration using environment variables
- Docker support for deployment

## Demo accounts
- Admin: `admin@onlineexam.com` / `admin123`
- Student: `student@onlineexam.com` / `student123`

## Database
Create MySQL database `online_exam_db`, then configure:
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

## Run
```bash
./mvnw spring-boot:run
```
Open (https://smart-attendance-system-wc1z.onrender.com/login)

## Cloud deployment
Deploy the Docker image or Spring Boot application to Render, Railway, AWS Elastic Beanstalk, EC2, or another cloud platform. Set `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, and optionally `PORT` as environment variables.
>>>>>>> 48ea6ed1770b78fcf88e95c40290d3cda85d6173
