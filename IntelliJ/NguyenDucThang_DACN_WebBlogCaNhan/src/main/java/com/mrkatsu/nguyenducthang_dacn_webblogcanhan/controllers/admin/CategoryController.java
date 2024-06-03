package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.controllers.admin;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Category;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.CategoryService;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.UserService;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.utils.Utilities;
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
    @Autowired
    private UserService userService;

    @RequestMapping("/category")
    public String index(Model model) {
        var cate = categoryService.getAll();
        model.addAttribute("categories", cate);

        return "admin/category/index";
    }

    @GetMapping("/category/add")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        return "admin/category/add";
    }

    @PostMapping("/category/add")
    public String save(@ModelAttribute("category") Category category) {
        category.setCreated_at(Utilities.getCurrentDate());
        category.setUpdated_at(Utilities.getCurrentDate());
        String meta = Utilities.toMetaTitle(category.getName());
        category.setMeta_title(meta);
        if (this.categoryService.save(category)) {
            return "redirect:/admin/category";
        }
        return "admin/category/add";
    }

    @GetMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Category category = this.categoryService.getById(id);
        model.addAttribute("category", category);

        return "admin/category/edit";
    }

    @PostMapping("/category/edit")
    public String update(@ModelAttribute("category") Category category) {
        if (category.getMeta_title() == null || category.getMeta_title().isEmpty()) {
            String meta = Utilities.toMetaTitle(category.getName());
            category.setMeta_title(meta);
        }
        category.setUpdated_at(Utilities.getCurrentDate());
        if (this.categoryService.save(category)) {
            return "redirect:/admin/category";
        }
        return "admin/category/edit";
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (this.categoryService.delete(id)) {
            return "redirect:/admin/category";
        }
        return "admin/category/index";
    }
}
