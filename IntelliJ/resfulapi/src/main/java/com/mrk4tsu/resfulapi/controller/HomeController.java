package com.mrk4tsu.resfulapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, this is a RESTful API!";
    }
}
