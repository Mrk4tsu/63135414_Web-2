package org.example.nguyenducthang_dacn_webblogcanhan.controllers;

import org.example.nguyenducthang_dacn_webblogcanhan.models.Category;
import org.example.nguyenducthang_dacn_webblogcanhan.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/danh-muc")
    public String showCategoryPage(Model model) {
        List<Category> listCategory = service.listAll();
        model.addAttribute("listCategory", listCategory);
        return "category/category";
    }
}
