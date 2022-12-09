package com.example.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class WelcomeController {
    
    @GetMapping
    public String intro(){
        return "Hello Introduction Java Spring Boot";
    }
};
