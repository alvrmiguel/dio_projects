package com.nttdata.microservices.microservice1.repository;

import com.nttdata.microservices.microservice1.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // CRUD pronto
}
