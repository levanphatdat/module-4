package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> listAll(String search);

    Blog findById(int id);

    void create(Blog blog);

    void edit(Blog blog);

    void delete(int id);
}
