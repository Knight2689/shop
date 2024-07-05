package com.knight2689.shop.service;

import com.knight2689.shop.dto.ProductQueryParams;
import com.knight2689.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product getProduct(Integer id);
    Page<Product> getAllProducts(ProductQueryParams productQueryParams, Pageable pageable);
    void deleteProduct(Integer id);
}
