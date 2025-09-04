# 📦 Inventory Management System  

A backend project built with **Java**, **Spring Boot**, **MySQL**, and **JWT-based Security**.  
The goal is to design a real-world style Inventory Management System with clean architecture, feature-wise branching, and DevOps-ready practices.  

---

## 🚀 Features (Progress so far)  
- ✅ Project structure setup (Maven + Spring Boot)  
- ✅ Core Entities implemented (User, Product, Order, Transaction)  
- ✅ Database integration with MySQL (Hibernate + JPA)  
- ✅ Basic validation using `jakarta.validation`  
- 🔜 DTOs for clean request/response handling  
- 🔜 JWT authentication & authorization flow  
- 🔜 Exception handling & global error response  

---

## 🛠️ Tech Stack  
- **Language:** Java 21  
- **Frameworks:** Spring Boot, Spring Data JPA, Spring Security  
- **Database:** MySQL (with Hibernate)  
- **Authentication:** JWT (JSON Web Tokens)  
- **Dev Tools:** Lombok, ModelMapper, Maven  
- **Testing (planned):** JUnit, Mockito  

---

## ⚙️ Setup Instructions  

### 1️⃣ Clone the Repo  
```bash
git clone https://github.com/Avinashkr000/InventoryManagementSystem.git
cd InventoryManagementSystem


spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


./mvnw spring-boot:run

InventoryManagementSystem/
 ├── src/main/java/com/avinash/InventoryManagementSystem
 │    ├── models/        # Entities (User, Product, Transaction, Order)
 │    ├── repository/    # JPA Repositories
 │    ├── controller/    # REST Controllers (upcoming)
 │    ├── dto/           # DTOs (upcoming)
 │    ├── security/      # JWT & Security config (upcoming)
 │    └── exceptions/    # Custom Exceptions (upcoming)
 ├── src/main/resources/
 │    ├── application.properties
 └── pom.xml

🔮 Roadmap

 Entities + DB Integration

 DTOs Layer

 JWT Authentication & Authorization

 REST Controllers for CRUD APIs

 Exception Handling & Logging

 Unit & Integration Tests (JUnit, Mockito)

 Swagger API Documentation

 Dockerize & CI/CD pipeline

📧 Contact

Avinash Kumar
📩 Email: ak749299.ak@gmail.com

🔗 LinkedIn https://www.linkedin.com/in/avinash-java-backend/

🐙 GitHub https://github.com/Avinashkr000



classDiagram
    class User {
        -id: Long
        -username: String
        -password: String
        -email: String
        -role: String
        +login(): Boolean
    }

    class Product {
        -id: Long
        -name: String
        -description: String
        -price: Double
        -quantity: Integer
        -sku: String
        +updateProduct()
        +removeProduct()
    }

    class Supplier {
        -id: Long
        -name: String
        -email: String
        +addProduct()
        +removeProduct()
    }

    class Order {
        -id: Long
        -orderDate: Date
        -status: String
        -subtotal: Double
        -notes: String
        +createOrder()
        +calculateSubtotal(): Double
    }

    class Inventory {
        -id: Long
        -lastUpdated: Date
        +updateStock()
        +checkStockLevel(): Integer
    }

    class Database {
        <<Interface>>
        +MySQL
    }

    class Backend {
        <<Interface>>
        +SpringBoot
    }

    class Frontend {
        <<Interface>>
        +React
    }

    User --> Product : Manages
    Supplier --> Product : Supplies
    Order --> Product : Contains 1..*
    Inventory --> Product : Tracks
    Backend --> Database : Uses
    Frontend --> Backend : Consumes
