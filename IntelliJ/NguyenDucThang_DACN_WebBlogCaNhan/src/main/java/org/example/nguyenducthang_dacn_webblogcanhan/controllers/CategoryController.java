package org.example.nguyenducthang_dacn_webblogcanhan.controllers;

import org.example.nguyenducthang_dacn_webblogcanhan.models.Category;
import org.example.nguyenducthang_dacn_webblogcanhan.services.CategoryService;
import org.example.nguyenducthang_dacn_webblogcanhan.utils.Utilities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/danh-muc/them-moi")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category() {
            {
                setCreated_at(Utilities.getCurrentDate());
                setCreated_by("admin");
            }
        });
        model.addAttribute("pageTitle", "Thêm mới danh mục");
        return "category/category_form";
    }

    @PostMapping("/danh-muc/save")
    public String saveCategory(Category category, RedirectAttributes attributes) {

        String metaTitle = Utilities.toMetaTitle(category.getName());

        category.setMeta_title(metaTitle);
        category.setModified_by("admin");
        category.setModified_at(Utilities.getCurrentDate());
        category.setModified_at(Utilities.getCurrentDate());

        service.save(category);
        attributes.addFlashAttribute("message", "Thêm mới danh mục thành công.");
        return Utilities.Redirect("danh-muc");
    }
}
