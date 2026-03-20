# 🇮🇳 DeshDarshan — Incredible India Travel Website

A full-stack travel web application that lets users explore destinations across India, find hotels, plan trips, and make bookings.

**Live Site:** [rynix27.github.io/desh-darshan3](https://rynix27.github.io/desh-darshan3)

---

## Features

- **Destinations** — Browse 22 destinations across India with maps
- **Accommodation** — Find and filter hotels by category and price
- **Culture** — Explore festivals, dances, cuisine, and crafts
- **Trip Planner** — Calculate trip cost and build your itinerary
- **Travel Tips** — Useful tips and external resources
- **Contact** — Send messages to the team

---

## Tech Stack

| Layer     | Technology                        |
|-----------|-----------------------------------|
| Frontend  | HTML5, CSS3, JavaScript           |
| Backend   | Java 17 + Spring Boot 3.2         |
| Database  | MySQL 8.0                         |
| ORM       | Spring Data JPA / Hibernate       |
| Security  | Spring Security                   |

---

## Project Structure

```
DeshDarshan_Final/
├── frontend/
│   ├── index.html           # Home page
│   ├── destinations.html    # 22 destinations with map
│   ├── accommodation.html   # Hotels with filters
│   ├── culture.html         # Festivals, food, crafts
│   ├── trip-planner.html    # Cost calculator & itinerary
│   └── travel-tips.html     # Tips and links
│
└── backend/
    ├── pom.xml              # Maven dependencies
    ├── database.sql         # MySQL setup script
    └── src/main/java/com/deshdarshan/
        ├── model/           # Destination, Hotel, Booking, User, ContactMessage
        ├── repository/      # JPA repositories
        ├── service/         # Business logic
        └── controller/      # REST API endpoints
```

---

## Running Locally

### Prerequisites
- Java 17 → [adoptium.net](https://adoptium.net)
- Maven 3.8+ → [maven.apache.org](https://maven.apache.org)
- MySQL 8.0 → [dev.mysql.com](https://dev.mysql.com/downloads)

### Steps

**1. Clone the repo**
```bash
git clone https://github.com/rynix27/desh-darshan3.git
cd desh-darshan3
```

**2. Setup the database**
```bash
mysql -u root -p < backend/database.sql
```

**3. Update DB password**

Edit `backend/src/main/resources/application.properties`:
```
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

**4. Run the backend**
```bash
cd backend
mvn spring-boot:run
```
Backend starts at → `http://localhost:8080`

**5. Open the frontend**

Just open `frontend/index.html` in your browser!

---

## API Endpoints

### Destinations
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/destinations` | Get all destinations |
| GET | `/api/destinations/{id}` | Get by ID |
| GET | `/api/destinations/region/{region}` | Filter by region |
| GET | `/api/destinations/search?name=Kerala` | Search by name |
| POST | `/api/destinations` | Add destination |
| PUT | `/api/destinations/{id}` | Update destination |
| DELETE | `/api/destinations/{id}` | Delete destination |

### Hotels
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/hotels` | Get all hotels |
| GET | `/api/hotels/featured` | Get featured hotels |
| GET | `/api/hotels/filter?maxPrice=5000&category=mid` | Filter by price & type |
| POST | `/api/hotels` | Add hotel |

### Bookings
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/bookings` | Create booking |
| GET | `/api/bookings/email/{email}` | Get bookings by email |
| PUT | `/api/bookings/{id}/cancel` | Cancel booking |

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/users/register` | Register |
| POST | `/api/users/login` | Login |

---
Made by [@rynix27](https://github.com/rynix27)
