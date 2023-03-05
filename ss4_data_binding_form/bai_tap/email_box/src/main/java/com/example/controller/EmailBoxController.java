package com.example.controller;

import com.example.model.EmailBox;
import com.example.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emailBox")
public class EmailBoxController {
    @Autowired
    private IEmailBoxService iEmailBoxService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("emailBox", iEmailBoxService.getInfo());
        model.addAttribute("languages", iEmailBoxService.languages());
        model.addAttribute("pageSize", iEmailBoxService.pageSize());
        return "/update";
    }

    @PostMapping("")
    public String formUpdate(@ModelAttribute EmailBox emailBox, Model model) {
        iEmailBoxService.update(emailBox);
        model.addAttribute("emailBox", emailBox);
        return "/form";
    }
}
