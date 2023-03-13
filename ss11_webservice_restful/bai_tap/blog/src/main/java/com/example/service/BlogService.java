package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findBlogByTitleContaining(String search, Pageable pageable) {
        return blogRepository.findBlogByTitleContaining(search, pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }
}
