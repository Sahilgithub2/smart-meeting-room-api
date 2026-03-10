# Smart Meeting Room Booking API

## Candidate Information

**Full Name:** Sahil
**Email ID:** [1rn21cs130.sahil@gmail.com](mailto:your-email@example.com)
**College Name:** RNSIT
**Selected Skill Track:** Java & API Development

---

## Project Overview

This project is a backend system built using **Java Spring Boot** that allows users to securely book meeting rooms while preventing scheduling conflicts.

The application uses **JWT authentication**, **MongoDB Atlas**, and **Swagger API documentation** to simulate a production-style backend service.

---

## Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* MongoDB Atlas
* Swagger (OpenAPI)
* Maven

---

## Features Implemented

### 1. User Authentication

* Register new users
* Login and generate JWT tokens
* Secure endpoints using Bearer Token authentication

### 2. Meeting Room Management

* Create meeting rooms with capacity
* Store room details in MongoDB

### 3. Meeting Room Booking

* Book meeting rooms
* Prevent overlapping time conflicts
* Associate bookings with authenticated users

### 4. Booking Management

* View all bookings
* Cancel existing bookings

### 5. API Documentation

Swagger UI available at:

`/swagger-ui/index.html`

This allows easy testing of all APIs.

---

## API Testing Flow

1. Register a user
2. Login to generate JWT token
3. Click **Authorize** in Swagger
4. Enter `Bearer <token>`
5. Test secured APIs

---

## Example API Calls

### Register User

POST `/auth/register`

```json
{
  "username": "rahul",
  "password": "1234"
}
```

### Login

POST `/auth/login`

```json
{
  "username": "rahul",
  "password": "1234"
}
```

### Create Room

POST `/api/rooms`

```json
{
  "roomId": "A101",
  "capacity": 6
}
```

### Book Room

POST `/api/book`

```json
{
  "roomId": "A101",
  "startTime": "10:00",
  "endTime": "11:00"
}
```

---

## Database

MongoDB Atlas

Collections:

* users
* rooms
* bookings

---

## Deployment

This project is deployed on **Replit** and can be accessed using the public link shared with the submission.
****
