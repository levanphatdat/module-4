package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/showList")
    public String showList(@RequestParam(name = "search", required = false) String search, Model model) {
        model.addAttribute("listProduct", iProductService.findAll(search));
        return "/list";
    }

    @PostMapping("/create")
    public String create(Product product) {
        iProductService.create(product);
        return "redirect:/product/showList";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product) {
        iProductService.edit(product);
        return "redirect:/product/showList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        iProductService.remove(id);
        return "redirect:/product/showList";
    }

    @GetMapping("/info/{id}")
    public String showInfo(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/info";
    }
}
