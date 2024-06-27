package com.knight2689.shop.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer productId;
    private String productName;
    private String category;
    private Integer price;
    private Integer stock;
    private String description;
    private String imagePath;
}
