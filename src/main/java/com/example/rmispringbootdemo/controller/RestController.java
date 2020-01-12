package com.example.rmispringbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/api/servletpath")
    public String goodMorning() {
        return "Hello World";
    }

    @GetMapping("/api/customlogin")
    public String bye() {
        return "Hello World";
    }
}