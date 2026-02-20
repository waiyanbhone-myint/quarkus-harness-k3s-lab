# Quarkus Inventory API

A cloud-native RESTful API for managing digital inventory, built with Quarkus and designed for a modern CI/CD pipeline.

---

## About the Project

This project provides a lightweight inventory management API with full CRUD operations for a **Product** entity (`id`, `name`, `price`, `quantity`). It demonstrates how to build, test, and deploy a modern Java microservice using Quarkus — from local development all the way to a production-ready Kubernetes environment.

---

## Tech Stack

| Layer         | Technology                        |
|---------------|-----------------------------------|
| Language      | Java 21                           |
| Framework     | Quarkus (REST Reactive)           |
| ORM           | Hibernate ORM with Panache        |
| Database      | PostgreSQL                        |
| Serialization | Jackson (JSON)                    |
| Build Tool    | Maven (via `./mvnw` wrapper)      |
| Container     | Docker                            |
| Orchestration | K3s (lightweight Kubernetes)      |
| CI/CD         | Harness                           |

---

## How to Run

### Prerequisites

- Java 21+
- Maven 3.9+ (or use the included `./mvnw` wrapper)
- A running PostgreSQL instance (or use Quarkus Dev Services to auto-start one)

### Start in Dev Mode

Quarkus Dev Mode enables **live coding** — code changes are automatically reloaded without restarting the server.

```bash
./mvnw quarkus:dev
```

The API will be available at **http://localhost:8080**.

> **Note:** Quarkus ships with a Dev UI, available in dev mode at <http://localhost:8080/q/dev/>.

### API Endpoints

| Method | Endpoint     | Description             |
|--------|--------------|-------------------------|
| GET    | `/products`  | List all products       |
| POST   | `/products`  | Create a new product    |

### Example Requests

```bash
# Create a product
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name": "Keyboard", "price": 49.99, "quantity": 100}'

# List all products
curl http://localhost:8080/products
```

---

## Roadmap

- [x] Project scaffolding with Quarkus
- [x] Product entity with Hibernate Panache
- [x] REST endpoints (GET, POST)
- [ ] Add PUT and DELETE endpoints for full CRUD
- [ ] Dockerize the application (`Dockerfile.jvm`)
- [ ] Deploy to Ubuntu Server VM with Docker
- [ ] Set up K3s cluster for container orchestration
- [ ] Configure Harness CI/CD pipeline for automated build & deployment
- [ ] Add integration tests with `@QuarkusTest`
- [ ] Production-ready PostgreSQL configuration

---

## License

This project is for learning and demonstration purposes.
