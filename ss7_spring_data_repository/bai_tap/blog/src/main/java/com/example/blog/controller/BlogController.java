package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String list(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
        model.addAttribute("list", blogService.listAll(search));
        return "/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
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
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute(name = "blog") Blog blog, Model model) {
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
