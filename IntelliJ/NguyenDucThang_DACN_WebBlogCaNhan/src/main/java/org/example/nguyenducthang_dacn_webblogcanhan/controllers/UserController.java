package org.example.nguyenducthang_dacn_webblogcanhan.controllers;

import org.example.nguyenducthang_dacn_webblogcanhan.models.User;
import org.example.nguyenducthang_dacn_webblogcanhan.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/nguoi-dung")
    public String showUserPage(Model model){
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "user";
    }
    @GetMapping("/nguoi-dung/them-nguoi-dung")
    public String showAddUserPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Create New User");
        return "user-form";
    }
    @PostMapping("/nguoi-dung/save{id}")
    public String saveUser(User user){
        service.save(user);
        return "redirect:/nguoi-dung";
    }
}
