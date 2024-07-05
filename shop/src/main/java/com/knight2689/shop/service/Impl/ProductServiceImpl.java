package com.knight2689.shop.service.Impl;

import com.knight2689.shop.dto.ProductQueryParams;
import com.knight2689.shop.model.Product;
import com.knight2689.shop.repository.ProductRepository;
import com.knight2689.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getProductId());
        if (existingProduct.isPresent()) {
            return productRepository.save(product);
        } else {
            throw new RuntimeException("找不到商品" + product.getProductId());
        }
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> getAllProducts(ProductQueryParams productQueryParams, Pageable pageable) {
        if (productQueryParams.getCategory() == null && (productQueryParams.getSearch() == null || productQueryParams.getSearch().isEmpty())) {
            return productRepository.findAll(pageable);
        }
        return productRepository.findByCategoryAndSearch(productQueryParams.getCategory(), productQueryParams.getSearch(), pageable);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
