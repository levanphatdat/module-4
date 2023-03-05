package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @GetMapping("/currency")
    public String currency(@RequestParam(required = false) Double usd, Model model) {
        if (usd == null) {
            return "/currency";
        }
        double vnd = usd * 23822.5;
        model.addAttribute("vnd", vnd);
        return "/currency";
    }
}
