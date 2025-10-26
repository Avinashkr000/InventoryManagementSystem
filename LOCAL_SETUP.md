# 🚀 Local Development Setup Guide

Bhai yahan step-by-step process hai dono repositories ko local laptop pe run karne ke liye.

## Prerequisites 📋

### Required Software:
- **Java 21** (OpenJDK ya Oracle JDK)
- **MySQL** (8.0 ya latest)
- **Node.js** (18+ recommended)
- **npm** ya **yarn**
- **Git** (already installed lagta hai)

### Check Karo Installed Hai Ya Nahi:
```bash
# Java version check
java --version

# Node version check
node --version
npm --version

# MySQL check
mysql --version
```

---

## 🗄️ Database Setup (MySQL)

### 1) MySQL Start Karo
```bash
# Windows (if using XAMPP)
Start XAMPP Control Panel -> Start MySQL

# macOS/Linux
sudo service mysql start
# OR
brew services start mysql
```

### 2) Database Create Karo
```sql
# MySQL Command Line ya phpMyAdmin mein:
CREATE DATABASE inventory_db;

# User create karo (optional, root bhi use kar sakte ho)
CREATE USER 'inventory_user'@'localhost' IDENTIFIED BY 'inventory123';
GRANT ALL PRIVILEGES ON inventory_db.* TO 'inventory_user'@'localhost';
FLUSH PRIVILEGES;
```

---

## ⚙️ Backend Setup (Spring Boot)

### 1) Repository Clone Karo (Already done)
```bash
cd your-projects-folder
git clone https://github.com/Avinashkr000/InventoryManagementSystem.git
cd InventoryManagementSystem
```

### 2) Database Configuration
`src/main/resources/application.properties` file create/update karo:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Server Configuration
server.port=8080

# JWT Configuration (when implemented)
app.security.jwt.secret=mySecretKey123456789
app.security.jwt.expiration=3600000

# Logging
logging.level.com.avinash.InventoryManagementSystem=DEBUG
```

### 3) Backend Run Karo
```bash
# Method 1: Maven Wrapper (Recommended)
./mvnw clean spring-boot:run

# Method 2: If mvnw permission issue (Windows)
mvnw.cmd clean spring-boot:run

# Method 3: Direct Maven (if installed)
mvn clean spring-boot:run

# Method 4: IDE se run karo
# IntelliJ/Eclipse mein main class (InventoryManagementSystemApplication.java) run karo
```

### 4) Backend Test Karo
```bash
# Browser mein ya Postman mein:
http://localhost:8080

# Health check (if actuator configured):
http://localhost:8080/actuator/health
```

---

## 🎨 Frontend Setup (React)

### 1) Frontend Repository Clone Karo (Already done)
```bash
cd your-projects-folder
git clone https://github.com/Avinashkr000/inventory-management-frontend.git
cd inventory-management-frontend
```

### 2) Dependencies Install Karo
```bash
# npm use karo
npm install

# Ya phir yarn use karo (if preferred)
yarn install
```

### 3) Environment Variables Check Karo
`.env` file mein ensure karo:
```bash
REACT_APP_API_BASE_URL=http://localhost:8080/api
REACT_APP_NAME=Inventory Management System
REACT_APP_VERSION=1.0.0
REACT_APP_DEBUG=true
```

### 4) Frontend Run Karo
```bash
# Development server start karo
npm start

# Ya yarn use karo
yarn start
```

Frontend automatically browser mein `http://localhost:3000` pe open ho jayega.

---

## 🔧 Common Issues & Solutions

### Backend Issues:

**1) MySQL Connection Error:**
```bash
# MySQL service running hai check karo
sudo service mysql status

# Password correct hai check karo application.properties mein
```

**2) Port 8080 Already in Use:**
```bash
# Port kill karo
sudo lsof -t -i:8080 | xargs kill -9

# Ya application.properties mein port change karo
server.port=8081
```

**3) Maven Permission Error:**
```bash
# Maven wrapper ko executable banao
chmod +x mvnw
```

### Frontend Issues:

**1) npm install fails:**
```bash
# Node modules clear karo
rm -rf node_modules package-lock.json
npm install
```

**2) Proxy Error (API calls fail):**
```bash
# Backend running hai check karo localhost:8080 pe
# .env file mein REACT_APP_API_BASE_URL correct hai check karo
```

**3) Port 3000 Already in Use:**
```bash
# Different port use karo
PORT=3001 npm start
```

---

## 🚦 Complete Workflow

### 1) Start MySQL
```bash
sudo service mysql start
```

### 2) Backend Start Karo (Terminal 1)
```bash
cd InventoryManagementSystem
./mvnw spring-boot:run
```

### 3) Frontend Start Karo (Terminal 2)
```bash
cd inventory-management-frontend
npm start
```

### 4) Browser mein ja kar test karo:
- **Frontend:** http://localhost:3000
- **Backend API:** http://localhost:8080/api
- **Login:** Demo credentials use karo (admin/admin123)

---

## 📝 Development Tips

### Hot Reload:
- **Backend:** Spring Boot DevTools automatically restart karega
- **Frontend:** React automatically refresh karega

### Testing API:
```bash
# Postman ya curl use karo
curl -X GET http://localhost:8080/api/products
```

### Database Check:
```bash
# MySQL command line
mysql -u root -p
USE inventory_db;
SHOW TABLES;
```

---

## 🐳 Docker Alternative (Optional)

Agar Docker use karna hai:

```bash
# Backend build & run
cd InventoryManagementSystem
docker build -t inventory-backend .
docker run -p 8080:8080 inventory-backend

# MySQL via Docker
docker run -d --name mysql-inventory -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_DATABASE=inventory_db -p 3306:3306 mysql:8.0
```

---

## 📞 Support

Agar koi issue aaye toh:
1. Check karo logs properly
2. Google pe search karo error message
3. Stack Overflow check karo
4. GitHub issues create kar sakte ho

**Happy Coding! 🎉**