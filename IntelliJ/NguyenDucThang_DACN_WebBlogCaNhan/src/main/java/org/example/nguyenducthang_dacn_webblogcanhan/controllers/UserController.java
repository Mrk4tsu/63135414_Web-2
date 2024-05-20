package org.example.nguyenducthang_dacn_webblogcanhan.controllers;

import org.example.nguyenducthang_dacn_webblogcanhan.models.User;
import org.example.nguyenducthang_dacn_webblogcanhan.services.UserService;
import org.example.nguyenducthang_dacn_webblogcanhan.utils.UserNotFoundException;
import org.example.nguyenducthang_dacn_webblogcanhan.utils.Utilities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/nguoi-dung")
    public String showUserPage(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "user/user";
    }

    @GetMapping("/nguoi-dung/them-moi")
    public String showAddUserPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Tạo mới người dùng");
        return "user/user-form";
    }

    @PostMapping("/nguoi-dung/save")
    public String saveUser(@ModelAttribute User user, RedirectAttributes attributes){
        service.save(user);

        System.out.println(user.toString());

        attributes.addFlashAttribute("message", "Tạo mới người dùng thành công.");
        return Utilities.Redirect("nguoi-dung");
    }
    @GetMapping("/chinh-sua/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes){
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (" + id + ")");

            return "user/user-form";
        } catch (UserNotFoundException e) {
            attributes.addFlashAttribute("message", "The user has been created successfully.");
            return Utilities.Redirect("users");
        }
    }
}
