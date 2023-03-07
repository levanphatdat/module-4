package com.example.controller;

import com.example.dto.UserDTO;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("list", iUserService.findAll());
        return "/list";
    }

    @GetMapping("/formCreate")
    public String formCreate(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute UserDTO userDTO, BindingResult bindingResult) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        this.iUserService.create(user);
        return "redirect:/list";
    }
}
