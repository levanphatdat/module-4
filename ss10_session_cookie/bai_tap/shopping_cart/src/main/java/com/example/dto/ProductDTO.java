package com.example.dto;

import java.util.Objects;

public class ProductDTO {
    private int id;
    private String name;
    private String img;
    private double price;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String img, double price, String description) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return id == that.id;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
