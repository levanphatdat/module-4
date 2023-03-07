package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICategoryService {
    List<Category> findAllCategory();

    Category findCategoryById(int id);
}
