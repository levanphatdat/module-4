package com.example.service;

import com.example.model.Order;
import com.example.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public List<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return iOrderRepository.findById(id).orElse(null);
    }

    @Override
    public Order findByCode(int code) {
        return iOrderRepository.findByCodeContains(code);
    }

    @Override
    public void create(Order order) {
        iOrderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        iOrderRepository.delete(order);
    }
}
