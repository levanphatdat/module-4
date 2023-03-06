package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;


    @GetMapping("")
    public String list(@RequestParam(name = "search", defaultValue = "") String search, Model model,
                       @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.listAll(search, pageable);
        model.addAttribute("blog", blogs);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= blogs.getTotalPages(); i++) {
            pageNumberList.add(i);
        }

        model.addAttribute("pageNumberList", pageNumberList);
        return "/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("category", categoryService.findAllCategory());
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(name = "blog") Blog blog) {
        blogService.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findAllCategory());
        model.addAttribute("editBlog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute(name = "editBlog") Blog blog) {
        blogService.edit(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/information/{id}")
    public String info(@PathVariable int id, Model model) {
        model.addAttribute("info", blogService.findById(id));
        return "/info";
    }
}
