package com.example.repositiry;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
//    Iterable<Product> findAll();
//    Optional<Product> findById(Long id);

}
