# Smart Meeting Room Booking API

A Spring Boot backend service for managing meeting room bookings with JWT authentication and MongoDB Atlas.

## Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- MongoDB Atlas
- Swagger (OpenAPI)

## Features
- User Registration
- User Login with JWT
- Secure APIs
- Create Meeting Rooms
- Book Meeting Rooms
- Prevent Time Conflicts
- Cancel Bookings
- Swagger API Documentation

## API Documentation
Swagger UI:
http://localhost:8080/swagger-ui/index.html

## Authentication Flow
1. Register user
2. Login to generate JWT token
3. Click Authorize in Swagger
4. Use secured APIs

## Database
MongoDB Atlas

Collections:
- users
- rooms
- bookings
