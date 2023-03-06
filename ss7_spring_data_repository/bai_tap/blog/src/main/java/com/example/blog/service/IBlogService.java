package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IBlogService {
    Page<Blog> listAll(String search, Pageable pageable);

    Blog findById(int id);

    void create(Blog blog);

    void edit(Blog blog);

    void delete(int id);
}
