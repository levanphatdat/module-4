package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(String search);

    void create(Product product);

    Product findById(int id);

    void edit(Product product);

    void remove(int id);
}
