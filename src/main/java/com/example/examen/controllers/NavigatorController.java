package com.example.examen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NavigatorController {
    
    @GetMapping
    public String redireccion1() {
        return "index";
    }
}