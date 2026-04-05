# FullStack Skill-8 – Spring Boot JPQL & Query Methods

**Student:** Ch. Venkata Sai Nikesh | **ID:** 2400080138

## Overview
A product search module for an e-commerce application built with Spring Boot and Spring Data JPA.
Implements derived query methods and JPQL queries with `@Query` for:
- Category-based search
- Price range filtering
- Price sorting

## Tech Stack
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 In-Memory Database
- Maven

## Project Structure
```
src/main/java/com/fsad/jpql/
├── ProductJpqlApplication.java   # Main entry point
├── Product.java                  # JPA Entity
├── ProductRepository.java        # Derived queries + JPQL @Query
├── ProductController.java        # REST endpoints
└── DataLoader.java               # Pre-loads 10 sample products
```

## REST Endpoints

| Endpoint | Method | Type | Description |
|---|---|---|---|
| `GET /products` | Derived | `findAll()` | All products |
| `GET /products/category/{category}` | Derived | `findByCategory()` | Products by category |
| `GET /products/filter?min=&max=` | Derived | `findByPriceBetween()` | Products in price range |
| `GET /products/sorted` | JPQL | `ORDER BY p.price ASC` | All sorted cheapest first |
| `GET /products/expensive/{price}` | JPQL | `WHERE p.price > :price` | Products above price |
| `GET /products/search/{category}` | JPQL | `LOWER(p.category)=LOWER(:cat)` | Case-insensitive category |
| `POST /products` | — | `save()` | Insert new product |

## Running the App

```bash
mvn spring-boot:run
```

App starts on `http://localhost:8080`  
H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:productdb`)

## Sample Products Loaded
| Name | Category | Price (₹) |
|---|---|---|
| Laptop Pro | Electronics | 75,000 |
| Wireless Mouse | Electronics | 699 |
| USB-C Hub | Electronics | 2,499 |
| Cotton T-Shirt | Clothing | 499 |
| Denim Jacket | Clothing | 2,999 |
| Running Shoes | Footwear | 3,499 |
| Leather Wallet | Accessories | 899 |
| Smart Watch | Electronics | 18,999 |
| Yoga Mat | Sports | 799 |
| Protein Powder | Health | 1,999 |
