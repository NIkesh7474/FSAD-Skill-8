package com.fsad.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Task 2a — Derived: find by category
    List<Product> findByCategory(String category);

    // Task 2b — Derived: find by price range
    List<Product> findByPriceBetween(double min, double max);

    // Task 3a — JPQL: sort all products by price ASC
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllSortedByPrice();

    // Task 3b — JPQL: find products above a price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProducts(@Param("price") double price);

    // Task 3c — JPQL: find by category (case-insensitive)
    @Query("SELECT p FROM Product p WHERE LOWER(p.category) = LOWER(:cat)")
    List<Product> findByCategoryJPQL(@Param("cat") String category);
}
