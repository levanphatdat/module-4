package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    //            @GetMapping("")
//    public ResponseEntity<List<Blog>> list() {
//        List<Blog> blogList = blogService.findAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }
    @GetMapping("")
    public Page<Blog> list(@RequestParam(value = "", required = false) String search,
                           @PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogList = blogService.findBlogByTitleContaining(search, pageable);
        List<Blog> blogs = blogList.toList();
        return new PageImpl<>(blogs, pageable, blogList.getTotalElements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> infoBlog(@PathVariable int id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> listCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Set<Blog>> infoCategory(@PathVariable int id) {
        Category category = categoryService.findCategoryById(id);
        if (category.getBlogSet().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getBlogSet(), HttpStatus.OK);

    }
}
