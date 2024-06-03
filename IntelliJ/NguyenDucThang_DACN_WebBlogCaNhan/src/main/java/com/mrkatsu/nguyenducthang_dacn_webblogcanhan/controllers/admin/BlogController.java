package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @GetMapping("/blog/add")
    public String add() {
        return "admin/blog/add";
    }
}
