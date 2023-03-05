package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    private static final Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("rain", "mưa");
        map.put("wind", "gió");
        map.put("warm", "ấm");
    }

    @GetMapping("/translate")
    public String translate(@RequestParam(required = false) String string, Model model) {
        if (string == null) {
            model.addAttribute("translate", "Không tìm thấy");
            return "/translate";
        }
        model.addAttribute("translate", map.get(string));
        return "/translate";
    }
}
