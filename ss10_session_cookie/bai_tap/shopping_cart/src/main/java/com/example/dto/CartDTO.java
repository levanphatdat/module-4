package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ProductDTO, Integer> productsMap = new HashMap<>();


    public Map<ProductDTO, Integer> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(Map<ProductDTO, Integer> productsMap) {
        this.productsMap = productsMap;
    }

    public void addProduct(ProductDTO productDto) {
        if (productsMap.containsKey(productDto)) {
            Integer currentValue = productsMap.get(productDto);
            productsMap.put(productDto, currentValue + 1);
        } else {
            productsMap.put(productDto, 1);
        }

    }
}
