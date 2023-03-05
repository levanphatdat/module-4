package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public List<Product> findAll(String search) {
        if (search == null) {
            search = "";
        }
        return iProductRepository.findAll(search);
    }

    @Override
    public void create(Product product) {
        iProductRepository.create(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void edit(Product product) {
        iProductRepository.edit(product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }
}
