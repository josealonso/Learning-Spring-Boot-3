package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    
    @GetMapping("/index")
    public String hello() {
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, 
            Model model) {
        model.addAttribute("name", name.toUpperCase()); // Add the name parameter to the model
        return "greeting";
    }
    
}
