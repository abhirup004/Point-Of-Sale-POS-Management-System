# Point of Sale (POS) Management System

A full-stack Point of Sale (POS) management application designed for managing inventory, master data, purchase workflows, vendor associations, user roles, and security authentication.

The repository is structured as a full-stack workspace containing both the RESTful Spring Boot Backend API and the React + Vite Frontend UI.

---

## Repository Structure

```text
Point-Of-Sale-POS-Management-System/
├── src/                    # Spring Boot backend source code
├── pom.xml                 # Maven dependencies and build configuration
├── HELP.md                 # Spring Boot reference guide
├── posfe/                  # React + Vite frontend application
│   ├── src/                # React components, pages, and hooks
│   ├── public/             # Static assets and icons
│   └── package.json        # Frontend dependencies and scripts
└── README.md               # Main repository documentation (this file)
```

---

## Features

### Authentication & Access Control
- **JWT Authentication**: Secure stateless token authentication with BCrypt password hashing.
- **Role-Based Access**: Granular user administration (`ROLE_ADMIN` and `ROLE_USER`).
- **OTP Password Recovery**: Email-based One-Time Password (OTP) verification for resetting credentials.

### Master Data Management
- **Company & Unit Management**: Create, view, update, search, sort, and status-toggle business entities.
- **Product Catalog**: Manage items with unit definitions, company association, and MRP details.
- **Vendor & Financial Year Tracking**: Vendor directory with vendor-to-company mapping and financial year tracking.

### Purchase & Inventory Workflows
- **Purchase Invoices**: Multi-item purchase records with tax, discounts, and itemized calculations.
- **Stock Management**: Transactional stock level updates upon purchase creation and automated inventory adjustments on purchase deletion.

### Modern Responsive Frontend
- **Interactive Dashboard**: Modern UI built with React 19, Vite, Tailwind CSS, and React Router.
- **Data Management Views**: Search, pagination, modal forms, soft deletion confirmations, and detail popups.

---

## Technology Stack

| Layer | Technologies |
| --- | --- |
| **Backend** | Java 21, Spring Boot 3, Spring Security, Spring Data JPA, Spring Mail, Hibernate, MySQL, Maven, JJWT, Lombok |
| **Frontend** | React 19, React Router, Vite, Tailwind CSS, Axios, JavaScript (ES6+) |
| **API Documentation** | Swagger / OpenAPI 3.0 |

---

## Quick Start Guide

### Prerequisites
- **JDK 21** or later
- **Node.js 20** or later & `npm`
- **MySQL 8.0** or later

---

### 1. Backend Setup (Spring Boot)

1. **Database Setup**: Create a MySQL database (e.g., `pos_db`).
2. **Configuration**: Configure your database connection and SMTP settings in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=YOUR_MYSQL_USER
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   ```
3. **Run Backend**:
   ```bash
   ./mvnw spring-boot:run
   ```
   *The backend will start at `http://localhost:8080`.*
   *Swagger API docs available at: `http://localhost:8080/swagger-ui/index.html`*

---

### 2. Frontend Setup (React + Vite)

1. **Navigate to `posfe`**:
   ```bash
   cd posfe
   ```
2. **Install Dependencies & Start**:
   ```bash
   npm install
   npm run dev
   ```
   *The frontend dev server will launch at `http://localhost:5173`.*

---

## Key REST API Endpoints

| Resource | Base Path | Description |
| --- | --- | --- |
| Authentication | `/api/auth` | Login, register, and OTP password recovery |
| Application Users | `/api/users` | User access management |
| Companies | `/api/companies` | Business company CRUD operations |
| Units | `/api/units` | Measurement units (e.g. Kg, Pcs) |
| Products | `/api/products` | Item catalog and pricing |
| Vendors | `/api/vendors` | Vendor directory and company mapping |
| Financial Years | `/api/financialyears` | Financial accounting periods |
| Purchases | `/api/purchases` | Purchase invoices & stock updating |

---

## Security Best Practices
Do not commit sensitive database credentials, JWT secrets, or SMTP mail passwords into source control. Use environment variables or local profiles (`application-DEV.properties`) for local development.
