package com.mrkatsu.mywebapp.controllers;

import com.mrkatsu.mywebapp.models.User;
import com.mrkatsu.mywebapp.services.UserService;
import com.mrkatsu.mywebapp.utilities.UserNotFoundException;
import com.mrkatsu.mywebapp.utilities.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String getListUser(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Create New User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes attributes) {
        service.save(user);

        attributes.addFlashAttribute("message", "The user has been created successfully.");
        return Utils.Redirect("users");
    }

    @GetMapping("/users/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (" + id + ")");

            return "user_form";
        } catch (UserNotFoundException e) {
            attributes.addFlashAttribute("message", "The user has been created successfully.");
            return Utils.Redirect("users");
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        try {
            service.delete(id);
            attributes.addFlashAttribute("message", "User Id: " + id + " has been deleted");
        } catch (UserNotFoundException e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return Utils.Redirect("users");
    }
}
