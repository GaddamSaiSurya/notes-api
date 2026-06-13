# 📝 Notes API

A production-style REST API built with Spring Boot that allows users to create, manage, search, archive, and pin notes.

Designed to demonstrate backend engineering fundamentals including RESTful API design, database integration, validation, exception handling, pagination, sorting, and deployment readiness.

---

## 🚀 Features

### Core Features

* Create notes
* Retrieve all notes
* Retrieve note by ID
* Update notes
* Delete notes

### Search

* Search notes by title or content
* Case-insensitive search

### Organization

* Archive notes
* Unarchive notes
* Pin important notes
* Unpin notes

### Pagination & Sorting

* Paginated API responses
* Configurable page size
* Sort by any field
* Ascending/Descending ordering

### Validation

* Required fields validation
* Title length constraints
* Category validation

### Error Handling

* Global exception handling
* Custom exceptions
* Structured error responses

### Database

* PostgreSQL integration
* JPA/Hibernate ORM
* Automatic timestamps
* Environment variable configuration

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* PostgreSQL
* Hibernate
* Bean Validation
* Swagger/OpenAPI
* Maven
* Railway
* Neon PostgreSQL

---

## 📂 Project Structure

```text
src
├── controller
│   └── NoteController
├── service
│   └── NoteService
├── repository
│   └── NoteRepository
├── entity
│   └── Note
├── exception
│   ├── GlobalExceptionHandler
│   └── IdNotFoundException
├── dto
│   └── ErrorResponse
└── enums
    └── Category
```

---

## 📊 Database Schema

### Note

| Field     | Type          |
| --------- | ------------- |
| id        | Long          |
| title     | String        |
| content   | String        |
| category  | Enum          |
| createdAt | LocalDateTime |
| updatedAt | LocalDateTime |
| archived  | Boolean       |
| pinned    | Boolean       |

### Categories

```java
WORK
PERSONAL
STUDY
IDEAS
```

---

## 🔗 API Endpoints

### Create Note

```http
POST /notes
```

### Get All Notes

```http
GET /notes?page=0&size=5&sortBy=createdAt&direction=desc
```

### Get Note By Id

```http
GET /notes/{id}
```

### Update Note

```http
PUT /notes/{id}
```

### Delete Note

```http
DELETE /notes/{id}
```

### Search Notes

```http
GET /search?keyword=spring
```

### Archive Note

```http
PUT /{id}/archive
```

### Unarchive Note

```http
PUT /{id}/unarchive
```

### Pin Note

```http
PUT /{id}/pin
```

### Unpin Note

```http
PUT /{id}/unpin
```

### Get Archived Notes

```http
GET /archived
```

### Get Active Notes

```http
GET /active
```

---

## 🧪 Sample Request

```json
{
  "title": "Spring Boot Notes",
  "content": "Learn pagination and sorting",
  "category": "STUDY"
}
```

---

## ⚠️ Validation Rules

### Title

* Cannot be empty
* Maximum 100 characters

### Content

* Cannot be empty

### Category

* Required
* Must be one of:

  * WORK
  * PERSONAL
  * STUDY
  * IDEAS

---

## 🔥 Exception Handling

### Resource Not Found

```json
{
  "message": "Note with id:10 not found"
}
```

### Validation Error

```json
{
  "message": "Title cannot be empty"
}
```

---

## 🌐 API Documentation

Swagger UI:

```text
https://notes-api-production-859d.up.railway.app/swagger-ui/index.html
```

---

## ⚙️ Environment Variables

```properties
SPRING_DATASOURCE_URL=your_database_url
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
```

---

## 🚀 Running Locally

### Clone Repository

```bash
git clone https://github.com/GaddamSaiSurya/notes-api.git
```

### Navigate to Project

```bash
cd notes-api
```

### Run Application

```bash
mvn spring-boot:run
```

The API will start on:

```text
http://localhost:8080
```

---

## 💡 Key Backend Concepts Demonstrated

* RESTful API Design
* Layered Architecture
* CRUD Operations
* Spring Data JPA
* PostgreSQL Integration
* Bean Validation
* Global Exception Handling
* Pagination & Sorting
* Search Functionality
* Environment-based Configuration
* API Documentation with Swagger
* Cloud Deployment Ready

---

## 📈 Future Enhancements

* JWT Authentication
* User Accounts
* Role-Based Authorization
* Soft Delete
* Unit Testing
* Integration Testing
* Redis Caching
* Docker Support
* CI/CD Pipeline
* File Attachments
* Note Sharing

---

## 👨‍💻 Author

**Sai Surya**

Aspiring Backend Engineer focused on building scalable Java & Spring Boot applications.

* GitHub: https://github.com/GaddamSaiSurya
* LinkedIn: https://www.linkedin.com/in/sai-surya-gaddam-b57926277
