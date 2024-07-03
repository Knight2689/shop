package com.knight2689.shop.repository;

import com.knight2689.shop.constant.ProductCategory;
import com.knight2689.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE " +
            "(:category IS NULL OR p.category = :category) AND " +
            "(:search IS NULL OR :search = '' OR p.productName LIKE %:search% OR p.description LIKE %:search%)")
    List<Product> findByCategoryAndSearch(@Param("category") ProductCategory category, @Param("search") String search);
}
