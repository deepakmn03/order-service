# Order Process Service

A minimal Spring Boot microservice for managing users and their orders.

## Features
- **User Management**: Register, list, and delete users.
- **Order Management**: Create, update, retrieve, and delete orders.
- **Database Integration**: PostgreSQL with JPA/Hibernate.
- **Health Check**: Actuator-based monitoring and custom status endpoint.

## Prerequisites
- Java 21
- Maven 3.x
- PostgreSQL

## Setup
1. **Database**: Create a PostgreSQL database named `order-service`.
2. **Configuration**: Update `src/main/resources/application.yaml` with your PostgreSQL credentials if different from:
   - User: `postgres`
   - Password: `postgres`
3. **Run**:
   ```bash
   ./mvnw spring-boot:run
   ```
   The service will start on `http://localhost:2330`.

## API Endpoints

### Orders (`/api/order`)
- `GET /status`: Check service status.
- `GET /get`: List all orders.
- `GET /get/{orderId}`: Get order by ID.
- `GET /get/user/{userId}`: List all orders for a specific user.
- `POST /create`: Create a new order.
- `PATCH /update/{orderId}`: Update an existing order.
- `DELETE /remove/{orderId}`: Delete an order.

### Users (`/api/user`)
- `GET /list`: List all users.
- `GET /list/{id}`: Get user by ID (including orders).
- `POST /register`: Register a new user.
- `DELETE /delete/{userId}`: Remove a user.
