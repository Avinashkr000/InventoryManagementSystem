# 📦 Inventory Management System

A backend project built with **Java**, **Spring Boot**, **MySQL**, and **JWT-based Security**. The goal is to design a real-world Inventory Management System with clean architecture, feature-wise branching, and DevOps-ready practices.

---


---

## 🚀 Features (Status)

* ✅ Project structure setup (Maven + Spring Boot)
* ✅ Core entities implemented (**User**, **Product**, **Order**, **Transaction**)
* ✅ MySQL integration (Hibernate + JPA)
* ✅ Bean validation via `jakarta.validation`
* ⏳ DTOs for clean request/response handling
* ⏳ JWT authentication & authorization flow
* ⏳ Centralized exception handling & global error response

> ⏳ = In Progress / Upcoming

---

## 🛠️ Tech Stack

* **Language:** Java 21
* **Frameworks:** Spring Boot, Spring Data JPA, Spring Security
* **Database:** MySQL (via Hibernate ORM)
* **Auth:** JWT (JSON Web Tokens)
* **Dev Tools:** Lombok, ModelMapper, Maven
* **Testing (planned):** JUnit 5, Mockito

---

## ⚙️ Setup Instructions

### 1) Clone the repository

```bash
git clone https://github.com/Avinashkr000/InventoryManagementSystem.git
cd InventoryManagementSystem
```

### 2) Configure your database

Create a database named `inventory_db` (or use any name you prefer) and update your Spring properties:

```properties
# src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# (Will be used once JWT is added)
app.security.jwt.secret=change_this_in_prod
app.security.jwt.expiration=3600000
```

### 3) Run the app

Using Maven wrapper (recommended):

```bash
./mvnw spring-boot:run
```

Or package and run:

```bash
./mvnw clean package
java -jar target/inventory-*.jar
```

---

## 🧱 Project Structure

```
InventoryManagementSystem/
 ├─ src/main/java/com/avinash/InventoryManagementSystem/
 │   ├─ models/         # Entities (User, Product, Transaction, Order)
 │   ├─ repository/     # JPA Repositories
 │   ├─ controller/     # REST Controllers (upcoming)
 │   ├─ dto/            # DTOs (upcoming)
 │   ├─ security/       # JWT & Security config (upcoming)
 │   └─ exceptions/     # Custom Exceptions & Global Handler (upcoming)
 ├─ src/main/resources/
 │   └─ application.properties
 └─ pom.xml
```

---

## 🔐 Authentication (Planned)

* Implement JWT login endpoint (`/api/auth/login`) returning access token
* Secure product/order endpoints with role-based access (`ROLE_ADMIN`, `ROLE_USER`)
* Use `OncePerRequestFilter` to validate tokens per request

---

## 📚 API (Initial Draft)

> Endpoints will be finalized once DTOs & controllers are added.

**Products**

* `POST /api/products` — create product *(admin)*
* `GET /api/products` — list products
* `GET /api/products/{id}` — get product
* `PUT /api/products/{id}` — update *(admin)*
* `DELETE /api/products/{id}` — delete *(admin)*

**Orders**

* `POST /api/orders` — create order
* `GET /api/orders/{id}` — get order
* `GET /api/orders` — list orders (with filters soon)

**Transactions/Inventory**

* `POST /api/transactions` — stock-in / stock-out
* `GET /api/transactions` — history

---

## 🧪 Testing (Planned)

* Unit tests for services & repositories (JUnit 5, Mockito)
* Simple integration tests using `@SpringBootTest` & H2 (optional)

---

## 🧭 Roadmap

* [x] Entities + DB integration
* [ ] DTO layer + ModelMapper
* [ ] JWT Authentication & Authorization
* [ ] REST Controllers for CRUD APIs
* [ ] Global Exception Handling & Logging
* [ ] Unit & Integration Tests (JUnit, Mockito)
* [ ] Swagger/OpenAPI Docs
* [ ] Dockerization
* [ ] CI/CD Pipeline (GitHub Actions)

---

## 🧰 Dev Tips

* Use **feature branches**: `feature/dtos`, `feature/jwt`, `feature/controllers`, etc.
* Use **PRs** to merge to `develop`, then release via `main`.
* Keep entities lean; push serialization logic into **DTOs** & **mappers**.

---

## 📸 Diagram (Optional Alternate View)

![Flow Diagram](https://github.com/user-attachments/assets/0009f2ee-6413-4ce4-889c-00bd789e4b4f)

---

## 🤝 Contributing

1. Fork the repo
2. Create your feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m "feat: add amazing feature"`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

---

## 📧 Contact

**Avinash Kumar**
📩 Email: **[ak749299.ak@gmail.com](mailto:ak749299.ak@gmail.com)**
🔗 LinkedIn: **[https://www.linkedin.com/in/avinash-java-backend/](https://www.linkedin.com/in/avinash-java-backend/)**
🐙 GitHub: **[https://github.com/Avinashkr000](https://github.com/Avinashkr000)**

