package com.knight2689.shop.dto;

import com.knight2689.shop.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {
    private ProductCategory category;
    private String search;
}
