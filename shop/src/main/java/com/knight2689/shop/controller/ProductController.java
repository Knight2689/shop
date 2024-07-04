package com.knight2689.shop.controller;

import com.knight2689.shop.constant.ProductCategory;
import com.knight2689.shop.dto.ProductQueryParams;
import com.knight2689.shop.model.Product;
import com.knight2689.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id,
                                                 @RequestBody Product product){
        product.setProductId(id);
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            // 查詢條件
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            // 排序條件
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) String sortDirection
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);

        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection != null ? sortDirection : "asc"),
                sortField != null ? sortField : "createDate");


        List<Product> products = productService.getAllProducts(productQueryParams,sort);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
