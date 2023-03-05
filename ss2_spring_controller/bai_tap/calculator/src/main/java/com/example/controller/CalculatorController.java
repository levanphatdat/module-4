package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("/calculator")
    public String show() {
        return "/index";
    }

    @PostMapping("/calculator")
    public String result(@RequestParam double num1, @RequestParam double num2, @RequestParam String calculation, Model model) {
        model.addAttribute("result", iCalculatorService.calculator(num1, num2, calculation));
        return "/index";
    }
}
