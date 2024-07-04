package com.knight2689.shop.service;

import com.knight2689.shop.dto.ProductQueryParams;
import com.knight2689.shop.model.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product getProduct(Integer id);
    List<Product> getAllProducts(ProductQueryParams productQueryParams, Sort sort);
    void deleteProduct(Integer id);
}
