package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.controllers.admin;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Category;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.User;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.UserService;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired private UserService userService;
    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }
    @GetMapping("/user/add")
    public String add(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "admin/user/add";
    }

    @PostMapping("/user/add")
    public String save(@ModelAttribute("user") User user) {
        user.setCreated_at(Utilities.getCurrentDate());
        user.setPassword(Utilities.md5(user.getPassword()));
        user.setStatus(true);
        if (this.userService.save(user)) {
            return "redirect:/admin/";
        }
        return "admin/user/add";
    }
}
