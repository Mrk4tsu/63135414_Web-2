package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.controllers;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Content;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @Autowired private ContentService contentService;

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/blog")
    public String blog(Model model){
        var list = contentService.getAll();
        model.addAttribute("contents", list);
        return "blog";
    }
    @GetMapping("/content/{id}")
    public String reservationDetail(@PathVariable("id") int id, Model model) {
        Content content = contentService.getById(id);
        model.addAttribute("content", content);
        return "/detail";
    }
}
