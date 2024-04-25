package org.example.nguyenducthang_dacn_webblogcanhan.controllers;

import org.example.nguyenducthang_dacn_webblogcanhan.models.User;
import org.example.nguyenducthang_dacn_webblogcanhan.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    @GetMapping("/nguoi-dung/them-moi")
    public String showAddUserPage(Model model){
            model.addAttribute("user", new User());
            model.addAttribute("pageTitle", "Tạo mới người dùng");
            return "user-form";
    }
    @PostMapping("/nguoi-dung/save")
    public String saveUser(@ModelAttribute User user, @RequestParam("avatar")MultipartFile avatarFile, RedirectAttributes attributes) throws IOException {
        String uploadDir = "static/images/" + user.getUsername();
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Save the file to the static directory
        String fileName = StringUtils.cleanPath(avatarFile.getOriginalFilename());
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(avatarFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        user.setAvatar(fileName); // Set the filename to the user's avatar field

        service.save(user);

        System.out.println(user.toString());

        attributes.addFlashAttribute("message", "Tạo mới người dùng thành công.");
        return "redirect:/nguoi-dung";
    }
}
