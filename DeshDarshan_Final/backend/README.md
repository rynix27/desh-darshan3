# DeshDarshan - Backend Setup Guide

## Tech Stack
- **Frontend** : HTML, CSS, JavaScript
- **Backend**  : Java 17 + Spring Boot 3.2
- **Database** : MySQL 8.0

---

## Step 1 — Install Requirements

Make sure you have installed:
- Java 17 (https://adoptium.net)
- Maven 3.8+ (https://maven.apache.org)
- MySQL 8.0 (https://dev.mysql.com/downloads)

Check versions:
```
java -version
mvn -version
mysql --version
```

---

## Step 2 — Setup MySQL Database

Open MySQL and run the database script:
```
mysql -u root -p < database.sql
```

Or open MySQL Workbench and run the file `database.sql` manually.

---

## Step 3 — Configure Database Password

Open this file:
```
src/main/resources/application.properties
```

Change this line to your MySQL password:
```
spring.datasource.password=your_mysql_password
```

---

## Step 4 — Run the Backend

```
mvn spring-boot:run
```

The server starts at: **http://localhost:8080**

---

## API Endpoints

### Destinations
| Method | URL                                      | Description              |
|--------|------------------------------------------|--------------------------|
| GET    | /api/destinations                        | Get all destinations     |
| GET    | /api/destinations/{id}                   | Get destination by ID    |
| GET    | /api/destinations/region/{region}        | Filter by region         |
| GET    | /api/destinations/search?name=Kerala     | Search by name           |
| POST   | /api/destinations                        | Add new destination      |
| PUT    | /api/destinations/{id}                   | Update destination       |
| DELETE | /api/destinations/{id}                   | Delete destination       |

### Hotels
| Method | URL                                      | Description              |
|--------|------------------------------------------|--------------------------|
| GET    | /api/hotels                              | Get all hotels           |
| GET    | /api/hotels/{id}                         | Get hotel by ID          |
| GET    | /api/hotels/category/{category}          | Filter by category       |
| GET    | /api/hotels/destination/{name}           | Hotels in a destination  |
| GET    | /api/hotels/filter?maxPrice=5000&category=mid | Filter by price + type |
| GET    | /api/hotels/featured                     | Get featured hotels      |
| POST   | /api/hotels                              | Add new hotel            |
| PUT    | /api/hotels/{id}                         | Update hotel             |
| DELETE | /api/hotels/{id}                         | Delete hotel             |

### Bookings
| Method | URL                                      | Description              |
|--------|------------------------------------------|--------------------------|
| POST   | /api/bookings                            | Create a booking         |
| GET    | /api/bookings                            | Get all bookings         |
| GET    | /api/bookings/{id}                       | Get booking by ID        |
| GET    | /api/bookings/email/{email}              | Bookings by email        |
| GET    | /api/bookings/status/PENDING             | Bookings by status       |
| PUT    | /api/bookings/{id}/status                | Update status            |
| PUT    | /api/bookings/{id}/cancel                | Cancel booking           |

### Users
| Method | URL                                      | Description              |
|--------|------------------------------------------|--------------------------|
| POST   | /api/users/register                      | Register new user        |
| POST   | /api/users/login                         | Login                    |
| GET    | /api/users                               | Get all users            |
| GET    | /api/users/{id}                          | Get user by ID           |
| DELETE | /api/users/{id}                          | Delete user              |

### Contact
| Method | URL                                      | Description              |
|--------|------------------------------------------|--------------------------|
| POST   | /api/contact                             | Send contact message     |
| GET    | /api/contact                             | Get all messages         |
| GET    | /api/contact/new                         | Get unread messages      |
| PUT    | /api/contact/{id}/read                   | Mark as read             |

---

## Sample API Requests

### Register a User
```
POST http://localhost:8080/api/users/register
Content-Type: application/json

{
  "fullName": "Raj Kumar",
  "email": "raj@email.com",
  "password": "pass123",
  "phone": "9876543210"
}
```

### Create a Booking
```
POST http://localhost:8080/api/bookings
Content-Type: application/json

{
  "guestName": "Priya Singh",
  "email": "priya@email.com",
  "bookingType": "hotel",
  "itemName": "Taj Lake Palace Udaipur",
  "checkIn": "2026-12-01",
  "checkOut": "2026-12-04",
  "numberOfGuests": 2,
  "totalAmount": 96000
}
```

### Filter Hotels
```
GET http://localhost:8080/api/hotels/filter?maxPrice=10000&category=mid
```

---

## Project Folder Structure

```
backend/
  pom.xml                          <- Maven dependencies
  database.sql                     <- MySQL setup script
  README.md                        <- This file
  src/
    main/
      java/com/deshdarshan/
        DeshDarshanApplication.java  <- Main entry point
        model/
          Destination.java
          Hotel.java
          Booking.java
          User.java
          ContactMessage.java
        repository/
          DestinationRepository.java
          HotelRepository.java
          BookingRepository.java
          UserRepository.java
          ContactMessageRepository.java
        service/
          DestinationService.java
          HotelService.java
          BookingService.java
          UserService.java
          ContactMessageService.java
        controller/
          DestinationController.java
          HotelController.java
          BookingController.java
          UserController.java
          ContactController.java
          SecurityConfig.java
      resources/
        application.properties       <- Database config
```
