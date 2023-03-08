package com.example.service;

import com.example.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    Order findById(int id);

    Order findByCode(int code);

    void create(Order order);

    void delete(Order order);
}
