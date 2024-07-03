package com.knight2689.shop.service.Impl;

import com.knight2689.shop.constant.ProductCategory;
import com.knight2689.shop.model.Product;
import com.knight2689.shop.repository.ProductRepository;
import com.knight2689.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public List<Product> getAllProducts(ProductCategory category, String search) {
        if (category == null && (search == null || search.isEmpty())) {
            return productRepository.findAll();
        }
        return productRepository.findByCategoryAndSearch(category, search);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
