package com.fsad.jpql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository repo;

    public DataLoader(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new Product("Laptop Pro",      "Electronics", 75000.0));
        repo.save(new Product("Wireless Mouse",  "Electronics",   699.0));
        repo.save(new Product("USB-C Hub",       "Electronics",  2499.0));
        repo.save(new Product("Cotton T-Shirt",  "Clothing",      499.0));
        repo.save(new Product("Denim Jacket",    "Clothing",     2999.0));
        repo.save(new Product("Running Shoes",   "Footwear",     3499.0));
        repo.save(new Product("Leather Wallet",  "Accessories",   899.0));
        repo.save(new Product("Smart Watch",     "Electronics", 18999.0));
        repo.save(new Product("Yoga Mat",        "Sports",        799.0));
        repo.save(new Product("Protein Powder",  "Health",       1999.0));
    }
}
