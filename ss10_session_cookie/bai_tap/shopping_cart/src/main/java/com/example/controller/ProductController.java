package com.example.controller;

import com.example.dto.CartDTO;
import com.example.dto.ProductDTO;
import com.example.model.Product;
import com.example.service.IProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDTO setupCart() {
        return new CartDTO();
    }

    @GetMapping("")
    public String getProduct(Model model,
                             @CookieValue(value = "idProduct", defaultValue = "-1") int idProduct) {
        if (idProduct != -1) {
            model.addAttribute("idProduct",
                    productService.findById(idProduct).get());
        }
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail", "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addProduct(@PathVariable int id,
                             @SessionAttribute("cart") CartDTO cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDTO productDto = new ProductDTO();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/product";
    }
}
