package com.example.controller;

import com.example.dto.CartDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    //    @ModelAttribute("cart")
//    public Cart setupCart(){
//        return new Cart();
//    }
//
//    @GetMapping("/shopping-cart")
//    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
//        ModelAndView modelAndView = new ModelAndView("/cart");
//        modelAndView.addObject("cart",cart);
//        return modelAndView;
//    }
    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDTO cart) {
        return new ModelAndView("listCart", "cart", cart);
    }
}
