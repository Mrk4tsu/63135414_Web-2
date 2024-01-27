package com.mrkatsu.mywebapp.controllers;

import com.mrkatsu.mywebapp.models.User;
import com.mrkatsu.mywebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public String getListUser(Model model){
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
    @GetMapping("/users/new")
    public String showUserForm(Model model){
        model.addAttribute("user", new User());
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user){
        try {
            service.save(user);


            return "redirect:/users";
        }catch (Exception exception){

            System.out.printf("Lỗi xảy ra: " + exception.toString());
            return "redirect:/users";

        }

    }
}
