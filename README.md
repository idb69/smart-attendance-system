# ☁️ Smart Attendance System on Cloud

A cloud-based Smart Attendance Management System designed to automate and simplify the attendance process. The system provides secure user authentication, digital attendance tracking, dashboard management, and attendance reporting.

This project was developed as part of the **2-Month Cloud Computing Internship Industrial Project**.

---

## 📌 Project Objective

The objective of this project is to automate attendance management digitally using cloud technologies. The system reduces manual work and provides a secure and efficient way to record, manage, and monitor attendance.

---

## ✨ Features

### 🔐 Secure Authentication

* User login and authentication
* Secure access to the system
* Role-based access control

### 👤 User Management

* Manage users and student records
* User dashboard
* Profile management

### 📅 Attendance Management

* Digital attendance tracking
* QR-based attendance support
* Automatic attendance recording
* Attendance history

### 📊 Dashboard

* User-friendly dashboard
* Attendance statistics
* Present and absent records
* Easy monitoring of attendance data

### 📄 Report Generation

* Attendance reports
* Historical attendance records
* Attendance summary

### ☁️ Cloud Ready

* Cloud database integration
* Cloud deployment support
* Scalable application architecture

---

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Spring Security**
* **MySQL**
* **HTML**
* **CSS**
* **JavaScript**
* **Maven**
* **Git & GitHub**
* **Cloud Deployment**

---

## 🏗️ Project Architecture

```text
                ┌─────────────────┐
                │      User       │
                │ Admin / Student │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │   Web Interface │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │  Spring Boot    │
                │    Backend      │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │ Cloud Database  │
                │      MySQL      │
                └─────────────────┘
```

---

## 📂 Project Structure

```text
smart-attendance-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── attendance/
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## 🚀 How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/idb69/smart-attendance-system.git
```

### 2️⃣ Open the Project

```bash
cd smart-attendance-system
```

### 3️⃣ Configure Database

Open:

```text
src/main/resources/application.properties
```

Configure your MySQL database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/attendance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4️⃣ Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class directly from your IDE.

### 5️⃣ Open in Browser

```text
http://localhost:8080
```

---

## ☁️ Cloud Computing Concepts Used

This project demonstrates important cloud computing concepts:

* ☁️ Cloud-hosted application architecture
* 🗄️ Cloud database integration
* 🔐 Secure authentication
* 📈 Scalable application design
* 🌐 Web-based access
* 💾 Centralized data management

---

## 🎯 Internship Requirements Covered

| Requirement                 | Status |
| --------------------------- | ------ |
| Face or QR-based Attendance | ✅      |
| Cloud Database              | ✅      |
| User Dashboard              | ✅      |
| Report Generation           | ✅      |
| Secure Authentication       | ✅      |

---

## 🔒 Security Features

* Secure user authentication
* Protected application access
* Role-based authorization
* Secure database connectivity

---

## 📈 Future Improvements

* Face Recognition Attendance
* Email Notifications
* SMS Alerts
* Cloud Deployment on AWS
* Docker Containerization
* Mobile Application
* Advanced Analytics Dashboard
* Export Reports to PDF and Excel

---

## 🎓 Internship Project

This project was developed for:

### **2-Month Cloud Computing Internship**

**Industrial Project: Smart Attendance System on Cloud**

The project fulfills the following requirements:

* Digital attendance management
* QR/Face-based attendance capability
* Cloud database integration
* User dashboard
* Report generation
* Secure authentication

---

## 👨‍💻 Author

**Babul Kumar**

GitHub: https://github.com/idb69

---

## 📜 License

This project is created for educational and internship purposes.

---

### ⭐ If you like this project, please give it a Star on GitHub!
