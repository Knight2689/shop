package com.knight2689.shop.repository;

import com.knight2689.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
