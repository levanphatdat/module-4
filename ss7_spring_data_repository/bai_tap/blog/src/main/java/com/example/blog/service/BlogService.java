package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> listAll(String search) {
        return iBlogRepository.findBlogByTitleContaining(search);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.getById(id);
    }

    @Override
    public void create(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.delete(findById(id));
    }
}
