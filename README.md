Finance Service - Spring Boot Microservices:
A Finance Domain Microservices Application built using Spring Boot & Spring Cloud, implementing real-world backend architecture with clean design principles.

Architecture:
Eureka Server → Service Discovery
API Gateway → Centralized Routing
User Service → User Management
Wallet Service → Wallet Operations
Transaction Service → Money Transfer

Tech Stack:
Java 17
Spring Boot
Spring Cloud
Eureka Server
Spring Cloud Gateway
OpenFeign
MySQL
Maven

Features:
Microservices Architecture
API Gateway Routing
Service Discovery using Eureka
Inter-service Communication (Feign Client)
Wallet Credit/Debit System
Transaction Processing
Global Exception Handling
Standard API Response Structure

How to Run:
Start Eureka Server
Start User Service
Start Wallet Service
Start Transaction Service
Start API Gateway

Project Versions:
  Demo-Finance-Working-Project:
    Basic working microservices implementation
  
  Finance-Microservice-Standard-API:
    Global Exception Handling
    Standard API Response
    Improved error handling
    Cleaner architecture

  Finance-Microservice-DTO-Architecture:
    DTO Layer Implementation
    Mapper Pattern
    Secure API responses (no entity exposure)
    Better separation of concerns

  Finance-Microservice-JWT-Login:
    Implemented login API for user authentication
    Generated JWT token upon successful login
    Token contains user identity (email)
    Used for securing microservices in next phase

API Gateway:
  Base URL:
    http://localhost:8080

API Endpoints:
  User Service:
    POST - http://localhost:8080/api/users/register
    GET - http://localhost:8080/api/users/{id}

  Wallet Service:
    POST - http://localhost:8080/api/wallet/create/{userId}
    GET - http://localhost:8080/api/wallet/{userId}
    POST - http://localhost:8080/api/wallet/credit/{userId}/{amount}
    POST - http://localhost:8080/api/wallet/debit/{userId}/{amount}

  Transaction Service:
    POST - http://localhost:8080/api/transactions/send?senderId={id}&receiverId={id}&amount={amount}
    GET - http://localhost:8080/api/transactions/sent/{userId}
    GET - http://localhost:8080/api/transactions/received/{userId}

Request & Response:
  User Registration:
    Request:
      { "name": "User", "email": "user@gmail.com", "password": "1234", "phone": "9876543210" }
    Response:
      { "status": "SUCCESS", "message": "User registered successfully", "data": { "userId": 1, "name": "User", "email": "user@gmail.com" } }

Future Enhancements:
JWT Authentication
Circuit Breaker (Resilience4j)
Config Server
Distributed Tracing (Zipkin)

Author:
Ashwini Mistry

Notes:
  This project demonstrates:
    Real-world microservices architecture
    Clean code practices
    Scalable backend design