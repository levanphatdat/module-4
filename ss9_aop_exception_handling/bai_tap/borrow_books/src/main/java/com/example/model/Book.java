package com.example.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<Order> orders;

    public Book() {
    }

    public Book(Integer id, String name, int quantity, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
