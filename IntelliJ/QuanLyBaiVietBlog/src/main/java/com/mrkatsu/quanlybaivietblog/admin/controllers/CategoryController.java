package com.mrkatsu.quanlybaivietblog.admin.controllers;

import com.mrkatsu.quanlybaivietblog.admin.models.Category;
import com.mrkatsu.quanlybaivietblog.admin.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public String category(Model model) {
        List<Category> list = categoryService.getAll();
        model.addAttribute("list", list);

        return "admin/category/index";
    }

    @GetMapping("/category/add")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        return "admin/category/add-category";
    }

    @PostMapping("/category/add")
    public String save(@ModelAttribute("category") Category category){
        if (this.categoryService.create(category)) {
            return "redirect:/admin/category";
        }
        return "admin/category/add-category";
    }
    @GetMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);

        return "admin/category/edit-category";
    }
    @PostMapping("/category/edit")
    public String update(@ModelAttribute("category") Category category) {
        if (this.categoryService.update(category)) {
            return "redirect:/admin/category";
        }
        return "admin/category/edit-category";
    }
    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (this.categoryService.delete(id)) {
            return "redirect:/admin/category";
        }
        return "admin/category/index";
    }
}
