package com.fsad.jpql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Task 4a — GET all products
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // Task 4a — GET /products/category/{category}
    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Task 4b — GET /products/filter?min=&max=
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min,
                                @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Task 4c — GET /products/sorted (JPQL)
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.findAllSortedByPrice();
    }

    // Task 4d — GET /products/expensive/{price} (JPQL)
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }

    // Task 3c — GET /products/search/{category} (JPQL case-insensitive)
    @GetMapping("/search/{category}")
    public List<Product> searchCat(@PathVariable String category) {
        return repo.findByCategoryJPQL(category);
    }

    // POST — insert new product
    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return repo.save(p);
    }
}
