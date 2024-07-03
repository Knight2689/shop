package com.knight2689.shop.service;

import com.knight2689.shop.constant.ProductCategory;
import com.knight2689.shop.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product getProduct(Integer id);
    List<Product> getAllProducts(ProductCategory category, String search);
    void deleteProduct(Integer id);
}
